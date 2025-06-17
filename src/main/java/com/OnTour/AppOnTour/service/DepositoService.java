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
        System.out.println("➡️ Ejecutando guardarDeposito para curso ID: " + cursoId);

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        System.out.println("📌 Curso encontrado: " + curso.getNombre() + " - Saldo actual: " + curso.getSaldoCurso());

        Deposito deposito = new Deposito();
        deposito.setCurso(curso);
        deposito.setMonto(monto);
        deposito.setFecha(fecha);
        deposito.setRepresentante(representante);

        depositoRepository.save(deposito);

        if (curso.getSaldoCurso() == null) {
            curso.setSaldoCurso(0);
        }

        curso.setSaldoCurso(curso.getSaldoCurso() + monto);
        cursoRepository.save(curso);

        System.out.println("✅ Saldo actualizado: " + curso.getSaldoCurso());
    }

    public List<Deposito> listarDepositosPorCurso(Curso curso) {
        List<Deposito> depositos = depositoRepository.findByCursoOrderByFechaDesc(curso);

        if (depositos.isEmpty()) {
            throw new IllegalArgumentException("No hay depósitos registrados para este curso");
        }

        return depositos;
    }
}
