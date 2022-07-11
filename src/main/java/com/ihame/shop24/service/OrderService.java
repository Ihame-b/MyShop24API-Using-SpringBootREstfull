package com.ihame.shop24.service;

import com.ihame.shop24.dao.ClientRepository;
import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.dao.OrderRepository;
import com.ihame.shop24.entity.Client;
import com.ihame.shop24.entity.Drink;
import com.ihame.shop24.entity.Order1;
import com.ihame.shop24.exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
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


    public List<Order1> Top5OrderOfDifferentClient() {
        Pageable paging = PageRequest.of(0, 5, Sort.by("id").descending());
        Page<Order1> orderResult = orderRepository.findAll(paging);
        if(orderResult.hasContent()) {
            return orderResult.getContent();
        } else {
            return new ArrayList<Order1>();
        }
    }


    public Optional<Order1> calculateTotalCost(long orderId) {

        return   orderRepository.findById(orderId).map(order1 -> {


            List<Long> drinkIdsOfOrder=  order1.getDrinkId();
            int sum=0;
            //find all drinks in that order by going through all drinks
            for (Drink drk : drinkRepository.findAll()) {
                if(drinkIdsOfOrder.contains(drk.getId())){
                    int occurrences = Collections.frequency(drinkIdsOfOrder,drk.getId());
                    sum=sum+drk.getPrice()*occurrences;
                    //					order1.setTotalCost(order1.getTotalCost()+drk.getPrice());
                }

            }
            order1.setTotalCost(sum);
            orderRepository.save(order1);
            return order1;
        });

    }

    public Optional<Order1> orderPayed(long orderId) {

        return   orderRepository.findById(orderId).map(order1 -> {
            order1.setCompleted(true);
            orderRepository.save(order1);
            return order1;
        });

    }


}

