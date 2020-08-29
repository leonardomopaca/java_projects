package com.leo.mercurio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAppController {

    @GetMapping("/teste")
    public String retornaMsgOk(){
        return "Teste OK";
    }

}
