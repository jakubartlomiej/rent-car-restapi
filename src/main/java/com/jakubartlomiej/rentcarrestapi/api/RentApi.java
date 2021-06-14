package com.jakubartlomiej.rentcarrestapi.api;

import com.jakubartlomiej.rentcarrestapi.entity.Client;
import com.jakubartlomiej.rentcarrestapi.entity.Rent;
import com.jakubartlomiej.rentcarrestapi.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rent")
@RestController
public class RentApi {

    private final RentService rentService;

    @Autowired
    public RentApi(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/{id}")
    public Rent findById(@PathVariable Long id) {
        return rentService.findById(id);
    }

    @GetMapping
    public Iterable<Rent> findAll() {
        return rentService.findAll();
    }

    @GetMapping("/paging")
    public List<Rent> findAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return rentService.findAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rent add(@RequestBody Rent rent) {
        return rentService.save(rent);
    }

    @PutMapping
    public Rent update(@RequestBody Rent rent) {
        return rentService.save(rent);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        rentService.deleteById(id);
    }

    @GetMapping("/clients/{id}")
    public Iterable<Rent> findByClientId(@PathVariable Long id){
        return rentService.findByClientId(id);
    }
}
