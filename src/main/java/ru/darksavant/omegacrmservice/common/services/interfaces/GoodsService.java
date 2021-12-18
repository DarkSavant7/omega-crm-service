package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Good;

import java.util.List;


public interface GoodsService {

    Good findByVendorCode(int code);

    Good findByTitle(String title);

    List<Good> findAllWereTitleLike(String reg);

    List<Good> findAllWereDescriptionLike(String reg);

    Good save(Good d);

    void delete(Good d);

    void deleteById(Long id);

}
