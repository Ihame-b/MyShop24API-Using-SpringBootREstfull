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

    private final CargoRepository repository;
    public CargoController(CargoRepository repository) {
        this.repository = repository;
    }

    //save
    @PostMapping("/createCargo/")
    Cargo CreateCargo(@RequestBody Cargo newCargo){
        return repository.save(newCargo);
    }

    //display
    @GetMapping("/getAllCargo")
    List<Cargo> GetAllCargo(){
        return repository.findAll();
    }

    //find by id
    @GetMapping("/getCargoById/{CargoId}/")
    Cargo GetCargoById(@PathVariable Long CargoId){
        return repository.findById(CargoId)
                .orElseThrow(() -> new CargoNotFoundException(CargoId));
    }

    //update
    @PutMapping("/updateCargoById/{CargoId}/")
    Optional<Cargo> UpdateCargoById(@PathVariable Long CargoId, @RequestBody Cargo newCargo){
        return   repository.findById(CargoId).map(cargo -> {
            cargo.setDeriverDate(newCargo.getDeriverDate());
            cargo.setStartDate(newCargo.getStartDate());
            cargo.setCompanyName(newCargo.getCompanyName());
            repository.save(cargo);
            return cargo;
        });
    }

    //delete
    @DeleteMapping("/deleteCargoById/{CargoId}/")
    void DeleteCargoById(@PathVariable Long CargoId){
        repository.deleteById(CargoId);
    }

}
