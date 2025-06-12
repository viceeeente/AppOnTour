package com.OnTour.AppOnTour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MenuController {

    @GetMapping
    public String mostrarMenu() {
        return "home";
    }

    @GetMapping("/consultar-depositos")
    public String consultarDepositos() {
        return "consultar-depositos";
    }

    @GetMapping("/reistrar-contrato")
    public String registrarContrato() {
        return "registrarContrato";
    }



}
