package com.OnTour.AppOnTour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultar-depositos")
public class DepositosController {

    @GetMapping
    public String mostrarDepositos(){
        return "consultar-depositos";
    }
}
