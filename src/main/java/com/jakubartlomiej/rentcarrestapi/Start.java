package com.jakubartlomiej.rentcarrestapi;

import com.jakubartlomiej.rentcarrestapi.entity.Car;
import com.jakubartlomiej.rentcarrestapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private final CarRepository carRepository;

    @Autowired
    public Start(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Car car1 = new Car(1L, "Audi", "A6", 2014, 4, 5, false);
        Car car2 = new Car(2L, "Audi", "A8", 2018, 4, 5, false);
        Car car3 = new Car(3L, "BMW", "1", 2011, 2, 5, false);
        Car car4 = new Car(4L, "BMW", "7", 2015, 4, 5, false);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
    }
}
