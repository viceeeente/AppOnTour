package com.OnTour.AppOnTour.controller;

import com.OnTour.AppOnTour.model.Curso;
import com.OnTour.AppOnTour.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MenuController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String mostrarMenu(Model model) {
        Curso curso = cursoService.obtenerCursoPorId(1L);
        System.out.println("Curso obtenido: "+curso);
        model.addAttribute("curso",curso);
        return "home";
    }

    @GetMapping("/reistrar-contrato")
    public String registrarContrato() {
        return "registrarContrato";
    }



}
