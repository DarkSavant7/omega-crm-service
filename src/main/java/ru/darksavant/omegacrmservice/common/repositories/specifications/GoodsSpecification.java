package ru.darksavant.omegacrmservice.common.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.darksavant.omegacrmservice.common.entities.Good;

public class GoodsSpecification {

    public static Specification<Good> build(String title, String description, String category) {
        Specification<Good> spec = Specification.where(null);
        if (description != null) {
            spec = spec.and(GoodsSpecification.descriptionContain(description));
        }
        if (title != null) {
            spec = spec.and(GoodsSpecification.titleContains(title));
        }
        if (category != null) {
            spec = spec.and(GoodsSpecification.categoryEquals(category));
        }
        return spec;
    }

    private static Specification<Good> categoryEquals(String category) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            criteriaQuery.distinct(true);
            return criteriaBuilder.like(
                    root.join("categories").get("name"), category);
        };
    }

    private static Specification<Good> titleContains(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("good").get("title")), "%" + title.toLowerCase() + "%");
    }

    private static Specification<Good> descriptionContain(String description) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("good").get("description")), "%" + description.toLowerCase() + "%");
    }
}
