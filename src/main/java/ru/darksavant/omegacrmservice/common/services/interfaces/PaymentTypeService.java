package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.PaymentType;

public interface PaymentTypeService {

    PaymentType findByDescription(String name);

    PaymentType save(PaymentType d);

    void delete(PaymentType d);

    void deleteById(Long id);

}
