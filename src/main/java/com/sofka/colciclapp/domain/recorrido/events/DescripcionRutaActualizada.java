package com.sofka.colciclapp.domain.recorrido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Descripcion;

public class DescripcionRutaActualizada extends DomainEvent {
    private final Descripcion descripcion;

    public DescripcionRutaActualizada(Descripcion descripcion) {
        super("sofka.recorrido.descripcionrutaactualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
