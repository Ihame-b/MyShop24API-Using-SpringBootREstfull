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
    @PostMapping("/addclient/")
    Client save(@RequestBody Client newClient){
        return repository.save(newClient);
    }

    //display
    @GetMapping("/allclient")
    List<Client> all(){
        return repository.findAll();
    }

    //find by id
    @GetMapping("/client/{id}/")
    Client getbyId(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }
    //update
    @PutMapping("/updateclient/{id}/")
    Optional<Client> update(@PathVariable Long id, @RequestBody Client newClient){
        return   repository.findById(id).map(client -> {
           client.setClientName(newClient.getClientName());
           client.setAddress(newClient.getAddress());
           client.setQuntity(newClient.getQuntity());
           client.setProductname(newClient.getProductname());
            return client;
        });
    }

    //delete
    @DeleteMapping("/daleteclient/{id}/")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}
