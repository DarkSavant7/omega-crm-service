package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.GoodsController;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDTO;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDTO;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GoodsControllerImpl implements GoodsController {
    @Override
    public ResponseEntity<GoodDTO> findByVendorCode(int code) {
        return null;
    }

    @Override
    public ResponseEntity<Page<UserDTO>> findGoods(Integer page, Integer pageSize, String userName, String email, String category) {
        return null;
    }

    @Override
    public ResponseEntity<String> save(String vendorCode, String title, String price) {
        return null;
    }

    @Override
    public ResponseEntity<GoodDTO> update(String vendorCode, String title, String price, String urlPreview, String urlFull, String description, String category) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(String vendorCode, String title) {
        return null;
    }
}
