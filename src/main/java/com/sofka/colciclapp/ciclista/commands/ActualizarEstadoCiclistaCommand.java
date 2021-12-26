package com.sofka.colciclapp.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.ciclista.values.CiclistaId;
import com.sofka.colciclapp.genericos.EstadoEntidad;

public class ActualizarEstadoCiclistaCommand extends Command {

    private final CiclistaId ciclistaId;
    private final EstadoEntidad estado;

    public ActualizarEstadoCiclistaCommand(CiclistaId ciclistaId, EstadoEntidad estado){

        this.ciclistaId = ciclistaId;
        this.estado = estado;
    }

    public CiclistaId getCiclistaId() {
        return ciclistaId;
    }

    public EstadoEntidad getEstado() {
        return estado;
    }
}
