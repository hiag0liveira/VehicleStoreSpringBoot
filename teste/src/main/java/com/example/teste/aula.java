package com.example.teste;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class aula {
    

    @GetMapping(value="/")
    public String getMethodName() {
        return "ola ";
    }
    
}
