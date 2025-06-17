package com.OnTour.AppOnTour.service;

import com.OnTour.AppOnTour.model.Curso;
import com.OnTour.AppOnTour.model.Deposito;
import com.OnTour.AppOnTour.repository.CursoRepository;
import com.OnTour.AppOnTour.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DepositoService {

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void guardarDeposito(Long cursoId, Integer monto, LocalDate fecha, String representante) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(()-> new RuntimeException("Curso no encontrado"));

        Deposito deposito = new Deposito();
        deposito.setCurso(curso);
        deposito.setMonto(monto);
        deposito.setFecha(fecha);
        deposito.setRepresentante(representante);

        depositoRepository.save(deposito);

        //estas dos lineas son las que se encargan de ir actualizando el monto del curso
        curso.setSaldoCurso(curso.getSaldoCurso()+monto);
        cursoRepository.save(curso);
    }

    public List<Deposito> listarDepositosPorCurso(Curso curso) {
        return depositoRepository.findByCursoOrderByFechaDesc(curso);
    }
}
