package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Contact contact;

    Place place;
}
