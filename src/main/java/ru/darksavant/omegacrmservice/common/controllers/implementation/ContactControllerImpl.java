package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.ContactsController;
import ru.darksavant.omegacrmservice.common.entities.dto.ContactDto;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDto;
import ru.darksavant.omegacrmservice.common.entities.dto.UpdateContactDto;
import ru.darksavant.omegacrmservice.common.services.interfaces.ContactsService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ContactControllerImpl implements ContactsController {
    private final ContactsService contactsService;

    @Override
    public ResponseEntity<Page<GoodDto>> findContacts(Integer page, Integer pageSize, @Nullable String FIO, @Nullable String position, @Nullable Integer phone, @Nullable String email) {
        return null;
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
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }
}
