package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ContactPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @ManyToOne
    Contact contact;

    @ManyToOne
    Place place;
}
