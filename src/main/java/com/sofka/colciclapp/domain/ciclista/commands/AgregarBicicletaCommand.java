package com.sofka.colciclapp.domain.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.ciclista.values.MarcaBicicleta;
import com.sofka.colciclapp.domain.ciclista.values.TipoBicicleta;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;

public class AgregarBicicletaCommand extends Command {
    private final CiclistaId ciclistaId;
    private final BicicletaId bicicletaId;
    private final TipoBicicleta tipoBicicleta;
    private final MarcaBicicleta marca;
    private final ColorVehiculo color;

    public AgregarBicicletaCommand(CiclistaId ciclistaId, BicicletaId bicicletaId, TipoBicicleta tipoBicicleta, MarcaBicicleta marca, ColorVehiculo color) {

        this.ciclistaId = ciclistaId;
        this.bicicletaId = bicicletaId;
        this.tipoBicicleta = tipoBicicleta;
        this.marca = marca;
        this.color = color;
    }

    public CiclistaId getCiclistaId() {
        return ciclistaId;
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
