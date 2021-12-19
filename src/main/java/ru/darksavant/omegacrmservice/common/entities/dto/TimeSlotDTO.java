package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.TimeSlot;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TimeSlotDTO {

    private String start;

    private String end;

    private JobDTO job;

    private StatusDTO status;

    private String createdAt;

    private String updatedAt;

    public TimeSlotDTO(TimeSlot slot) {
        this.start=slot.getStart().toString();
        this.end=slot.getEnd().toString();
        this.job=new JobDTO(slot.getJob());
        this.status=new StatusDTO(slot.getStatus());
        this.createdAt=slot.getCreatedAt().toString();
        this.updatedAt=slot.getUpdatedAt().toString();
    }
}
