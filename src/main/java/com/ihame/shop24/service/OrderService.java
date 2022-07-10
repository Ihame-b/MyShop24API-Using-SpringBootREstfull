package com.ihame.shop24.service;

import com.ihame.shop24.dao.ClientRepository;
import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.dao.OrderRepository;
import com.ihame.shop24.entity.Client;
import com.ihame.shop24.entity.Drink;
import com.ihame.shop24.entity.Order1;
import com.ihame.shop24.exception.ClientNotFoundException;
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

//    public Optional<Object> CreateOrderOfSpecificClient(Long clientNumber, List<Long> drink_id, Order1 orderRequst) {
//
//        List< Optional <Drink>> drinkList= new ArrayList<>();
//
//        for (Long id: drink_id){
//            drinkList.add(drinkRepository.findById(id));
//        }
//        Optional<Object> order1 = clientRepository.findById(clientNumber).map(client -> { orderRequst.setClient(client);
////            orderRequst.setDrink(drinkList);
//            return orderRepository.save(orderRequst);
//        });
//        return order1;
//    }

    public Order1 CreateOrderOfSpecificClient(int clientId, Order1 orderRequest){
        List<Client> clientList=clientRepository.findAll();
        for (Client client: clientList) {
            if (client.getId() == clientId){
                orderRequest.setClientId(clientId);
                orderRepository.save(orderRequest);
                return orderRequest;
            }
        }

        throw new ClientNotFoundException((long) clientId);
    }

        }

