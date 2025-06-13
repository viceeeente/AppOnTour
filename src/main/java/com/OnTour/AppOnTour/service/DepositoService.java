package com.OnTour.AppOnTour.service;

import com.OnTour.AppOnTour.model.Curso;
import com.OnTour.AppOnTour.model.Deposito;
import com.OnTour.AppOnTour.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DepositoService {

    @Autowired
    private DepositoRepository depositoRepository;

    public void guardarDeposito(Curso curso, Integer monto, String representante) {
        Deposito deposito = new Deposito();
        deposito.setCurso(curso);
        deposito.setMonto(monto);
        deposito.setFecha(LocalDate.now());
        deposito.setRepresentante(representante);
        depositoRepository.save(deposito);
    }

    public List<Deposito> listarDepositosPorCurso(Curso curso) {
        return depositoRepository.findByCursoOrderByFechaDesc(curso);
    }
}
