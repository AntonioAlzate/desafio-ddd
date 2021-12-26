package com.sofka.colciclapp.domain.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.MarcaBicicleta;
import com.sofka.colciclapp.domain.ciclista.values.TipoBicicleta;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;

public class BicicletaAgregada extends DomainEvent {
    private final BicicletaId bicicletaId;
    private final TipoBicicleta tipoBicicleta;
    private final MarcaBicicleta marca;
    private final ColorVehiculo color;

    public BicicletaAgregada(BicicletaId bicicletaId, TipoBicicleta tipoBicicleta, MarcaBicicleta marca, ColorVehiculo color) {
        super("sofka.ciclista.bicicletaagregada");
        this.bicicletaId = bicicletaId;
        this.tipoBicicleta = tipoBicicleta;
        this.marca = marca;
        this.color = color;
    }

    public BicicletaId getBicicletaId() {
        return bicicletaId;
    }

    public TipoBicicleta getTipoBicicleta() {
        return tipoBicicleta;
    }

    public MarcaBicicleta getMarca() {
        return marca;
    }

    public ColorVehiculo getColor() {
        return color;
    }
}
