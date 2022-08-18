package com.example.redis.repository;

import com.example.redis.domain.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public class ShoppingDao {

//    public static final String HASH_KEY = "Shopping";
//    @Autowired
//    private RedisTemplate template;
//
//    public Shopping save(Shopping shopping){
//        template.opsForHash().put(HASH_KEY,shopping.getId(),shopping);
//        return shopping;
//    }
//
//    public List<Shopping> findAll(){
//        return template.opsForHash().values(HASH_KEY);
//    }
//
//    public Shopping findProductById(int id){
//        return (Shopping) template.opsForHash().get(HASH_KEY,id);
//    }
//
//
//    public String deleteProduct(int id){
//        template.opsForHash().delete(HASH_KEY,id);
//        return "shopping item deleted successfully !!";
//    }



    private final String hashReference= "Employee";
    private final String hashReference1= "int";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Shopping> hashOperations;

    private HashOperations<String, Integer> hashOperationsInt;

    public void saveEmployee(Shopping emp) {
        hashOperations.putIfAbsent(hashReference, emp.getId(), emp);
    }

    public void saveAllEmployees(Map<Integer, Shopping> map) {
        hashOperations.putAll(hashReference, map);
    }

    public Shopping getOneEmployee(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    public void updateEmployee(Shopping emp) {
        hashOperations.put(hashReference, emp.getId(), emp);
    }

    public Map<Integer, Shopping> getAllEmployees() {
        return hashOperations.entries(hashReference);
    }

    public void deleteEmployee(Integer id) {
        hashOperations.delete(hashReference, id);
    }

}