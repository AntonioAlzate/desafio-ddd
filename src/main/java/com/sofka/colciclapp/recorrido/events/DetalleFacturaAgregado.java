package com.sofka.colciclapp.recorrido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.recorrido.values.DetalleFactura;

public class DetalleFacturaAgregado extends DomainEvent {

    private final DetalleFactura detalleFactura;

    public DetalleFacturaAgregado(DetalleFactura detalleFactura) {
        super("sofka.recorrido.detallefacturagregado");
        this.detalleFactura = detalleFactura;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }
}
