package com.OnTour.AppOnTour.controller;


import com.OnTour.AppOnTour.model.Usuario;
import com.OnTour.AppOnTour.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.File;

@Controller
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String mostrarFormulario (Model model) {
        model.addAttribute("usuario",new Usuario());
        return "login";
    }

    @PostMapping
    public String procesarLogin(@ModelAttribute Usuario usuario, Model model) {
        Usuario autenticado = usuarioService.autenticar(usuario.getNombre(), usuario.getPassword());

        if (autenticado == null) {
            System.out.println("Usuario no autenticado: " + usuario.getNombre());
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        } else {
            System.out.println("Usuario autenticado: " + autenticado.getNombre());
        }

        return "home";
    }



}
