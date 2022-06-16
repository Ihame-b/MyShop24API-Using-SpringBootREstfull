package com.ihame.shop24;
import com.ihame.shop24.entity.Drink;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DrinkController {
    private DrinkRepository repository;

    public DrinkController(DrinkRepository repository) {
        this.repository = repository;
    }

    //display
    @GetMapping("/")
    List<Drink> all(){
     // return new Student("ihame", "gilbert", 23, "male", "student");
   return repository.findAll();
   }

   //find by id
    @GetMapping("/drink/{id}/")
    Drink getbyId(@PathVariable Long id){
        return repository.findById(id)
        .orElseThrow(() -> new DrinkNotFoundException(id));
    }

    //save
    @PostMapping("/drink/")
    Drink save(@RequestBody Drink newDrink){
        return repository.save(newDrink);
    }

    //update
    @PutMapping("/drink/{id}/")
   Optional<Drink> update(@PathVariable Long id, @RequestBody Drink newDrink){
      return   repository.findById(id).map(drink -> {
//            drink.setAge(newDrink.getAge());
//            drink.setCategory(newDrink.getCategory());
//            drink.setFirstname(newDrink.getFirstname());
//            drink.setLastname(newDrink.getLastname());
//            drink.setGender(newDrink.getGender());

          drink.setCategory(newDrink.getCategory());
          drink.setExpiredDate(newDrink.getExpiredDate());
          drink.setName(newDrink.getName());
          drink.setPrice(newDrink.getPrice());
          drink.setQuality(newDrink.getQuality());
            return drink;
        });
    }

    //delete
    @DeleteMapping("/drink/{id}/")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }



}
