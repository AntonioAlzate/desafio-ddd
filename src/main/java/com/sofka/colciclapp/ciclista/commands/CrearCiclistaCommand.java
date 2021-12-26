package com.sofka.colciclapp.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.ciclista.values.BicicletaId;
import com.sofka.colciclapp.ciclista.values.CiclistaId;
import com.sofka.colciclapp.ciclista.values.MarcaBicicleta;
import com.sofka.colciclapp.ciclista.values.TipoBicicleta;
import com.sofka.colciclapp.genericos.ColorVehiculo;

public class CrearCiclistaCommand extends Command {

    private final CiclistaId entityId;
    private final BicicletaId bicicletaId;
    private final TipoBicicleta tipoBicicleta;
    private final MarcaBicicleta marca;
    private final ColorVehiculo color;

    public CrearCiclistaCommand(CiclistaId entityId, BicicletaId bicicletaId, TipoBicicleta tipoBicicleta, MarcaBicicleta marca, ColorVehiculo color){

        this.entityId = entityId;
        this.bicicletaId = bicicletaId;
        this.tipoBicicleta = tipoBicicleta;
        this.marca = marca;
        this.color = color;
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
