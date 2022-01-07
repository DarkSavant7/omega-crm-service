package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.Category;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CategoryDto {

    private String name;

    private List<GoodDto> goods;

    public CategoryDto(Category category) {
        this.name= category.getName();
        this.goods=category.getGoods().stream().map(GoodDto::new).collect(Collectors.toList());
    }
}
