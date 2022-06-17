
package com.ihame.shop24.controller;
import com.ihame.shop24.dao.ClientRepository;
import com.ihame.shop24.dao.OrderRepository;
import com.ihame.shop24.entity.Order1;
import com.ihame.shop24.exception.CargoNotFoundException;
import com.ihame.shop24.exception.OrderNotFoundException;
import com.ihame.shop24.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderrepository;
    @Autowired
    private OrderService orderService;
    public OrderController(OrderRepository orderrepository) {
        this.orderrepository = orderrepository;
    }

    //save
    @PostMapping("/addorder/")
    Order1 save(@RequestBody Order1 newOrder){
        return orderrepository.save(newOrder);
    }

    //display
    @GetMapping("/allorder")
    List<Order1> all(){
        return orderrepository.findAll();
    }

    //find by id
    @GetMapping("/order/{id}/")
    Order1 getbyId(@PathVariable Long id){
        return orderrepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    //delete
    @DeleteMapping("/daleteorder/{id}/")
    void delete(@PathVariable Long id){
        orderrepository.deleteById(id);
    }

    //update
    @PutMapping("/updateorder/{id}/")
    Optional<Order1> update(@PathVariable Long id, @RequestBody Order1 newOrder){
        return   orderrepository.findById(id).map(order1 -> {
            order1.setName(newOrder.getName());
            order1.setTotalCost(newOrder.getTotalCost());
            return order1;
        });
    }

    @PostMapping("/createordertoclient/{client_id}/")
    public Order1 createDrink(@PathVariable(value = "client_id") Long clientId, @RequestBody Order1 orderRequest) {
        Order1 order1 = clientRepository.findById(clientId).map(client -> { orderRequest.setClient(client);
            return orderrepository.save(orderRequest);
        }).orElseThrow(() -> new CargoNotFoundException(clientId));
        return order1;
    }

    @PostMapping("/createordertoclient/{client_id}/{drinks_ids}")
    Optional<Object> CreateOrderForSpecificClient(@PathVariable Long client_id, @PathVariable List<Long> drinks_ids, @RequestBody Order1 orderRequest){
        Optional<Object> order1= orderService.CreateOrderOfSpecificClient(client_id,drinks_ids,orderRequest);
        return order1;
    }

}
