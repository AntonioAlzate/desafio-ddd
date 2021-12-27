package com.sofka.colciclapp.usecase.recorrido;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.ciclista.events.FavoritoAgregadoALaCuenta;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.commands.IniciarRecorridoCommand;
import com.sofka.colciclapp.domain.recorrido.events.RecorridoCreado;
import com.sofka.colciclapp.domain.recorrido.events.RecorridoIniciado;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.recorrido.values.RutaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IniciarRecorridoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void iniciarRecorrido(){
        RecorridoId recorridoId = RecorridoId.of("xxxx");
        var command = new IniciarRecorridoCommand(recorridoId);
        var usecase = new IniciarRecorridoUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(getEvent());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(recorridoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (RecorridoIniciado) events.get(0);

        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    @Test
    void iniciarRecorrido_errorYaEstaIniciado(){
        RecorridoId recorridoId = RecorridoId.of("xxxx");
        var command = new IniciarRecorridoCommand(recorridoId);
        var usecase = new IniciarRecorridoUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(getEvents());
        usecase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, ()->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(recorridoId.value())
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> getEvent() {
        return  List.of(
                new RecorridoCreado(
                        RutaId.of("aaaa"),
                        new Direccion("asd", 4d, 5d),
                        new Direccion("oioouio", 7d, 8d),
                        new Descripcion("Ruta pruebas"),
                        new Fecha(LocalDateTime.now())
                )
        );
    }

    private List<DomainEvent> getEvents() {
        return  List.of(
                new RecorridoCreado(
                        RutaId.of("aaaa"),
                        new Direccion("asd", 4d, 5d),
                        new Direccion("oioouio", 7d, 8d),
                        new Descripcion("Ruta pruebas"),
                        new Fecha(LocalDateTime.now())
                ),
                new RecorridoIniciado()
        );
    }
}