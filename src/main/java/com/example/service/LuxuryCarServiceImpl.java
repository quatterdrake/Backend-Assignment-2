package com.example.service;

import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("luxuryCarService")
public class LuxuryCarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public LuxuryCarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars().values().stream()
                .filter(car -> "BMW".equalsIgnoreCase(car.getBrand()))
                .collect(Collectors.toList());
    }
}