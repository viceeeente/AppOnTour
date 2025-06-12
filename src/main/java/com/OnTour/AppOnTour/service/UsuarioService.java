package com.OnTour.AppOnTour.service;

import com.OnTour.AppOnTour.model.Usuario;
import com.OnTour.AppOnTour.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar (String nombre, String password) {
        return usuarioRepository.findByNombreAndPassword(nombre,password).orElse(null);

    }


}
