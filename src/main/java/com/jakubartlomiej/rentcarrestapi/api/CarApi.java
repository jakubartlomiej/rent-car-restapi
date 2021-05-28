package com.jakubartlomiej.rentcarrestapi.api;

import com.jakubartlomiej.rentcarrestapi.entity.Car;
import com.jakubartlomiej.rentcarrestapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private final CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public Iterable<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(@RequestBody Car car) {
        carService.save(car);
    }

}
