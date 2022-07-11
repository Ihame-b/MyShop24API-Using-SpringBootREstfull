package com.ihame.shop24;

import com.ihame.shop24.dao.CargoRepository;
import com.ihame.shop24.dao.ClientRepository;
import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.dao.OrderRepository;
import com.ihame.shop24.entity.Cargo;
import com.ihame.shop24.entity.Client;
import com.ihame.shop24.entity.Drink;
import com.ihame.shop24.entity.Order1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestMyShop24 implements CommandLineRunner {

    //repository
    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OrderRepository orderRepository;

    // Testing Insert of Drink
    private void loadDrinkData() {
        if (drinkRepository.count() == 0) {
            Drink drink1 = new Drink("NonAlcoholDrink","one",new Date(),700,"fanta",1);
            Drink drink2 = new Drink("Beer","one",new Date(),500,"skol",1);
            drinkRepository.save(drink1);
            drinkRepository.save(drink2);
        }
        System.out.println(drinkRepository.count());
    }

    // Testing Insert of Cargo
    private void loadCargoData() {
        if (cargoRepository.count() == 0) {
            Cargo cargo1 = new Cargo("Ihame Trust LTD", new Date(), new Date(), "Kigali");
            Cargo cargo2 = new Cargo("Ozey King LTD", new Date(), new Date(), "Rubavu");
            cargoRepository.save(cargo1);
            cargoRepository.save(cargo2);
        }
        System.out.println(cargoRepository.count());
    }

    // Testing Insert of Client
    private void loadClientData() {
        if (clientRepository.count() == 0) {
            Client client1 = new Client("Ihame", "Fanta", "Kigali",5);
            Client client2 = new Client("Ozey", "skol", "Kigali",3);
            clientRepository.save(client1);
            clientRepository.save(client2);
        }
        System.out.println(clientRepository.count());
    }

//     Testing Insert of Order
    private void loadOrderData() {
        if (orderRepository.count() == 0) {
            Order1 order1 = new Order1("Fanta", 7000);
            Order1 order2 = new Order1("skol", 10000);
            orderRepository.save(order1);
            orderRepository.save(order2);
        }
        System.out.println(orderRepository.count());
    }


    // run
    @Override
    public void run(String... args) throws Exception {
             loadDrinkData();
             loadCargoData();
             loadClientData();
             loadOrderData();
    }
}
