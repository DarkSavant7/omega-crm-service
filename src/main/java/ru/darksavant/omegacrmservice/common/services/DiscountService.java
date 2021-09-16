package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Discount;
import ru.darksavant.omegacrmservice.common.repositories.DiscountRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;

    public Discount findByName(String name) {
        return discountRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Discount not found"));
    }

    public boolean save(Discount d) {
        discountRepository.save(d);
        return findByName(d.getName()) != null;
    }

    public boolean deleteDiscount(Discount d) {
        discountRepository.delete(d);
        try {
            findByName(d.getName());
            return false;
        } catch (ResourceNotFoundException e) {
            return true;
        }
    }


}
