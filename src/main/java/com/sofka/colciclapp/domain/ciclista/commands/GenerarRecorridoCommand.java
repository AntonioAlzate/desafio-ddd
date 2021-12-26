package com.sofka.colciclapp.domain.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.Ruta;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

public class GenerarRecorridoCommand extends Command {

    private final RecorridoId recorridoId;
    private final Ruta ruta;
    private final Fecha fecha;
    private final CiclistaId ciclistaId;

    public GenerarRecorridoCommand(CiclistaId ciclistaId, RecorridoId recorridoId, Ruta ruta, Fecha fecha) {
        this.ciclistaId = ciclistaId;
        this.recorridoId = recorridoId;
        this.ruta = ruta;
        this.fecha = fecha;
    }

    public CiclistaId getCiclistaId() {
        return ciclistaId;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
