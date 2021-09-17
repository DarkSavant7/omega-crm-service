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

    public Discount save(Discount d) {
        return discountRepository.save(d);
    }

    public void deleteDiscount(Discount d) {
        discountRepository.delete(d);        
    }

    public void deleteDiscountById(Long id){
        discountRepository.deleteById(id);
    }


}
