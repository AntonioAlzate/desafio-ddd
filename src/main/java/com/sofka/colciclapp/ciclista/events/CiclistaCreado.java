package com.sofka.colciclapp.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.ciclista.Bicicleta;
import com.sofka.colciclapp.ciclista.values.BicicletaId;
import com.sofka.colciclapp.ciclista.values.MarcaBicicleta;
import com.sofka.colciclapp.ciclista.values.TipoBicicleta;
import com.sofka.colciclapp.genericos.ColorVehiculo;
import com.sofka.colciclapp.genericos.PersonaId;

public class CiclistaCreado extends DomainEvent {


    private final BicicletaId bicicletaId;
    private final TipoBicicleta tipoBicicleta;
    private final MarcaBicicleta marca;
    private final ColorVehiculo color;
    private final PersonaId personaId;

    public CiclistaCreado(PersonaId personaId, BicicletaId bicicletaId, TipoBicicleta tipoBicicleta, MarcaBicicleta marca, ColorVehiculo color) {
        super("sofka.ciclista.ciclistacreado");
        this.personaId = personaId;
        this.bicicletaId = bicicletaId;
        this.tipoBicicleta = tipoBicicleta;
        this.marca = marca;
        this.color = color;
    }

    public PersonaId getPersonaId() {
        return personaId;
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
