package com.sofka.colciclapp.domain.ciclista;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.colciclapp.domain.ciclista.events.*;
import com.sofka.colciclapp.domain.ciclista.values.CuentaId;
import com.sofka.colciclapp.domain.genericos.Estado;
import com.sofka.colciclapp.domain.genericos.EstadoEntidad;
import com.sofka.colciclapp.domain.recorrido.Recorrido;

import java.util.HashSet;
import java.util.Set;

public class CiclistaChange extends EventChange {
    public CiclistaChange(Ciclista ciclista) {

        apply((CiclistaCreado event) -> {
            var bicicleta = new Bicicleta(
                    event.getBicicletaId(),
                    event.getTipoBicicleta(),
                    event.getMarca(),
                    event.getColor()
            );

            ciclista.personaId = event.getPersonaId();
            ciclista.recorridoIds = new HashSet<>();
            ciclista.bicicletas = new HashSet<>();
            ciclista.cuenta = new Cuenta(new CuentaId());
            ciclista.estado = new EstadoEntidad(Estado.ACTIVO);

            ciclista.bicicletas.add(bicicleta);
        });

        apply((BicicletaAgregada event) -> {

            ciclista.bicicletas.add(
                    new Bicicleta(
                            event.getBicicletaId(),
                            event.getTipoBicicleta(),
                            event.getMarca(),
                            event.getColor())
            );
        });

        apply((ColorBicicletaActualizada event) -> {
            var bicicleta = ciclista.obtenerBicicletaPorId(event.getBicicletaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la bicicleta a actualizar"));

            bicicleta.actualizarColor(event.getColor());
        });

        apply((EstadoCiclistaActualizado event) -> {
            ciclista.estado = event.getEstado();
        });

        apply((FavoritoAgregadoALaCuenta event) -> {
            ciclista.cuenta.agregarFavorito(event.getFavorito());
        });

        apply((FavoritoQuitadoDeLaCuenta event) -> {
            ciclista.cuenta.quitarFavorito(event.getFavorito());
        });

        apply((MarcaBicicletaActualizada event) -> {
            var bicicleta = ciclista.obtenerBicicletaPorId(event.getBicicletaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la bicicleta a actualizar"));

            bicicleta.actualizarMarca(event.getMarca());
        });

        apply((RecorridoGenerado event) -> {

            var recorrido = new Recorrido(
                    event.getRecorridoId(),
                    event.getRutaId(),
                    event.getDireccionOrigen(),
                    event.getDireccionDestino(),
                    event.getDescripcion(),
                    event.getFecha()
                    );

            ciclista.recorridoIds.add(recorrido.identity());
        });

        apply((TipoBicicletaActualizada event) -> {
            var bicicleta = ciclista.obtenerBicicletaPorId(event.getBicicletaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la bicicleta a actualizar"));

            bicicleta.actualizarTipoBicicleta(event.getTipo());
        });
    }
}
