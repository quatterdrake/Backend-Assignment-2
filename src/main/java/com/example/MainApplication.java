package com.example;

import com.example.beans.EagerBean;
import com.example.beans.LazyBean;
import com.example.config.AppConfig;
import com.example.model.Car;
import com.example.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // EagerBean автоматически инициализируется при запуске
        context.getBean(EagerBean.class);

        // CarService с @Primary
        CarService carService = context.getBean(CarService.class);
        List<Car> allCars = carService.getAllCars();
        System.out.println("All Cars: " + allCars);

        // CarService с @Qualifier("luxuryCarService")
        CarService luxuryCarService = context.getBean("luxuryCarService", CarService.class);
        List<Car> luxuryCars = luxuryCarService.getAllCars();
        System.out.println("Luxury Cars: " + luxuryCars);

        // Инициализация LazyBean
        context.getBean(LazyBean.class);

        context.close();
    }
}
