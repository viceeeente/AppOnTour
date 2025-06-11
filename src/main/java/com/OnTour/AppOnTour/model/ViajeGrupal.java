package com.OnTour.AppOnTour.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeGrupal extends Viaje{

    @Column(nullable = false)
    private Boolean incluyeGuia;
}
