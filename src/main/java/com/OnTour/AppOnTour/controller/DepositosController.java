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
    public String registrarDeposito(@PathVariable Long cursoId,
                                    @RequestParam Integer monto,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
                                    @RequestParam String representante,
                                    Model model) {

        System.out.println("➡️ Registrando depósito para curso ID: " + cursoId);

        depositoService.guardarDeposito(cursoId, monto, fecha, representante);

        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        List<Deposito> depositos = depositoRepository.findByCursoOrderByFechaDesc(curso);

        // Obtener el último depósito
        Deposito ultimoDeposito = depositos.isEmpty() ? null : depositos.get(0);
        model.addAttribute("curso", curso);
        model.addAttribute("depositos", depositos);
        model.addAttribute("ultimoDeposito", ultimoDeposito);

        System.out.println("✅ Último depósito enviado: " + (ultimoDeposito != null ? ultimoDeposito.getMonto() : "No hay depósitos"));

        return "consultar-depositos";
    }
}
