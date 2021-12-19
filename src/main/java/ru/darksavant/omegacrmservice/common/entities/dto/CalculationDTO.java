package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.Calculation;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class CalculationDTO {
    private final GoodDTO good;

    private List<CalculationItemsDTO> items;

    public CalculationDTO(Calculation calculation) {
        this.good=new GoodDTO(calculation.getGood());
        this.items=calculation.getItems().stream().map(CalculationItemsDTO::new).collect(Collectors.toList());

    }
}
