package com.ihame.shop24.controller;
import com.ihame.shop24.dao.CargoRepository;
import com.ihame.shop24.exception.CargoNotFoundException;
import com.ihame.shop24.exception.DrinkNotFoundException;
import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.entity.Drink;
import com.ihame.shop24.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @Autowired
    private DrinkService drinkService;

    public DrinkController(DrinkRepository repository) {
        this.drinkrepository = repository;
    }

    //save
    @PostMapping("/adddrink/")
    Drink save(@RequestBody Drink newDrink){
        return drinkrepository.save(newDrink);
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
    public List<Drink> getDrinkByCargo(@PathVariable(value = "cargoId") Long cargoId) {
            List <Drink> drinks1= drinkrepository.findByCargoId(cargoId);
            return drinks1;
        }

        // most five consumed drink
    @GetMapping("/mostconsumed/{timesofconsumed}/")
    public List<Drink> getAllSortConsumedDrink(
            @RequestParam(defaultValue = "2") Integer timesofconsumed)
    {
        List<Drink> list = drinkService.most5ConsumedDrink(timesofconsumed);
        return list;
    }

    }




