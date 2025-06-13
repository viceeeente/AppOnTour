package com.OnTour.AppOnTour.repository;

import com.OnTour.AppOnTour.model.Curso;
import com.OnTour.AppOnTour.model.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositoRepository extends JpaRepository<Deposito, Long> {
    List<Deposito> findByCursoOrderByFechaDesc(Curso curso);
}
