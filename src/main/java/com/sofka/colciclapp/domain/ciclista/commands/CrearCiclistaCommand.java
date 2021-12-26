package com.sofka.colciclapp.domain.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.ciclista.values.MarcaBicicleta;
import com.sofka.colciclapp.domain.ciclista.values.TipoBicicleta;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.genericos.PersonaId;

public class CrearCiclistaCommand extends Command {

    private final CiclistaId entityId;
    private final BicicletaId bicicletaId;
    private final TipoBicicleta tipoBicicleta;
    private final MarcaBicicleta marca;
    private final ColorVehiculo color;
    private final PersonaId personaId;

    public CrearCiclistaCommand(CiclistaId entityId, PersonaId personaId, BicicletaId bicicletaId, TipoBicicleta tipoBicicleta, MarcaBicicleta marca, ColorVehiculo color) {

        this.entityId = entityId;
        this.personaId = personaId;
        this.bicicletaId = bicicletaId;
        this.tipoBicicleta = tipoBicicleta;
        this.marca = marca;
        this.color = color;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public CiclistaId getEntityId() {
        return entityId;
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
