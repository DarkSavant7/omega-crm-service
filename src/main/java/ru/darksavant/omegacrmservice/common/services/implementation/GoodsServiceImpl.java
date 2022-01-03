package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDTO;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDTO;
import ru.darksavant.omegacrmservice.common.repositories.GoodRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.GoodsService;
import ru.darksavant.omegacrmservice.errors.BadRequestException;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {
    private final GoodRepository goodRepository;

    @Override
    public ResponseEntity<GoodDTO> findByVendorCode(int code) {
        return ResponseEntity.ok().body(new GoodDTO(goodRepository.findGoodByVendorCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Товар не найден"))));
    }

    @Override
    public ResponseEntity<GoodDTO> findByTitle(String title) {
        return ResponseEntity.ok().body(new GoodDTO(goodRepository.findGoodByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Товар не найден"))));
    }

    @Override
    public ResponseEntity<List<GoodDTO>> findAllWereTitleLike(String reg) {
        return ResponseEntity.ok().body(goodRepository.findAllByTitleLike(reg)
                .stream().map(GoodDTO::new).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<GoodDTO>> findAllWereDescriptionLike(String reg) {
        return ResponseEntity.ok().body(goodRepository.findAllByDescriptionLike(reg)
                .stream().map(GoodDTO::new).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        goodRepository.deleteById(id);
        return ResponseEntity.ok().body("Товар с ID - " + id + " успешно удален");
    }

    @Override
    public ResponseEntity<GoodDTO> findById(Long id) {
        return ResponseEntity.ok().body(new GoodDTO(goodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Товар не найден"))));
    }

    @Override
    public ResponseEntity<String> save(String vendorCode, String title, String price) {
        int code;
        BigDecimal cost = new BigDecimal(price);
        if (vendorCode != null) {
            code = Integer.parseInt(vendorCode);
        } else {
            code = 0;
        }
        if (cost.signum() < 0) {
            throw new BadRequestException("Стоимость товара не может быть отрицательной");
        }
        Good newGood = new Good();
        newGood.setVendorCode(code);
        newGood.setTitle(title);
        newGood.setPrice(cost);
        goodRepository.save(newGood);
        return ResponseEntity.ok().body("Товар добавлен в базу");
    }

    @Override
    public ResponseEntity<Page<GoodDTO>> findAll(Specification<Good> spec, Integer page, Integer pageSize) {
        return ResponseEntity.ok().body(goodRepository.findAll(spec, PageRequest.of(page-1,pageSize)).map(GoodDTO::new));
    }

}
