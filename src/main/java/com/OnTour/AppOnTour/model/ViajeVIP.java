package com.OnTour.AppOnTour.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "viaje_vip")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeVIP extends Viaje{

    @Column(nullable = false)
    private Boolean incluyeGuia;
}
