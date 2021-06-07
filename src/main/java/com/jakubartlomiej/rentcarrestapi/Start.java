package com.jakubartlomiej.rentcarrestapi;

import com.jakubartlomiej.rentcarrestapi.entity.Car;
import com.jakubartlomiej.rentcarrestapi.entity.Client;
import com.jakubartlomiej.rentcarrestapi.repository.CarRepository;
import com.jakubartlomiej.rentcarrestapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public Start(CarRepository carRepository, ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Car car1 = new Car(1L, "Audi", "A6", 2014, 4, 5, false);
        Car car2 = new Car(2L, "Audi", "A8", 2018, 4, 5, false);
        Car car3 = new Car(3L, "BMW", "1", 2011, 2, 5, false);
        Car car4 = new Car(4L, "BMW", "7", 2015, 4, 5, false);

        Client client1 = new Client(1L, "Jan", "Kowalski", 123456789);
        Client client2 = new Client(2L, "Piotr", "Nogalski", 111122224);
        Client client3 = new Client(3L, "Anna", "Borowska", 11445566);
        Client client4 = new Client(4L, "Tomasz", "Noga", 123456789);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
        clientRepository.save(client4);
    }
}
