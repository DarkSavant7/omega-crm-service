package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Contact;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class ContactDto {

    private String FIO;

    private String position;

    private int primaryPhone;

    private int mobilePhone;

    private int workPhone;

    private String primaryEmail;

    private String secondaryEmail;

    private MedicalCardDto medicalCard;

    public ContactDto(Contact contact) {
        this.FIO=contact.getFIO();
        this.position=contact.getPosition();
        this.primaryPhone=contact.getPrimaryPhone();
        this.mobilePhone=contact.getMobilePhone();
        this.workPhone=contact.getWorkPhone();
        this.primaryEmail=contact.getPrimaryEmail();
        this.secondaryEmail=contact.getSecondaryEmail();
        this.medicalCard=new MedicalCardDto(contact.getMedicalCard());
    }
}
