package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Color;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import com.sofka.colciclapp.domain.vigia.commands.AgregarMotoCommand;
import com.sofka.colciclapp.domain.vigia.events.MotoAgregada;
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
class AgregarMotoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarMoto(){

        VigiaId vigiaId = VigiaId.of("xxxx");
        MotoId motoId = MotoId.of("yyyy");
        TipoMoto tipoMoto = new TipoMoto(Proposito.ADVENTURE);
        MarcaMoto marca = new MarcaMoto("HONDA");
        ColorVehiculo color = new ColorVehiculo(Color.AZUL);
        var command = new AgregarMotoCommand(vigiaId, motoId, tipoMoto, marca, color);
        var usecase = new AgregarMotoUseCase();


        when(repository.getEventsBy("xxxx")).thenReturn(getEvent());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(vigiaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (MotoAgregada) events.get(0);

        Assertions.assertEquals("yyyy", event.getEntityId().value());
        Assertions.assertEquals(Proposito.ADVENTURE, event.getTipo().value());
        Assertions.assertEquals(Color.AZUL, event.getColor().value());
        Assertions.assertEquals("HONDA", event.getMarca().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    @Test
    void agregarMoto_errorPorCantidad(){

        VigiaId vigiaId = VigiaId.of("xxxx");
        MotoId motoId = MotoId.of("yyyy");
        TipoMoto tipoMoto = new TipoMoto(Proposito.ADVENTURE);
        MarcaMoto marca = new MarcaMoto("HONDA");
        ColorVehiculo color = new ColorVehiculo(Color.AZUL);
        var command = new AgregarMotoCommand(vigiaId, motoId, tipoMoto, marca, color);
        var usecase = new AgregarMotoUseCase();


        when(repository.getEventsBy("xxxx")).thenReturn(getEvents());
        usecase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, ()->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(vigiaId.value())
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        });
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

    private List<DomainEvent> getEvents() {
        return List.of(
                new VigiaCreado(
                        PersonaId.of("bbbb"),
                        PerfilId.of("cccc"),
                        new Descripcion("Experto en viajes largos"),
                        Especialidad.ACOMPAÑAMIENTO
                ),
                new MotoAgregada(
                        MotoId.of("1"),
                        new TipoMoto(Proposito.NAKED),
                        new MarcaMoto("YAMAHA"),
                        new ColorVehiculo(Color.AZUL)
                ),
                new MotoAgregada(
                        MotoId.of("2"),
                        new TipoMoto(Proposito.NAKED),
                        new MarcaMoto("YAMAHA"),
                        new ColorVehiculo(Color.AZUL)
                ),
                new MotoAgregada(
                        MotoId.of("3"),
                        new TipoMoto(Proposito.NAKED),
                        new MarcaMoto("YAMAHA"),
                        new ColorVehiculo(Color.AZUL)
                ),
                new MotoAgregada(
                        MotoId.of("4"),
                        new TipoMoto(Proposito.NAKED),
                        new MarcaMoto("YAMAHA"),
                        new ColorVehiculo(Color.AZUL)
                ),
                new MotoAgregada(
                        MotoId.of("5"),
                        new TipoMoto(Proposito.NAKED),
                        new MarcaMoto("YAMAHA"),
                        new ColorVehiculo(Color.AZUL)
                )
        );
    }

}