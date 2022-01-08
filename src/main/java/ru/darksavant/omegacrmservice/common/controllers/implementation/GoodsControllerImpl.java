package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.GoodsController;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDto;
import ru.darksavant.omegacrmservice.common.repositories.specifications.GoodsSpecification;
import ru.darksavant.omegacrmservice.common.services.interfaces.GoodsService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GoodsControllerImpl implements GoodsController {
    private final GoodsService goodsService;

    @Override
    public ResponseEntity<GoodDto> findByID(Long id) {
        return ResponseEntity.ok().body(new GoodDto(goodsService.findById(id)));
    }

    @Override
    public ResponseEntity<GoodDto> findByVendorCode(int code) {
        return ResponseEntity.ok().body(new GoodDto(goodsService.findByVendorCode(code)));
    }

    @Override
    public ResponseEntity<Page<GoodDto>> findGoods(Integer page, Integer pageSize, String title, String description, String category) {
        return ResponseEntity.ok().body(goodsService.findAll(GoodsSpecification.build(title, description, category), page, pageSize).map(GoodDto::new));
    }

    @Override
    @Transactional
    public ResponseEntity<String> save(String vendorCode, String title, String price) {
        ResponseEntity<String> response;
        try {
            goodsService.save(vendorCode, title, price);
            response = ResponseEntity.ok().body("Товар успешно создан");
        } catch (Exception e) {
            response = ResponseEntity.badRequest().body("Товар не создан");
        }
        return response;
    }

    @Override
    public ResponseEntity<GoodDto> update(GoodDto dto) {
        return ResponseEntity.ok().body(new GoodDto(goodsService.update(dto)));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        ResponseEntity<String> response;
        try {
            goodsService.deleteById(id);
            response = ResponseEntity.ok().body("Товар успешно удален");
        } catch (Exception e) {
            response = ResponseEntity.badRequest().body("Ошибка удаления товара");
        }
        return response;
    }
}
