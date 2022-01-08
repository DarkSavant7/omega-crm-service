package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.*;

import java.util.Optional;


@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
    Optional<Job> findByService(Service service);
    Optional<Job> findByUser(User user);
    Optional<Job> findByContact(Contact contact);
    Optional<Job> findByWorkPlace(WorkPlace place);

}
