package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Color;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import com.sofka.colciclapp.domain.vigia.commands.QuitarUnaMotoCommand;
import com.sofka.colciclapp.domain.vigia.events.MotoAgregada;
import com.sofka.colciclapp.domain.vigia.events.MotoQuitada;
import com.sofka.colciclapp.domain.vigia.events.VigiaCreado;
import com.sofka.colciclapp.domain.vigia.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuitarMotoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void quitarUnaMoto(){

        VigiaId vigiaId = VigiaId.of("xxxx");
        MotoId motoId = MotoId.of("1111");
        var command = new QuitarUnaMotoCommand(vigiaId, motoId);
        var usecase = new QuitarMotoUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(getEvents());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(vigiaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (MotoQuitada) events.get(0);

        Assertions.assertEquals("1111", event.getMotoId().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> getEvents() {
        return List.of(
                new VigiaCreado(
                        PersonaId.of("bbbb"),
                        PerfilId.of("cccc"),
                        new Descripcion("Experto en viajes largos"),
                        Especialidad.ACOMPAÑAMIENTO
                ),
                new MotoAgregada(
                        MotoId.of("1111"),
                        new TipoMoto(Proposito.NAKED),
                        new MarcaMoto("YAMAHA"),
                        new ColorVehiculo(Color.AZUL)
                )
        );
    }
}