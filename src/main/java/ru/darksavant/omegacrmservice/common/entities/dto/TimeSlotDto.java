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
public class TimeSlotDto {

    private String start;

    private String end;

    private JobDto job;

    private StatusDto status;

    private String createdAt;

    private String updatedAt;

    public TimeSlotDto(TimeSlot slot) {
        this.start=slot.getStart().toString();
        this.end=slot.getEnd().toString();
        this.job=new JobDto(slot.getJob());
        this.status=new StatusDto(slot.getStatus());
        this.createdAt=slot.getCreatedAt().toString();
        this.updatedAt=slot.getUpdatedAt().toString();
    }
}
