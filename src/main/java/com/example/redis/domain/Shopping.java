package com.example.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RedisHash("Shopping")
public class Shopping implements Serializable {
    @Id
    private int id;
    private String name;
    private long price;
}