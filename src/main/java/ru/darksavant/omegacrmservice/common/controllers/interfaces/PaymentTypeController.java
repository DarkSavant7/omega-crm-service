package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.PaymentType;

public interface PaymentTypeController {

    PaymentType findByDescription(String name);

    PaymentType save(PaymentType d);

    void delete(PaymentType d);

    void deleteById(Long id);

}
