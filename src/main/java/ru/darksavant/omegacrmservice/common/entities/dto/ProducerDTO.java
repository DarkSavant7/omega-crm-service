package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.Producer;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProducerDTO {

    private ContactDTO contact;

    private String designation;

    private long INN;

    private String description;

     private String website;

    public ProducerDTO(Producer producer) {
        this.contact=new ContactDTO(producer.getContact());
        this.description=producer.getDescription();
        this.INN=producer.getINN();
        this.description=producer.getDescription();
        this.website=producer.getWebsite();
    }
}
