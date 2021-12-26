package com.sofka.colciclapp.domain.recorrido;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Precio;
import com.sofka.colciclapp.domain.recorrido.events.*;
import com.sofka.colciclapp.domain.recorrido.values.DetalleFactura;
import com.sofka.colciclapp.domain.recorrido.values.FacturaId;
import com.sofka.colciclapp.domain.recorrido.values.Iniciado;
import com.sofka.colciclapp.domain.recorrido.values.ServicioId;

import java.util.Set;

public class RecorridoChange extends EventChange {
    public RecorridoChange(Recorrido recorrido) {

        apply((RecorridoCreado event) -> {
            var factura = new Factura(new FacturaId());
            var servicio = servicioBase();
            factura.agregarDetalle(new DetalleFactura(servicioBase().identity(),
                    new Descripcion("Servicio base por recorrido")));

            recorrido.ruta = event.getRuta();
            recorrido.fecha = event.getFecha();
            recorrido.iniciado = new Iniciado(Boolean.FALSE);
            recorrido.factura = factura;
            recorrido.servicios = Set.of(servicio);
        });

        apply((RecorridoIniciado event) -> {
            if (recorrido.iniciado.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("El recorrido ya se encuentra iniciado");
            }
            recorrido.IniciarRecorrido();
        });

        apply((DescripcionRutaActualizada event) -> {
            recorrido.ruta.actualizarDescripcion(event.getDescripcion());
        });

        apply((DescripcionServicioActualizada event) -> {
            var servicio = recorrido.obtenerServicioPorId(event.getServicioId())
                    .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));
            servicio.actualizarDescripcion(event.getDescripcion());
        });

        apply((DetalleFacturaAgregado event) -> {
            recorrido.factura.agregarDetalle(event.getDetalleFactura());
        });

        apply((DireccionDestinoActualizada event) -> {
            if (recorrido.iniciado.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("No se puede actualizar la dirección de destino si el recorrido" +
                        "ya se encuentra iniciado");
            }

            recorrido.ruta.actualizarDireccionDestino(event.getDireccionDestino());
        });

        apply((DireccionOrigenActualizada event) -> {
            if (recorrido.iniciado.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("No se puede actualizar la dirección de origen si el recorrido" +
                        "ya se encuentra iniciado");
            }

            recorrido.ruta.actualizarDireccionOrigen(event.getDireccionOrigen());
        });

    }

    private Servicio servicioBase() {
        return new Servicio(ServicioId.of("11111"),
                new Descripcion("Valor Base"),
                new Precio(120000d));
    }
}
