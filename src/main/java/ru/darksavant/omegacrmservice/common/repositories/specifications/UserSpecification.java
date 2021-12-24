package ru.darksavant.omegacrmservice.common.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.darksavant.omegacrmservice.common.entities.User;

public class UserSpecification {
    public static Specification<User> idEquals(Long id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }
    public static Specification<User> emailContains(String subEmail) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("user").get("email")), "%" + subEmail.toLowerCase() + "%");
    }
    public static Specification<User> nameContains(String subName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("user").get("username")), "%" + subName.toLowerCase() + "%");
    }

    public static Specification<User> build(String userName, String email, Long id){
        Specification<User> spec = Specification.where(null);
        if (userName!=null){
            spec=spec.and(UserSpecification.nameContains(userName));
        }
        if (email!=null){
            spec=spec.and(UserSpecification.emailContains(email));
        }
        if(id!=null){
            spec=spec.and(UserSpecification.idEquals(id));
        }
        return spec;
    }
}
