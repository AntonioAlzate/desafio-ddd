package com.sofka.colciclapp.domain.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.Ruta;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

public class RecorridoGenerado extends DomainEvent {
    private final RecorridoId recorridoId;
    private final Ruta ruta;
    private final Fecha fecha;

    public RecorridoGenerado(RecorridoId recorridoId, Ruta ruta, Fecha fecha) {
        super("sofka.ciclista.recorridogenerado");
        this.recorridoId = recorridoId;
        this.ruta = ruta;
        this.fecha = fecha;
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
