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
    @GetMapping("/getClientById/{ClientId}/")
    Client GetClientById(@PathVariable Long ClientId){
        return repository.findById(ClientId)
                .orElseThrow(() -> new ClientNotFoundException(ClientId));
    }
    //update
    @PutMapping("/updateClientById/{ClientId}/")
    Optional<Client> UpdateClientById(@PathVariable Long ClientId, @RequestBody Client newClient){
        return   repository.findById(ClientId).map(client -> {
           client.setClientName(newClient.getClientName());
           client.setAddress(newClient.getAddress());
           client.setQuntity(newClient.getQuntity());
           client.setProductName(newClient.getProductName());
           repository.save(client);
            return client;
        });
    }

    //delete
    @DeleteMapping("/deleteClientById/{ClientId}/")
    void DeleteClientById(@PathVariable Long ClientId){
        repository.deleteById(ClientId);
    }
}
