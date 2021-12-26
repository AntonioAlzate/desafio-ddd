package com.sofka.colciclapp.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.genericos.EstadoEntidad;

public class EstadoCiclistaActualizado extends DomainEvent {
    private final EstadoEntidad estado;

    public EstadoCiclistaActualizado(EstadoEntidad estado) {
        super("sofka.ciclista.estadoactualizado");
        this.estado = estado;
    }

    public EstadoEntidad getEstado() {
        return estado;
    }
}
