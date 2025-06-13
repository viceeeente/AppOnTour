package com.OnTour.AppOnTour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "depositos")
@NoArgsConstructor
@AllArgsConstructor
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer monto;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @PrePersist
    protected void asignarFecha() {
        this.fecha = LocalDate.now();
    }
}
