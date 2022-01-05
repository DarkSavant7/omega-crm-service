package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Role;
import ru.darksavant.omegacrmservice.common.entities.User;
import ru.darksavant.omegacrmservice.common.entities.dto.RegisterUserDto;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDto;
import ru.darksavant.omegacrmservice.common.enums.UserStatus;
import ru.darksavant.omegacrmservice.common.repositories.UserRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.RoleService;
import ru.darksavant.omegacrmservice.common.services.interfaces.UserService;
import ru.darksavant.omegacrmservice.errors.BadRequestException;
import ru.darksavant.omegacrmservice.errors.ChangePasswordException;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<UserDto> createUser(RegisterUserDto dto) {
        log.info("Admin ask for registration new user with name {}, password {}, email {} and role {}", dto.getUsername(), dto.getPassword(), dto.getEmail(), dto.getRole());
        if (findByUsername(dto.getUsername()).isPresent())
            throw new BadRequestException("User with name " + dto.getUsername() + " already exist");
        if (roleService.findByName(dto.getRole()).isEmpty())
            throw new BadRequestException("User role " + dto.getRole() + " not found");
        User newUser = new User();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setStatus(UserStatus.CREATED);
        newUser.setRoles(List.of(roleService.findByName(dto.getRole()).get()));
        User registeredUser = userRepository.save(newUser);
        log.info("New user with name {} registered", dto.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDto(registeredUser));
    }

    public User blockUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setStatus(UserStatus.BLOCKED);
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllByIds(Collection<Long> ids) {
        return userRepository.findAllById(ids);
    }

    @Override
    public Page<UserDto> findAll(Specification<User> specification, Integer page, Integer pageSize) {
        return userRepository.findAll(specification, PageRequest.of(page - 1, pageSize)).map(UserDto::new);
    }

    @Override
    public UserDto changePassword(String name, String oldPassword, String newPassword) {
        User user = userRepository.findByUsername(name).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (user.getPassword().equals(passwordEncoder.encode(oldPassword))) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            user = userRepository.findByUsername(name).get();
        } else {
            throw new ChangePasswordException("Password do not mach.");
        }
        return new UserDto(user);
    }
}
