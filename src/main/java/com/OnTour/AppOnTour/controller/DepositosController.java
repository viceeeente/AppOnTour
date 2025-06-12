package com.OnTour.AppOnTour.controller;

import com.OnTour.AppOnTour.model.Curso;
import com.OnTour.AppOnTour.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultar-depositos")
public class DepositosController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String redirigirDepositos(){
        return "redirect/";
    }
    @GetMapping("/{id}")
    public String mostrarDepositos(@PathVariable Long id, Model model){
        Curso curso = cursoService.obtenerCursoPorId(id);
        if (curso == null) {
            model.addAttribute("error","No se encontro el curso por su ID: "+id);
            return "error";
        }
        model.addAttribute("curso",curso);
        return "consultar-depositos";
    }
}
