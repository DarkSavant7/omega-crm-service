package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.darksavant.omegacrmservice.common.entities.Category;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.Producer;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDto;
import ru.darksavant.omegacrmservice.common.repositories.GoodRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.CategoryService;
import ru.darksavant.omegacrmservice.common.services.interfaces.GoodsService;
import ru.darksavant.omegacrmservice.common.services.interfaces.ProducerService;
import ru.darksavant.omegacrmservice.errors.BadRequestException;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {
    private final GoodRepository goodRepository;
    private final CategoryService categoryService;
    private final ProducerService producerService;

    @Override
    public Good findByVendorCode(int code) {
        return goodRepository.findGoodByVendorCode(code).orElseThrow(() -> new ResourceNotFoundException("Товар не найден"));
    }

    @Override
    public Good findByTitle(String title) {
        return goodRepository.findGoodByTitle(title).orElseThrow(() -> new ResourceNotFoundException("Товар не найден"));
    }

    @Override
    public List<Good> findAllWereTitleLike(String reg) {
        return goodRepository.findAllByTitleLike(reg);
    }

    @Override
    public List<Good> findAllWereDescriptionLike(String reg) {
        return goodRepository.findAllByDescriptionLike(reg);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        goodRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Good save(String vendorCode, String title, String price) {
        BigDecimal cost = new BigDecimal(price);
        if (cost.signum() < 0) {
            throw new BadRequestException("Стоимость товара не может быть отрицательной");
        }
        Good newGood = new Good();
        newGood.setVendorCode(vendorCode);
        newGood.setTitle(title);
        newGood.setPrice(cost);
        return goodRepository.save(newGood);
    }

    @Override
    public Page<Good> findAll(Specification<Good> spec, Integer page, Integer pageSize) {
        return goodRepository.findAll(spec, PageRequest.of(page - 1, pageSize));
    }

    @Override
    @Transactional
    public Good update(GoodDto dto) {
        Good good = goodRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("Товар с id - " + dto.getId() + " не найден"));
        if (dto.getVendorCode() != null) {
            good.setVendorCode(dto.getVendorCode());
        }
        if (dto.getTitle() != null) {
            good.setTitle(dto.getTitle());
        }
        if (dto.getPrice() != null) {
            good.setPrice(dto.getPrice());
        }
        if (dto.getUrlPreview() != null) {
            good.setUrlPreview(dto.getUrlPreview());
        }
        if (dto.getUrlFull() != null) {
            good.setUrlFull(dto.getUrlFull());
        }
        if (dto.getDescription() != null) {
            good.setDescription(dto.getDescription());
        }
        return goodRepository.save(good);
    }

    @Override
    @Transactional
    public Good addCategory(Long goodId, String category) {
        Good good = goodRepository.findById(goodId).orElseThrow(() -> new ResourceNotFoundException("Товар не найден"));
        Category categoryEntity = categoryService.findByName(category);
        List<Category> listCategory = good.getCategories();
        if (listCategory.contains(categoryEntity)) {
            throw new BadRequestException("У товара " + goodId + " уже есть категория " + category);
        } else {
            listCategory.add(categoryEntity);
            good.setCategories(listCategory);
        }
        return goodRepository.save(good);
    }

    @Override
    @Transactional
    public Good deleteCategory(Long goodId, String category) {
        Good good = goodRepository.findById(goodId).orElseThrow(() -> new ResourceNotFoundException("Товар не найден"));
        Category categoryEntity = categoryService.findByName(category);
        List<Category> listCategory = good.getCategories();
        if (listCategory.contains(categoryEntity)) {
            listCategory.remove(categoryEntity);
            good.setCategories(listCategory);
        } else {
            throw new ResourceNotFoundException("У товара " + goodId + " не найдена удаляемая категория - " + category);
        }
        return goodRepository.save(good);

    }

    @Override
    @Transactional
    public Good addProducer(Long goodId, Long producerId) {
        Good good = goodRepository.findById(goodId).orElseThrow(() -> new ResourceNotFoundException("Товар не найден"));
        Producer producer = producerService.findByID(producerId);
        List<Producer> producerList = good.getProducers();
        if (producerList.contains(producer)) {
            throw new BadRequestException("У товара " + goodId + " уже есть поставщик " + producerId);
        }
        producerList.add(producer);
        good.setProducers(producerList);
        return goodRepository.save(good);
    }

    @Override
    @Transactional
    public Good deleteProducer(Long goodId, Long producerId) {
        Good good = goodRepository.findById(goodId).orElseThrow(() -> new ResourceNotFoundException("Товар не найден"));
        Producer producer = producerService.findByID(producerId);
        List<Producer> producerList = good.getProducers();
        if (producerList.contains(producer)) {
            producerList.remove(producer);
            good.setProducers(producerList);
        } else {
            throw new ResourceNotFoundException("У товара " + goodId + " не найден поставщик - " + producerId);
        }
        return goodRepository.save(good);
    }

    @Override
    public Good findById(Long goodId) {
        return goodRepository.findById(goodId).orElseThrow(() -> new ResourceNotFoundException("Товар не найден"));
    }

}
