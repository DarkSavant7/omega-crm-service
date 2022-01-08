package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Job;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class JobDto {

    private ServiceDto service;

    private UserDto user;

    private ContactDto contact;

    private WorkPlaceDto workPlace;

    private String createdAt;

    private String updatedAt;


    public JobDto(Job job) {
        this.service=new ServiceDto(job.getService());
        this.user= new UserDto(job.getUser());
        this.contact= new ContactDto(job.getContact());
        this.workPlace=new WorkPlaceDto(job.getWorkPlace());
        this.createdAt=job.getCreatedAt().toString();
        this.updatedAt=job.getUpdatedAt().toString();
    }
}
