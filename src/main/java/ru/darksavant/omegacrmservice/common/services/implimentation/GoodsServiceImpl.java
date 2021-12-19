package ru.darksavant.omegacrmservice.common.services.implimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.repositories.GoodRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.GoodsService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {
    private final GoodRepository goodRepository;

    public Good findByVendorCode(int code) {
        return goodRepository.findGoodByVendorCode(code).orElseThrow(() -> new ResourceNotFoundException("Good not found"));
    }

    public Good findByTitle(String title) {
        return goodRepository.findGoodByTitle(title).orElseThrow(() -> new ResourceNotFoundException("Good not found"));
    }

    public List<Good> findAllWereTitleLike(String reg) {
        return goodRepository.findAllByTitleLike(reg);
    }

    public List<Good> findAllWereDescriptionLike(String reg) {
        return goodRepository.findAllByDescriptionLike(reg);
    }

    public Good save(Good d) {
        return goodRepository.save(d);
    }

    public void delete(Good d) {
        goodRepository.delete(d);
    }

    public void deleteById(Long id) {
        goodRepository.deleteById(id);
    }


}
