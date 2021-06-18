package com.jakubartlomiej.rentcarrestapi.service;

import com.jakubartlomiej.rentcarrestapi.RentCarRestapiApplication;
import com.jakubartlomiej.rentcarrestapi.entity.Car;
import com.jakubartlomiej.rentcarrestapi.exception.car.CarNotFoundException;
import com.jakubartlomiej.rentcarrestapi.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RentCarRestapiApplication.class)
class CarServiceTest {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarService carService;

    @Test
    @Transactional
    public void shouldFindCarById(){
        //given
        Car newCar = new Car();
        newCar.setBrand("Seat");
        newCar.setModel("Leon");
        newCar.setDoor(4);
        newCar.setSeats(5);
        newCar.setYear(2015);
        newCar.setDayCost(BigDecimal.valueOf(200.99));
        carRepository.save(newCar);
        //when
        Car car = carService.findById(newCar.getId());
        //then
        assertNotNull(car);
        assertEquals(car.getBrand(),"Seat");
        assertEquals(car.getModel(),"Leon");
        assertEquals(car.getDoor(),4);
        assertEquals(car.getSeats(),5);
        assertEquals(car.getDayCost(),BigDecimal.valueOf(200.99));
    }

    @Test()
    public void shouldCarNotFoundException(){
        //given
        //when
        Exception exception = assertThrows(CarNotFoundException.class, () -> carService.findById(0L));
        //
        assertTrue(exception.getMessage().contains("Could not find car: " + 0L));
    }

    @Test
    @Transactional
    public void shouldReturnAllCarListSortByBrandAndModel(){
        //given
        Car car1 = new Car(1L, "BMW", "1", 2011, 2, 5, BigDecimal.valueOf(120.00));
        Car car2 = new Car(2L, "Audi", "A8", 2018, 4, 5, BigDecimal.valueOf(209.00));
        Car car3 = new Car(3L, "Audi", "A6", 2014, 4, 5, BigDecimal.valueOf(159.99));
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        //when
        Iterable<Car> list = carService.findAll();
        List<Car> result = StreamSupport.stream(list.spliterator(), false)
                .collect(Collectors.toList());
        //then
        assertEquals(result.size(),3);
        assertEquals(result.get(0).getBrand(),"Audi");
        assertEquals(result.get(0).getModel(),"A6");
    }
}