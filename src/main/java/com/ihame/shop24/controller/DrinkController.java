package com.ihame.shop24.controller;
import com.ihame.shop24.dao.CargoRepository;
import com.ihame.shop24.exception.CargoNotFoundException;
import com.ihame.shop24.exception.DrinkNotFoundException;
import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.entity.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DrinkController {

    @Autowired
    private DrinkRepository drinkrepository;
    @Autowired
    private CargoRepository cargoRepository;

    public DrinkController(DrinkRepository repository) {
        this.drinkrepository = repository;
    }

    //display
    @GetMapping("/alldrinks")
    List<Drink> all(){
   return drinkrepository.findAll();
   }

   //find by id
    @GetMapping("/drink/{id}/")
    Drink getbyId(@PathVariable Long id){
        return drinkrepository.findById(id)
        .orElseThrow(() -> new DrinkNotFoundException(id));
    }
//
//    //save
//    @PostMapping("/adddrink/")
//    Drink save(@RequestBody Drink newDrink){
//        return repository.save(newDrink);
//    }

    //update
    @PutMapping("/updatedrink/{id}/")
   Optional<Drink> update(@PathVariable Long id, @RequestBody Drink newDrink){
      return   drinkrepository.findById(id).map(drink -> {
          drink.setCategory(newDrink.getCategory());
          drink.setExpiredDate(newDrink.getExpiredDate());
          drink.setName(newDrink.getName());
          drink.setPrice(newDrink.getPrice());
          drink.setQuality(newDrink.getQuality());
            return drink;
        });
    }

    // Create a drink
    @PostMapping("/addrink/{cargoId}/")
    public Drink createDrink(@PathVariable(value = "cargoId") Long cargoId, @RequestBody Drink drinkRequest) {
        Drink drink = cargoRepository.findById(cargoId).map(cargo -> { drinkRequest.setCargo(cargo);
            return drinkrepository.save(drinkRequest);
        }).orElseThrow(() -> new CargoNotFoundException(cargoId));
         return drink;
    }

    //delete
    @DeleteMapping("/deletedrink/{id}/")
    void delete(@PathVariable Long id){
        drinkrepository.deleteById(id);
    }



    // get drinks for specific Cargo
    @GetMapping("/getbycargo/{cargoId}/")
    public List<Drink> getdrinkbycargo(@PathVariable(value = "cargoId") Long cargoId) {
            List <Drink> CC= drinkrepository.findByCargoId(cargoId);
            return CC;
        }
    }


