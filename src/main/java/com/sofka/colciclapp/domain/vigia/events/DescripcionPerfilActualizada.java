package com.sofka.colciclapp.domain.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Descripcion;

public class DescripcionPerfilActualizada extends DomainEvent {
    private final Descripcion descripcion;

    public DescripcionPerfilActualizada(Descripcion descripcion) {
        super("sofka.vigia.descripcionperfilactualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
