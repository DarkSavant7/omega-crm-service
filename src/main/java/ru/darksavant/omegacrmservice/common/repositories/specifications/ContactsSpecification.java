package ru.darksavant.omegacrmservice.common.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.darksavant.omegacrmservice.common.entities.Contact;

public class ContactsSpecification {

    public static Specification<Contact> build(String requestString) {
        Specification<Contact> spec = Specification.where(null);
        spec.or(primaryEmailContain(requestString));
        spec.or(positionContain(requestString));
        spec.or(secondaryEmailContain(requestString));
        spec.or(primaryPhoneContain(requestString));
        spec.or(mobilePhoneContain(requestString));
        spec.or(workPhoneContain(requestString));
        spec.or(fioContain(requestString));
        return spec;
    }

    private static Specification<Contact> primaryEmailContain(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("contact").get("primaryEmail")), "%" + email.toLowerCase() + "%");
    }

    private static Specification<Contact> secondaryEmailContain(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("contact").get("secondaryEmail")), "%" + email.toLowerCase() + "%");
    }

    private static Specification<Contact> primaryPhoneContain(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("contact").get("primaryPhone")), "%" + phone.toLowerCase() + "%");
    }

    private static Specification<Contact> mobilePhoneContain(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("contact").get("mobilePhone")), "%" + phone.toLowerCase() + "%");
    }

    private static Specification<Contact> workPhoneContain(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("contact").get("workPhone")), "%" + phone.toLowerCase() + "%");
    }

    private static Specification<Contact> positionContain(String position) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("contact").get("position")), "%" + position.toLowerCase() + "%");
    }

    private static Specification<Contact> fioContain(String fio) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.join("contact").get("fio")), "%" + fio.toLowerCase() + "%");
    }


}
