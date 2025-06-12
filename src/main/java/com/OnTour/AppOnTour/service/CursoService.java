package com.OnTour.AppOnTour.service;

import com.OnTour.AppOnTour.model.Curso;
import com.OnTour.AppOnTour.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso obtenerCursoPorId (Long id) {
        return cursoRepository.findById(id).orElse(null);

    }
}
