//package com.example.redis.domain;
//import lombok.Data;
//import org.springframework.data.redis.core.RedisHash;
//
//import java.io.Serializable;
//
//@Entity
//@RedisHash
//@Data
//public class User implements Serializable {
//
//    @Id
//    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
//    private Long id;
//    private String name;
//    private long followers;
//
//    public User() {
//    }
//
//    public User(String name, long followers) {
//        this.name = name;
//        this.followers = followers;
//    }
//
//    //standard getters and setters
//
//    @Override
//    public String toString() {
//        return String.format("User{id=%d, name='%s', followers=%d}", id, name, followers);
//    }
//}