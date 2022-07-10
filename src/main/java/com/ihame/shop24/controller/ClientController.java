package com.ihame.shop24.controller;

import com.ihame.shop24.dao.ClientRepository;
import com.ihame.shop24.entity.Client;
import com.ihame.shop24.exception.ClientNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {
    private ClientRepository repository;
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }


    //save
    @PostMapping("/createClient/")
    Client CreateClient(@RequestBody Client newClient){
        return repository.save(newClient);
    }

    //display
    @GetMapping("/getAllClient/")
    List<Client> GetAllClient(){
        return repository.findAll();
    }

    //find by id
    @GetMapping("/getClientById/{id}/")
    Client GetClientById(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }
    //update
    @PutMapping("/updateClientById/{id}/")
    Optional<Client> UpdateClientById(@PathVariable Long id, @RequestBody Client newClient){
        return   repository.findById(id).map(client -> {
           client.setClientName(newClient.getClientName());
           client.setAddress(newClient.getAddress());
           client.setQuntity(newClient.getQuntity());
           client.setProductName(newClient.getProductName());
           repository.save(client);
            return client;
        });
    }

    //delete
    @DeleteMapping("/deleteClientById/{id}/")
    void DeleteClientById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
