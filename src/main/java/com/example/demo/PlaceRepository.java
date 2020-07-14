package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Integer> {
    Place findByPlaceName(String name);
}
