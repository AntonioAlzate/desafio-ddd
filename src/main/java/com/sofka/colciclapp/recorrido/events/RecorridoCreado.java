package com.sofka.colciclapp.recorrido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.genericos.Fecha;
import com.sofka.colciclapp.recorrido.Ruta;

public class RecorridoCreado extends DomainEvent {
    private final Ruta ruta;
    private final Fecha fecha;

    public RecorridoCreado(Ruta ruta, Fecha fecha) {
        super("sofka.recorrido.recorridocreado");
        this.ruta = ruta;
        this.fecha = fecha;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
