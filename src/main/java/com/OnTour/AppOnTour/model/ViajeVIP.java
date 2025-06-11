package com.OnTour.AppOnTour.model;

import jakarta.persistence.Column;

public class ViajeVIP extends  Viaje{

    @Column(nullable = false)
    private String beneficiosExclusivos;

    @Column(nullable = false)
    private Boolean transportePrivado;
}
