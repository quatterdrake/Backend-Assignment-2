package com.example.repository;

import com.example.model.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarRepository {
    private final Map<Integer, Car> carMap = new HashMap<>();

    public CarRepository() {
        carMap.put(1, new Car("Toyota", "Camry"));
        carMap.put(2, new Car("BMW", "X5"));
        carMap.put(3, new Car("Honda", "Civic"));
    }

    public Map<Integer, Car> getAllCars() {
        return carMap;
    }
}