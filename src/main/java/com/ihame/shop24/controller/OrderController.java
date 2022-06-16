package com.ihame.shop24.controller;
import com.ihame.shop24.dao.OrderRepository;
import com.ihame.shop24.entity.Order1;
import com.ihame.shop24.exception.OrderNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class OrderController {

    private OrderRepository repository;
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    //display
    @GetMapping("/allorder")
    List<Order1> all(){
        return repository.findAll();
    }

    //find by id
    @GetMapping("/order/{id}/")
    Order1 getbyId(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    //save
    @PostMapping("/addorder/")
    Order1 save(@RequestBody Order1 newOrder){
        return repository.save(newOrder);
    }

    //update
    @PutMapping("/updateorder/{id}/")
    Optional<Order1> update(@PathVariable Long id, @RequestBody Order1 newOrder){
        return   repository.findById(id).map(order1 -> {
            order1.setName(newOrder.getName());
            order1.setTotalCost(newOrder.getTotalCost());

            return order1;
        });
    }

    //delete
    @DeleteMapping("/daleteorder/{id}/")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }



}
