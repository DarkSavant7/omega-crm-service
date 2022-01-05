package ru.darksavant.omegacrmservice.common.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDto;

import java.util.List;


public interface GoodsService {

    ResponseEntity<GoodDto> findByVendorCode(int code);

    ResponseEntity<GoodDto>  findByTitle(String title);

    ResponseEntity<List<GoodDto>> findAllWereTitleLike(String reg);

    ResponseEntity<List<GoodDto>>findAllWereDescriptionLike(String reg);

    ResponseEntity<String> deleteById(Long id);

    ResponseEntity<GoodDto> findById(Long id);

    ResponseEntity<String> save(String vendorCode, String title, String price);

    ResponseEntity<Page<GoodDto>> findAll(Specification<Good> build, Integer page, Integer pageSize);
}
