package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.darksavant.omegacrmservice.common.entities.Job;
import ru.darksavant.omegacrmservice.common.entities.Service;
import ru.darksavant.omegacrmservice.common.entities.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class JobDTO {

    private ServiceDTO service;

    private UserDTO user;

    private ContactDTO contact;

    private WorkPlaceDTO workPlace;

    private String createdAt;

    private String updatedAt;


    public JobDTO(Job job) {
        this.service=new ServiceDTO(job.getService());
        this.user= new UserDTO(job.getUser());
        this.contact= new ContactDTO(job.getContact());
        this.workPlace=new WorkPlaceDTO(job.getWorkPlace());
        this.createdAt=job.getCreatedAt().toString();
        this.updatedAt=job.getUpdatedAt().toString();
    }
}
