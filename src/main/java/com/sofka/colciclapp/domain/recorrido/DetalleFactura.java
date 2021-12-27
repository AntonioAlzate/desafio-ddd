package com.sofka.colciclapp.domain.recorrido;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.recorrido.values.DetalleId;
import com.sofka.colciclapp.domain.recorrido.values.ServicioId;

import java.util.Objects;

public class DetalleFactura extends Entity<DetalleId> {

    private final ServicioId servicioId;
    private Descripcion descripcion;

    public DetalleFactura(DetalleId entityId, ServicioId servicioId, Descripcion descripcion) {
        super(entityId);
        this.servicioId = Objects.requireNonNull(servicioId);
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public ServicioId servicioId() {
        return servicioId;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
