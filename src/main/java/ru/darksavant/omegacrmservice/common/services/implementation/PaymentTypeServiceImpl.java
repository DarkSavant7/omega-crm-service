package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.PaymentType;
import ru.darksavant.omegacrmservice.common.repositories.PaymentTypeRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.PaymentTypeService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class PaymentTypeServiceImpl implements PaymentTypeService {
    private final PaymentTypeRepository paymentTypeRepository;

    public PaymentType findByDescription(String name) {
        return paymentTypeRepository.findByDescription(name).orElseThrow(() -> new ResourceNotFoundException("PaymentType not found"));
    }

    public PaymentType save(PaymentType d) {
        return paymentTypeRepository.save(d);
    }

    public void delete(PaymentType d) {
        paymentTypeRepository.delete(d);
    }

    public void deleteById(Long id) {
        paymentTypeRepository.deleteById(id);
    }


}
