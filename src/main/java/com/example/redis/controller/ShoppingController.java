package com.example.redis.controller;

import com.example.redis.domain.Shopping;
import com.example.redis.repository.ShoppingDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ShoppingController {

    private final ShoppingDao shoppingDao;

    @GetMapping("/getAll")
    public Map<Integer, Shopping> getShopping() {
        System.out.println("getall");
        return shoppingDao.getAllEmployees();
    }

    @PostMapping("/add")
    public void addShopping(@RequestBody Shopping shopping) {
        System.out.println("add");
        shoppingDao.saveEmployee(shopping);
    }

    @GetMapping("/get")
    public Shopping getShopping(@RequestParam int id) {
        System.out.println("get id: " + id);
        System.out.println("data: " + shoppingDao.getOneEmployee(id));
        return shoppingDao.getEmployeesById(id);
    }

    @PostMapping("/create")
    public void getShopping(@RequestBody Shopping shopping) {
        System.out.println("create");
        shoppingDao.save(shopping);
    }
}
