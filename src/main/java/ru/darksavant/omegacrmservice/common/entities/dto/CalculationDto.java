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
public class CalculationDto {
    private final GoodDto good;

    private List<CalculationItemsDto> items;

    public CalculationDto(Calculation calculation) {
        this.good=new GoodDto(calculation.getGood());
        this.items=calculation.getItems().stream().map(CalculationItemsDto::new).collect(Collectors.toList());

    }
}
