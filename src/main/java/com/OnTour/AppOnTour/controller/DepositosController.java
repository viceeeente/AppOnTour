package com.OnTour.AppOnTour.controller;

import com.OnTour.AppOnTour.model.Curso;
import com.OnTour.AppOnTour.model.Deposito;
import com.OnTour.AppOnTour.repository.CursoRepository;
import com.OnTour.AppOnTour.repository.DepositoRepository;
import com.OnTour.AppOnTour.service.CursoService;
import com.OnTour.AppOnTour.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/consultar-depositos")
public class DepositosController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private DepositoService depositoService;

    @Autowired
    private CursoRepository cursoRepository;


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

    @PostMapping("/{cursoId}")
    public String registrarDeposito (
            @PathVariable Long cursoId,
            @RequestParam Integer monto,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam String representante,
            Model model) {

        System.out.println("Recibiendo deposito para curso ID: " + cursoId);

        depositoService.guardarDeposito(cursoId,monto,fecha, representante);

        Curso curso = cursoRepository.findById(cursoId).orElse(null);
        List<Deposito> depositos = depositoRepository.findByCursoOrderByFechaDesc(curso);

        model.addAttribute("curso",curso);
        model.addAttribute("depositos",depositoRepository.findByCursoOrderByFechaDesc(curso));

        return "redirect:/consultar-depositos/" + cursoId;
    }
}
