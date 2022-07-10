package com.ihame.shop24.controller;
import com.ihame.shop24.dao.CargoRepository;
import com.ihame.shop24.exception.DrinkNotFoundException;
import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.entity.Drink;
import com.ihame.shop24.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/createDrink/")
    Drink CreateDrink(@RequestBody Drink newDrink){
        return drinkrepository.save(newDrink);
    }

    //display
    @GetMapping("/getAllDrink")
    List<Drink> GetAllDrink(){
   return drinkrepository.findAll();
   }

   //find by id
    @GetMapping("/getDrinkById/{id}/")
    Drink GetDrinkById(@PathVariable Long id){
        return drinkrepository.findById(id)
        .orElseThrow(() -> new DrinkNotFoundException(id));
    }

    @GetMapping("/getAllDrinksOnOrder/{OrderId}/")
    List<Drink> getAllDrinksOnOrder(@PathVariable(value = "orderId") Long orderId){
        List <Drink> drink1 = drinkrepository.findByOrder1Id(orderId);
        return drink1;
    }

    //update
    @PutMapping("/updateDrinkById/{id}/")
   Optional<Drink> UpdateDrinkById(@PathVariable Long id, @RequestBody Drink newDrink){
      return   drinkrepository.findById(id).map(drink -> {
          drink.setCategory(newDrink.getCategory());
          drink.setExpiredDate(newDrink.getExpiredDate());
          drink.setName(newDrink.getName());
          drink.setPrice(newDrink.getPrice());
          drink.setQuality(newDrink.getQuality());
          drinkrepository.save(drink);
            return drink;
        });
    }
    //delete
    @DeleteMapping("/deleteDrinkById/{id}/")
    void DeleteDrinkById(@PathVariable Long id){
        drinkrepository.deleteById(id);
    }

    // most five consumed drink
    @GetMapping("/getMostConsumedDrink/{number}/")
    public List<Drink> GetMostConsumedDrink(@RequestParam(defaultValue = "2") Integer number)
    {
        List<Drink> list = drinkService.most5ConsumedDrink(number);
        return list;
    }

    }


// Create a drink
//    @PostMapping("/addrink/{cargoId}/")
//    public Drink createDrink(@PathVariable(value = "cargoId") Long cargoId, @RequestBody Drink drinkRequest) {
//        Drink drink = cargoRepository.findById(cargoId).map(cargo -> { drinkRequest.setCargo(cargo);
//            return drinkrepository.save(drinkRequest);
//        }).orElseThrow(() -> new CargoNotFoundException(cargoId));
//         return drink;
//    }

//    // get drinks for specific Cargo
//    @GetMapping("/getbycargo/{cargoId}/")
//    public List<Drink> getDrinkByCargo(@PathVariable(value = "cargoId") Long cargoId) {
//            List <Drink> drinks1= drinkrepository.findByCargoId(cargoId);
//            return drinks1;
//        }


