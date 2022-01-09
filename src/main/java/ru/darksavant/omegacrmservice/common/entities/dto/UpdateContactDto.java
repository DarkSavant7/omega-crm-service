package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class UpdateContactDto {

    private String FIO;

    private String position;

    private int primaryPhone;

    private int mobilePhone;

    private int workPhone;

    private String primaryEmail;

    private String secondaryEmail;

}
