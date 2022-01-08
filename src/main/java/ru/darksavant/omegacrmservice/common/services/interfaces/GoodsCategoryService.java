package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Category;


public interface GoodsCategoryService {

    Category findByName(String name);

    Category save(Category d);

    void delete(Category d);

    void deleteById(Long id);

}
