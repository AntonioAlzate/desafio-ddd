package com.sofka.colciclapp.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.genericos.ColorVehiculo;
import com.sofka.colciclapp.vigia.values.MarcaMoto;
import com.sofka.colciclapp.vigia.values.MotoId;
import com.sofka.colciclapp.vigia.values.TipoMoto;

public class MotoAgregada extends DomainEvent {
    private final MotoId entityId;
    private final TipoMoto tipo;
    private final MarcaMoto marca;
    private final ColorVehiculo color;

    public MotoAgregada(MotoId entityId, TipoMoto tipo, MarcaMoto marca, ColorVehiculo color) {
        super("sofka.vigia.motoagregada");
        this.entityId = entityId;
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
    }

    public MotoId getEntityId() {
        return entityId;
    }

    public TipoMoto getTipo() {
        return tipo;
    }

    public MarcaMoto getMarca() {
        return marca;
    }

    public ColorVehiculo getColor() {
        return color;
    }
}
