package com.OnTour.AppOnTour.service;

import com.OnTour.AppOnTour.model.Viaje;
import com.OnTour.AppOnTour.model.ViajeVIP;
import com.OnTour.AppOnTour.repository.ViajeRepository;
import com.OnTour.AppOnTour.repository.ViajeVIPRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private ViajeVIPRepository viajeVIPRepository;

    public void guardarViaje (Viaje viaje) {
        viajeRepository.save(viaje);
    }

    public void guardarViajeVIP (ViajeVIP viajeVIP) {
        viajeVIPRepository.save(viajeVIP);
    }
}
