package com.gs.repository.jpa.db1.spec;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DemoUserSpecification<T> {

    public Specification<T> searchKey(String keyword) {
        return (root, query, builder) -> {
            if (StringUtils.isEmpty(keyword)) {
                return builder.conjunction();
            }
            Predicate[] predicates = {
                    builder.like(root.get("mobile"), "%" + keyword + "%"),
                    builder.like(root.get("userName"), "%" + keyword + "%"),
                    builder.like(root.get("email"), "%" + keyword + "%")
            };

            return builder.or(predicates);
        };
    }

    public Specification<T> mobileLike(String mobile) {
        return (root, query, builder) -> StringUtils.isEmpty(mobile) ? builder.conjunction() : builder.like(root.get("mobile"), "%" + mobile + "%");
    }

    public Specification<T> userNameEqualsTo(String userName) {
        return (root, query, builder) -> StringUtils.isEmpty(userName) ? builder.conjunction() : builder.equal(root.get("userName"), userName);
    }

    public Specification<T> emailNotEqualsTo(String email) {
        return (root, query, builder) -> StringUtils.isEmpty(email) ? builder.conjunction() : builder.notEqual(root.get("email"), email);
    }
}
