package com.OnTour.AppOnTour.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "curso")
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column (nullable = false)
    private Integer cantidadAlumnos;

    @Column(nullable = false)
    private Integer saldoCurso;

    @Column (nullable = false)
    private String nombreRepresentante;

    @Column (nullable = false)
    private String numeroRepresentante;

}
