package com.example.beans;

import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class CarWarehouse {
    private final List<Car> cars;

    public CarWarehouse(CarRepository carRepository) {
        this.cars = List.copyOf(carRepository.getAllCars().values());
        System.out.println("CarWarehouse initialized! Cars in storage: " + cars);
    }
}
