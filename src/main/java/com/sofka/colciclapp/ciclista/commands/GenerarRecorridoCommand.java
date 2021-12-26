package com.sofka.colciclapp.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.ciclista.values.CiclistaId;
import com.sofka.colciclapp.genericos.Fecha;
import com.sofka.colciclapp.recorrido.Ruta;
import com.sofka.colciclapp.recorrido.values.RecorridoId;

public class GenerarRecorridoCommand extends Command {

    private final RecorridoId recorridoId;
    private final Ruta ruta;
    private final Fecha fecha;
    private final CiclistaId ciclistaId;

    public GenerarRecorridoCommand(CiclistaId ciclistaId, RecorridoId recorridoId, Ruta ruta, Fecha fecha){
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
