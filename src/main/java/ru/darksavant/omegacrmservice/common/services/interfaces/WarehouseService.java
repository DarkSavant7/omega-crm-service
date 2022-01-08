package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Warehouse;

import java.util.List;


public interface WarehouseService {

    Warehouse findById(Long id);

    Warehouse save(Warehouse warehouse);

    void deleteById(Long id);

    void addGoodToWarehouse(Long goodId, Long warehouseId);

    void removeGoodeFromWarehouse(Long goodId, Long warehouseId);

    void addGoodsListToWarehouse(List<Long> ids, Long warehouseId);

}
