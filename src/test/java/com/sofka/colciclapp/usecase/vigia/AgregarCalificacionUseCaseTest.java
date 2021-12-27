package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import com.sofka.colciclapp.domain.vigia.commands.AgregarCalificacionCommand;
import com.sofka.colciclapp.domain.vigia.events.CalificacionAgregada;
import com.sofka.colciclapp.domain.vigia.events.VigiaCreado;
import com.sofka.colciclapp.domain.vigia.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarCalificacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarCalificacion() {
        VigiaId vigiaId = VigiaId.of("xxxx");
        CalificacionId calificacionId = CalificacionId.of("aaaa");
        Puntuacion puntuacion = new Puntuacion(CiclistaId.of("bbbb"), "Muy agradable", Puntaje.MUY_BUENO);
        var command = new AgregarCalificacionCommand(vigiaId, calificacionId, puntuacion);
        var usecase = new AgregarCalificacionUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(getEvent());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(vigiaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CalificacionAgregada) events.get(0);

        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getCalificacionId().value());
        Assertions.assertEquals(puntuacion, event.getPuntuacion());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> getEvent() {
        return List.of(
                new VigiaCreado(
                        PersonaId.of("bbbb"),
                        PerfilId.of("cccc"),
                        new Descripcion("Experto en viajes largos"),
                        Especialidad.ACOMPAÑAMIENTO
                )
        );
    }

}