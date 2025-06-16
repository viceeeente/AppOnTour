package com.OnTour.AppOnTour.controller;

import com.OnTour.AppOnTour.model.Curso;
import com.OnTour.AppOnTour.service.CursoService;
import com.OnTour.AppOnTour.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Controller
@RequestMapping("/consultar-depositos")
public class DepositosController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private DepositoService depositoService;

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

    @PostMapping("/ingresar/{id}")
    public String registrarDeposito (
            @PathVariable Long id,
            @RequestParam Integer monto,
            @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam String representante,
            Model model
    ) {
        Curso curso = cursoService.obtenerCursoPorId(id);
        if(curso != null) {
            depositoService.guardarDeposito(curso, monto ,representante, fecha );
        }
        model.addAttribute("curso",curso);
        model.addAttribute("depositos",depositoService.listarDepositosPorCurso(curso));
        return "consultar-depositos";
    }
}
