package com.ihame.shop24.service;

import com.ihame.shop24.dao.ClientRepository;
import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.dao.OrderRepository;
import com.ihame.shop24.entity.Drink;
import com.ihame.shop24.entity.Order1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DrinkRepository drinkRepository;

    public Optional<Object> CreateOrderOfSpecificClient(Long clientNumber, List<Long> drink_id, Order1 orderRequst) {

        List< Optional <Drink>> drinkList= new ArrayList<>();

        for (Long id: drink_id){
            drinkList.add(drinkRepository.findById(id));
        }
        Optional<Object> order1 = clientRepository.findById(clientNumber).map(client -> { orderRequst.setClient(client);
//            orderRequst.setDrink(drinkList);
            return orderRepository.save(orderRequst);
        });
        return order1;
    }

        }

