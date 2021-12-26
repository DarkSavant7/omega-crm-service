package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Discount;

import java.math.BigDecimal;


public interface DiscountController {

    Discount findByName(String name);

    Discount findByAmount(BigDecimal amount);

    Discount save(Discount d);

    void delete(Discount d);

    void deleteById(Long id);

}
