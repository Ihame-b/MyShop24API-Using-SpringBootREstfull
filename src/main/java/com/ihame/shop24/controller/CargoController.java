package com.ihame.shop24.controller;

import com.ihame.shop24.dao.CargoRepository;
import com.ihame.shop24.entity.Cargo;
import com.ihame.shop24.exception.CargoNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CargoController {

    private CargoRepository repository;
    public CargoController(CargoRepository repository) {
        this.repository = repository;
    }

    //save
    @PostMapping("/addcargo/")
    Cargo save(@RequestBody Cargo newCargo){
        return repository.save(newCargo);
    }

    //display
    @GetMapping("/allcargo")
    List<Cargo> all(){
        return repository.findAll();
    }

    //find by id
    @GetMapping("/cargo/{id}/")
    Cargo getbyId(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new CargoNotFoundException(id));
    }

    //update
    @PutMapping("/updatecargo/{id}/")
    Optional<Cargo> update(@PathVariable Long id, @RequestBody Cargo newCargo){
        return   repository.findById(id).map(cargo -> {
            cargo.setDeriverDate(newCargo.getDeriverDate());
            cargo.setStartDate(newCargo.getStartDate());
            cargo.setCompanyName(newCargo.getCompanyName());

            return cargo;
        });
    }

    //delete
    @DeleteMapping("/daletecargo/{id}/")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
