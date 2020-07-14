package com.example.demo;

import org.springframework.data.jpa.domain.Specification;

public class ContactFilterSpecification {
    public static Specification<Contact> withNameEquals(String name) {
        return (root, query, cb) -> name == null ? null: cb.equal(root.get("name"),name);
    }

    public static Specification<Contact> withEmailEquals(String email) {
        return (root, query, cb) -> email == null ? null: cb.equal(root.get("email"),email);
    }
}
