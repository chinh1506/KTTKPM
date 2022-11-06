package com.example.redis1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    private RedisTemplate template;

    @PostMapping("/")
    public String set(@RequestParam(name = "key") String key,@RequestParam(name = "value") String value){
        template.opsForValue().set(key,value);
        return "OK";
    }
    @GetMapping("/{key}")
    public String get(@PathVariable String key){
        String value= (String) template.opsForValue().get(key);
        return  value;
    }
    @DeleteMapping("/{key}")
    public String delete(@PathVariable String key){
        String value= (String) template.opsForValue().getAndDelete(key);
        return  value;
    }
}
