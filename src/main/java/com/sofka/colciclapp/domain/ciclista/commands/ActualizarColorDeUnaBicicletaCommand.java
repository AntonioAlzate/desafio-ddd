package com.sofka.colciclapp.domain.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;

public class ActualizarColorDeUnaBicicletaCommand extends Command {

    private final CiclistaId ciclistaId;
    private final BicicletaId bicicletaId;
    private final ColorVehiculo color;

    public ActualizarColorDeUnaBicicletaCommand(CiclistaId ciclistaId, BicicletaId bicicletaId, ColorVehiculo color) {

        this.ciclistaId = ciclistaId;
        this.bicicletaId = bicicletaId;
        this.color = color;
    }

    public CiclistaId getCiclistaId() {
        return ciclistaId;
    }

    public BicicletaId getBicicletaId() {
        return bicicletaId;
    }

    public ColorVehiculo getColor() {
        return color;
    }
}
