package com.sofka.colciclapp.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.ciclista.values.BicicletaId;
import com.sofka.colciclapp.genericos.ColorVehiculo;

public class ColorBicicletaActualizada extends DomainEvent {
    private final BicicletaId bicicletaId;
    private final ColorVehiculo color;

    public ColorBicicletaActualizada(BicicletaId bicicletaId, ColorVehiculo color) {
        super("sofka.ciclista.colorbicicletaactualizado");
        this.bicicletaId = bicicletaId;
        this.color = color;
    }

    public BicicletaId getBicicletaId() {
        return bicicletaId;
    }

    public ColorVehiculo getColor() {
        return color;
    }
}
