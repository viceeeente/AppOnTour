package com.OnTour.AppOnTour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public String mostrarMenu() {
        return "home";
    }

    @GetMapping("/consultar-depositos")
    public String consultarDepositos() {
        return "consultarDepositos";
    }

    @GetMapping("/reistrar-contrato")
    public String registrarContrato() {
        return "registrarContrato";
    }



}
