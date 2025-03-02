package com.example.beans;

import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarDealership {
    private final List<Car> cars;

    public CarDealership(CarRepository carRepository) {
        this.cars = List.copyOf(carRepository.getAllCars().values());
        System.out.println("CarDealership initialized! Available cars: " + cars);
    }
}
