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
//    ============================= WAY 1:=============================
    @GetMapping("/get")
    public Shopping getShopping(@RequestParam int id) {
        System.out.println("get id: " + id);
        System.out.println("data: " + shoppingDao.getOneShop(id));
        return shoppingDao.getShopById(id);
    }

    @PostMapping("/create")
    public void getShopping(@RequestBody Shopping shopping) throws Exception {
        System.out.println("create");
        shoppingDao.save(shopping);
    }

    @GetMapping("/check")
    public boolean checkShopping(@RequestParam int id) {
        System.out.println("check");

        if (shoppingDao.checkKey(id)) {
            System.out.println("This id is exist");
        } else {
            System.out.println("This id is not exist");
        }
        return shoppingDao.checkKey(id);
    }
    @DeleteMapping("/delete")
    public boolean deleteShopping(@RequestParam int id) {
        System.out.println("delete");

        if (shoppingDao.checkKey(id)) {
            System.out.println("This id is exist");
            shoppingDao.delete(id);
        } else {
            System.out.println("This id is not exist");
        }
        return shoppingDao.checkKey(id);
    }


//    ============================= WAY 2:=============================
    @GetMapping("/getAll")
    public Map<Integer, Shopping> getShopping() {
        System.out.println("getall");
        return shoppingDao.getAllShops();
    }

    @PostMapping("/add")
    public void addShopping(@RequestBody Shopping shopping) {
        System.out.println("add");
        shoppingDao.saveShop(shopping);
    }

}
