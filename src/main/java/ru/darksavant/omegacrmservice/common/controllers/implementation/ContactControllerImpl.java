package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.ContactsController;
import ru.darksavant.omegacrmservice.common.entities.dto.ContactDto;
import ru.darksavant.omegacrmservice.common.entities.dto.UpdateContactDto;
import ru.darksavant.omegacrmservice.common.repositories.specifications.ContactsSpecification;
import ru.darksavant.omegacrmservice.common.services.interfaces.ContactsService;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ContactControllerImpl implements ContactsController {
    private final ContactsService contactsService;

    @Override
    public ResponseEntity<Page<ContactDto>> findContacts(Integer page, Integer pageSize, @NotNull String requestString) {
        return ResponseEntity.ok().body(contactsService.findAll(ContactsSpecification.build(requestString),page,pageSize).map(ContactDto::new));
    }

    @Override
    public ResponseEntity<ContactDto> findByID(Long id) {
        return ResponseEntity.ok().body(new ContactDto(contactsService.findByID(id)));
    }

    @Override
    public ResponseEntity<String> save(String FIO, String position, Integer primaryPhone, @Nullable Integer secondaryPhone, String primaryEmail, @Nullable String secondaryEmail) {
        contactsService.save(FIO, position, primaryPhone, secondaryPhone, primaryEmail, secondaryEmail);
        return ResponseEntity.ok().body("Контакт успешно создан");
    }

    @Override
    public ResponseEntity<ContactDto> update(UpdateContactDto dto) {
        return ResponseEntity.ok().body(new ContactDto(contactsService.update(dto)));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        contactsService.deleteById(id);
        return ResponseEntity.ok().body("Контакт успешно удален");
    }
}
