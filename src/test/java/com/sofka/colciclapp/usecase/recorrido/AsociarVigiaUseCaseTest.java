package com.sofka.colciclapp.usecase.recorrido;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.commands.AsociarVigiaCommand;
import com.sofka.colciclapp.domain.recorrido.events.RecorridoCreado;
import com.sofka.colciclapp.domain.recorrido.events.VigiaAsociadoARecorrido;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.recorrido.values.RutaId;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsociarVigiaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void asociarCuenta() {
        RecorridoId recorridoId = RecorridoId.of("xxxx");
        VigiaId vigiaId = VigiaId.of("aaaa");
        var command = new AsociarVigiaCommand(recorridoId, vigiaId);
        var usecase = new AsociarVigiaUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(getEvent());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(recorridoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (VigiaAsociadoARecorrido) events.get(0);

        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getVigiaId().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> getEvent() {
        return List.of(
                new RecorridoCreado(
                        RutaId.of("aaaa"),
                        new Direccion("asd", 4d, 5d),
                        new Direccion("oioouio", 7d, 8d),
                        new Descripcion("Ruta pruebas"),
                        new Fecha(LocalDateTime.now())
                )
        );
    }
}