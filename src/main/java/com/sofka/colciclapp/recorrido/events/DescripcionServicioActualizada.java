package com.sofka.colciclapp.recorrido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.genericos.Descripcion;
import com.sofka.colciclapp.recorrido.values.ServicioId;

public class DescripcionServicioActualizada extends DomainEvent {
    private final Descripcion descripcion;
    private final ServicioId servicioId;

    public DescripcionServicioActualizada(ServicioId servicioId, Descripcion descripcion) {
        super("sofka.recorrido.descripcionservicioactualizada");
        this.descripcion = descripcion;
        this.servicioId =servicioId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }
}
