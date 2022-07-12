
package com.ihame.shop24.controller;
import com.ihame.shop24.dao.ClientRepository;
import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.dao.OrderRepository;
import com.ihame.shop24.entity.Drink;
import com.ihame.shop24.entity.Order1;
import com.ihame.shop24.exception.DrinkNotFoundException;
import com.ihame.shop24.exception.OrderNotFoundException;
import com.ihame.shop24.service.DrinkService;
import com.ihame.shop24.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderrepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DrinkService drinkService;



    public OrderController(OrderRepository orderrepository) {
        this.orderrepository = orderrepository;
    }

//    //save
//    @PostMapping("/createOrder/")
//    Order1 CreateOrder(@RequestBody Order1 newOrder){
//        return orderrepository.save(newOrder);
//    }

    //display
    @GetMapping("/getAllOrder")
    List<Order1> GetAllOrder(){
        return orderrepository.findAll();
    }

    //find by id
    @GetMapping("/getOrderById/{id}/")
    Order1 GetOrderById(@PathVariable Long id){
        return orderrepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    //delete
    @DeleteMapping("/deleteOrderById/{id}/")
    void DeleteOrderById(@PathVariable Long id){
        orderrepository.deleteById(id);
    }

    //update
    @PutMapping("/updateOrderById/{id}/")
    Optional<Order1> UpdateOrderById(@PathVariable Long id, @RequestBody Order1 newOrder){
        return   orderrepository.findById(id).map(order1 -> {
            order1.setName(newOrder.getName());
            order1.setTotalCost(newOrder.getTotalCost());
            orderrepository.save(order1);
            return order1;
        });
    }

    @PostMapping("/CreateOrderForSpecificClient/{clientId}")
    Order1 CreateOrderForSpecificClient(@PathVariable int clientId, @RequestBody Order1 orderRequest){
        Order1 order1= orderService.CreateOrderOfSpecificClient(clientId, orderRequest);
        return order1;
    }

    @PostMapping("/addDrinkToOrder/{drinkId}/{orderId}")
    Optional<Order1> addDrinkToOrder(@PathVariable Long drinkId, @PathVariable Long orderId){
        return orderrepository.findById(orderId).map(order1 -> {
            boolean found=false;
            for (Drink drink: drinkRepository.findAll()) {
                  if (drink.getId() == drinkId){
                      order1.addDrink(drinkId);
                      orderrepository.save(order1);
                      found=true;
                      return  order1;
                  }
            }

           if (found == false){
               throw new DrinkNotFoundException(drinkId);
           }return order1;
        });
    }

    @GetMapping("/getTop5Order/")
    public List<Order1> GetTop5Order()
    {
        List<Order1> list = orderService.Top5OrderOfDifferentClient();
        return list;
    }

    //calculateTotalCost
    @PostMapping("/calculateTotalCost/{orderId}/")
    Optional<Order1> calculateTotalCost(@PathVariable Long orderId){
        return   orderService.calculateTotalCost(orderId);
    }


    //pay order
    @PostMapping("/payed/{orderId}/")
    Optional<Order1> payed(@PathVariable Long orderId){
        return   orderService.orderPayed(orderId);

    }


}
