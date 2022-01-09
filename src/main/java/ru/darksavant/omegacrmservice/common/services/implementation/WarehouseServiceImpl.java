package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.Warehouse;
import ru.darksavant.omegacrmservice.common.repositories.WarehouseRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.GoodsService;
import ru.darksavant.omegacrmservice.common.services.interfaces.WarehouseService;
import ru.darksavant.omegacrmservice.errors.BadRequestException;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository repository;
    private final GoodsService goodsService;

    @Override
    public Warehouse findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Склад не найден по - "+id));
    }

    @Override
    @Transactional
    public Warehouse save(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void addGoodToWarehouse(Long goodId, Long warehouseId) {
        Warehouse warehouse = repository.findById(warehouseId).orElseThrow(() -> new ResourceNotFoundException("Склад не найден по - "+warehouseId));
        Good good = goodsService.findById(goodId);
        List<Good> goodList = warehouse.getGoodList();
        if (goodList.contains(good)) {
            throw new BadRequestException("Товар с id " + goodId + " уже есть на складе " + warehouse.getId());
        } else {
            goodList.add(good);
            warehouse.setGoodList(goodList);
        }
    }

    @Override
    public void removeGoodeFromWarehouse(Long goodId, Long warehouseId) {
        Warehouse warehouse = repository.findById(warehouseId).orElseThrow(() -> new ResourceNotFoundException("Склад не найден по - "+warehouseId));
        Good good = goodsService.findById(goodId);
        List<Good> goodList = warehouse.getGoodList();
        if (goodList.contains(good)) {
            goodList.remove(good);
            warehouse.setGoodList(goodList);
        } else {
            throw new BadRequestException("Товар с id " + goodId + " не найден на складе " + warehouse.getId());
        }
    }

    @Override
    public void addGoodsListToWarehouse(List<Long> ids, Long warehouseId) {
        List<Good> goodList = ids.stream().map(goodsService::findById).collect(Collectors.toList());
       //todo надо сделать дополнительную таблицу с количеством товара
    }

}
