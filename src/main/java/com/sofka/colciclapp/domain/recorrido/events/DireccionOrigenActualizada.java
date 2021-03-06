package com.sofka.colciclapp.domain.recorrido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;

public class DireccionOrigenActualizada extends DomainEvent {
    private final Direccion direccionOrigen;

    public DireccionOrigenActualizada(Direccion direccionOrigen) {
        super("sofka.recorrido.direccionorigenactualizada");
        this.direccionOrigen = direccionOrigen;
    }

    public Direccion getDireccionOrigen() {
        return direccionOrigen;
    }
}
