package ru.darksavant.omegacrmservice.common.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDto;

import java.util.List;


public interface GoodsService {

    Good findByVendorCode(int code);

    Good findByTitle(String title);

    List<Good> findAllWereTitleLike(String reg);

    List<Good> findAllWereDescriptionLike(String reg);

    void deleteById(Long id);

    Good save(String vendorCode, String title, String price);

    Page<Good> findAll(Specification<Good> build, Integer page, Integer pageSize);

    Good update(GoodDto dto);

    Good addCategory(Long goodId, String category);

    Good deleteCategory(Long goodId, String category);

    Good addProducer(Long goodId, Long producerId);

    Good deleteProducer(Long goodId, Long producerId);

    Good findById(Long goodId);
}
