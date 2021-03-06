package com.sofka.colciclapp.domain.recorrido;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Precio;
import com.sofka.colciclapp.domain.recorrido.values.ServicioId;

import java.util.Objects;

public class Servicio extends Entity<ServicioId> {

    private Descripcion descripcion;
    private Precio precio;

    public Servicio(ServicioId entityId, Descripcion descripcion, Precio precio) {
        super(entityId);
        this.descripcion = Objects.requireNonNull(descripcion);
        this.precio = Objects.requireNonNull(precio);
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        Objects.requireNonNull(descripcion, "La descripcion es requerida");
        this.descripcion = descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Precio precio() {
        return precio;
    }
}
