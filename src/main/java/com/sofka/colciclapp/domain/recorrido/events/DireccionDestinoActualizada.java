package com.sofka.colciclapp.domain.recorrido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;

public class DireccionDestinoActualizada extends DomainEvent {
    private final Direccion direccionDestino;

    public DireccionDestinoActualizada(Direccion direccionDestino) {
        super("sofka.recorrido.direcciondestinoactualizada");
        this.direccionDestino = direccionDestino;
    }

    public Direccion getDireccionDestino() {
        return direccionDestino;
    }
}
