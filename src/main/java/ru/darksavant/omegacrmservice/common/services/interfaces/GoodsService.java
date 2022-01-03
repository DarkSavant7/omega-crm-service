package ru.darksavant.omegacrmservice.common.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDTO;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDTO;

import java.util.List;


public interface GoodsService {

    ResponseEntity<GoodDTO> findByVendorCode(int code);

    ResponseEntity<GoodDTO>  findByTitle(String title);

    ResponseEntity<List<GoodDTO>> findAllWereTitleLike(String reg);

    ResponseEntity<List<GoodDTO>>findAllWereDescriptionLike(String reg);

    ResponseEntity<String> deleteById(Long id);

    ResponseEntity<GoodDTO> findById(Long id);

    ResponseEntity<String> save(String vendorCode, String title, String price);

    ResponseEntity<Page<GoodDTO>> findAll(Specification<Good> build, Integer page, Integer pageSize);
}
