package com.sofka.colciclapp.usecase.recorrido;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.commands.CrearRecorridoCommand;
import com.sofka.colciclapp.domain.recorrido.events.RecorridoCreado;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.recorrido.values.RutaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CrearRecorridoUseCaseTest {

    @Test
    void crearRecorrido() {
        // arrange
        RecorridoId recorridoId = RecorridoId.of("xxxx");
        RutaId rutaId = RutaId.of("aaaa");
        Direccion direccionOrigen = new Direccion("Cll4-45", 12d, 3d);
        Direccion direccionDestino = new Direccion("Cll56-122", 13d, 5d);
        Descripcion descripcion = new Descripcion("Paseo de rutina");
        Fecha fecha = new Fecha(LocalDateTime.now());

        var command = new CrearRecorridoCommand(recorridoId, rutaId, direccionOrigen, direccionDestino, descripcion, fecha);
        var usecase = new CrearRecorridoUseCase();

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        // asserts
        RecorridoCreado event = (RecorridoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getRutaId().value());
        Assertions.assertEquals("Paseo de rutina", event.getDescripcion().value());
    }

}