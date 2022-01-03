package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.GoodsController;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDTO;
import ru.darksavant.omegacrmservice.common.repositories.specifications.GoodsSpecification;
import ru.darksavant.omegacrmservice.common.services.interfaces.GoodsService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GoodsControllerImpl implements GoodsController {
    private final GoodsService goodsService;
    @Override
    public ResponseEntity<GoodDTO> findByID(Long id) {
        return goodsService.findById(id);
    }

    @Override
    public ResponseEntity<GoodDTO> findByVendorCode(int code) {
        return goodsService.findByVendorCode(code);
    }

    @Override
    public ResponseEntity<Page<GoodDTO>> findGoods(Integer page, Integer pageSize, String title, String description, String category) {
        return goodsService.findAll(GoodsSpecification.build(title,description,category),page,pageSize);
    }

    @Override
    public ResponseEntity<String> save(String vendorCode, String title, String price) {
        return goodsService.save(vendorCode,title,price);
    }

    @Override
    public ResponseEntity<GoodDTO> update(GoodDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return goodsService.deleteById(id);
    }
}
