package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Discount;
import ru.darksavant.omegacrmservice.common.repositories.DiscountRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.DiscountService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;

    public Discount findByName(String name) {
        return discountRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Discount not found"));
    }

    public Discount findByAmount(BigDecimal amount){
        return discountRepository.findByAmount(amount).orElseThrow(() -> new ResourceNotFoundException("Discount not found"));

    }

    public Discount save(Discount d) {
        return discountRepository.save(d);
    }

    public void delete(Discount d) {
        discountRepository.delete(d);
    }

    public void deleteById(Long id){
        discountRepository.deleteById(id);
    }


}
