package com.ihame.shop24.service;

import com.ihame.shop24.dao.DrinkRepository;
import com.ihame.shop24.entity.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkService {

    @Autowired
    DrinkRepository drinkRepository;
    public List<Drink> most5ConsumedDrink(int clientNumber) {

        Pageable paging = PageRequest.of(0, clientNumber, Sort.by("consumedTime").descending());
        Page<Drink> drinkResult = drinkRepository.findAll(paging);
        if(drinkResult.hasContent()) {
            return drinkResult.getContent();
        } else {
            return new ArrayList<Drink>();
        }
    }

}
