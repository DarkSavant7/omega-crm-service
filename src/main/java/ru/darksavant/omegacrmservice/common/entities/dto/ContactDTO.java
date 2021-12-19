package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.MedicalCard;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class ContactDTO {

    private String FIO;

    private String position;

    private int primaryPhone;

    private int mobilePhone;

    private int workPhone;

    private String primaryEmail;

    private String secondaryEmail;

    private MedicalCardDTO medicalCard;

    public ContactDTO(Contact contact) {
        this.FIO=contact.getFIO();
        this.position=contact.getPosition();
        this.primaryPhone=contact.getPrimaryPhone();
        this.mobilePhone=contact.getMobilePhone();
        this.workPhone=contact.getWorkPhone();
        this.primaryEmail=contact.getPrimaryEmail();
        this.secondaryEmail=contact.getSecondaryEmail();
        this.medicalCard=new MedicalCardDTO(contact.getMedicalCard());
    }
}
