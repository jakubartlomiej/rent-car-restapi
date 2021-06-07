package com.jakubartlomiej.rentcarrestapi.api;

import com.jakubartlomiej.rentcarrestapi.entity.Client;
import com.jakubartlomiej.rentcarrestapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientApi {

    private final ClientService clientService;

    @Autowired
    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping
    public Iterable<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/paging")
    public List<Client> findAll(@RequestParam int size, @RequestParam int page) {
        return clientService.findAll(size, page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping
    public Client update(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
