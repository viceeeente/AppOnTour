package com.OnTour.AppOnTour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepositoController {

    @PostMapping("/ingresar-dinero/{id}")
    public String ingresarDinero(@PathVariable Long id, @RequestParam Integer monto)
}
