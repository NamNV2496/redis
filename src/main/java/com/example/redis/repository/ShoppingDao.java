package com.example.redis.repository;

import com.example.redis.domain.Shopping;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class ShoppingDao {

    public static final String REDIS_KEY = "Shopping";
// WAY 1
    private final RedisTemplate redisTemplate;

    public Shopping save(Shopping shopping){
//        List<String> list = new ArrayList();
//        list.add("hello");
//        redisTemplate.opsForList().rightPushAll(REDIS_KEY+2, list);
        redisTemplate.opsForHash().put(REDIS_KEY, shopping.getId(), shopping);
//        redisTemplate.opsForValue().set(REDIS_KEY,  shopping);
//        redisTemplate.opsForValue().set(REDIS_KEY + 1, shopping.getName());
//        redisTemplate.expire(REDIS_KEY + 1, 1, TimeUnit.MINUTES);
        return shopping;
    }

    public Shopping getShopById(int id){
        return (Shopping) redisTemplate.opsForHash().get(REDIS_KEY,id);
    }

    public boolean checkKey(int id) {
        if (redisTemplate.hasKey(REDIS_KEY)) {
            if (redisTemplate.opsForHash().hasKey(REDIS_KEY, id)) {
                return true;
            }
        }
        return false;
    }

    public void delete(int id){
        redisTemplate.opsForHash().delete(REDIS_KEY, id);
    }


// WAY 2

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Shopping> hashOperations;
//
    public void saveShop(Shopping emp) {
        hashOperations.putIfAbsent(REDIS_KEY, emp.getId(), emp);
    }
//
//    public void saveAllEmployees(Map<Integer, Shopping> map) {
//        hashOperations.putAll(REDIS_KEY, map);
//    }
//
    public Shopping getOneShop(Integer id) {
        return hashOperations.get(REDIS_KEY, id);
    }
//
//    public void updateEmployee(Shopping emp) {
//        hashOperations.put(REDIS_KEY, emp.getId(), emp);
//    }
//
    public Map<Integer, Shopping> getAllShops() {
        return hashOperations.entries(REDIS_KEY);
    }
//
//    public void deleteEmployee(Integer id) {
//        hashOperations.delete(REDIS_KEY, id);
//    }

}