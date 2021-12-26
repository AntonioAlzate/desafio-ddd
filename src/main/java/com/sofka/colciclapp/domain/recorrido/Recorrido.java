package com.sofka.colciclapp.domain.recorrido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.genericos.Precio;
import com.sofka.colciclapp.domain.recorrido.events.*;
import com.sofka.colciclapp.domain.recorrido.values.*;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Recorrido extends AggregateEvent<RecorridoId> {

    protected VigiaId vigiaId;
    protected Ruta ruta;
    protected Factura factura;
    protected Set<Servicio> servicios;
    protected Fecha fecha;
    protected Iniciado iniciado;
    protected Precio precioBase;

    public Recorrido(RecorridoId entityId, Ruta ruta, Fecha fecha) {
        super(entityId);
        appendChange(new RecorridoCreado(ruta, fecha)).apply();
    }

    private Recorrido(RecorridoId recorridoId) {
        super(recorridoId);
        subscribe(new RecorridoChange(this));
    }

    public static Recorrido from(RecorridoId recorridoId, List<DomainEvent> events) {
        var recorrido = new Recorrido(recorridoId);
        events.forEach(recorrido::applyEvent);
        return recorrido;
    }

    public void IniciarRecorrido() {
        appendChange(new RecorridoIniciado()).apply();
    }

    public void agregarDetalleAFactura(DetalleFactura detalleFactura) {
        Objects.requireNonNull(detalleFactura);
        appendChange(new DetalleFacturaAgregado(detalleFactura)).apply();
    }

    public void actualizarOrigenRuta(Direccion direccionOrigen) {
        Objects.requireNonNull(direccionOrigen);
        appendChange(new DireccionOrigenActualizada(direccionOrigen)).apply();
    }

    public void actualizarDestinoRuta(Direccion direccionDestino) {
        Objects.requireNonNull(direccionDestino);
        appendChange(new DireccionDestinoActualizada(direccionDestino)).apply();
    }

    public void actualizarDescripcionRuta(Descripcion descripcion) {
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionRutaActualizada(descripcion)).apply();
    }

    public void actualizarDescripcionServicio(ServicioId servicioId, Descripcion descripcion) {
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(servicioId);
        appendChange(new DescripcionServicioActualizada(servicioId, descripcion)).apply();
    }

    protected Optional<Servicio> obtenerServicioPorId(ServicioId servicioId) {
        return servicios
                .stream()
                .filter(servicio -> servicio.identity().equals(servicioId))
                .findFirst();
    }

    public VigiaId vigiaId() {
        return vigiaId;
    }

    public Ruta ruta() {
        return ruta;
    }

    public Factura factura() {
        return factura;
    }

    public Set<Servicio> servicios() {
        return servicios;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Iniciado estado() {
        return iniciado;
    }

    public Precio precioBase() {
        return precioBase;
    }
}
