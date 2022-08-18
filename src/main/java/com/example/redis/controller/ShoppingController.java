package com.example.redis.controller;

import com.example.redis.domain.Shopping;
import com.example.redis.repository.ShoppingDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ShoppingController {
    private final ShoppingDao shoppingDao;
    @GetMapping("/getAll")
    public Map<Integer, Shopping> getShopping() {
        return shoppingDao.getAllEmployees();
    }
}
