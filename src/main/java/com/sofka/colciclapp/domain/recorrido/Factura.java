package com.sofka.colciclapp.domain.recorrido;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.genericos.Precio;
import com.sofka.colciclapp.domain.recorrido.values.FacturaId;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Factura extends Entity<FacturaId> {

    private Set<DetalleFactura> detallesFactura;
    private Fecha fecha;
    private Precio precio;

    public Factura(FacturaId entityId) {
        super(entityId);
        fecha = new Fecha(LocalDateTime.now());
        precio = new Precio(0d);
        detallesFactura = new HashSet<>();
    }

    public void agregarDetalle(DetalleFactura detalleFactura) {
        Objects.requireNonNull(detalleFactura, "no puede agregar un detalle nulo");
        detallesFactura.add(detalleFactura);
    }

    public void QuitarDetalle(DetalleFactura detalleFactura) {
        Objects.requireNonNull(detalleFactura, "no puede enviar un detalle nulo");
        if (!detallesFactura.contains(detalleFactura)) {
            throw new IllegalArgumentException("El detalle no existe en la factura");
        }
        detallesFactura.remove(detalleFactura);
    }

    public Set<DetalleFactura> detallesFactura() {
        return detallesFactura;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Precio precio() {
        return precio;
    }
}
