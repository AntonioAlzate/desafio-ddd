package com.sofka.colciclapp.usecase.ciclista;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.ciclista.commands.AgregarBicicletaCommand;
import com.sofka.colciclapp.domain.ciclista.events.BicicletaAgregada;
import com.sofka.colciclapp.domain.ciclista.events.CiclistaCreado;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.ciclista.values.MarcaBicicleta;
import com.sofka.colciclapp.domain.ciclista.values.TipoBicicleta;
import com.sofka.colciclapp.domain.genericos.Color;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarBicicletaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarBicicleta(){

        CiclistaId ciclistaId = CiclistaId.of("xxxx");
        BicicletaId bicicletaId = BicicletaId.of("yyyy");
        TipoBicicleta tipoBicicleta = TipoBicicleta.PISTA;
        MarcaBicicleta marca = new MarcaBicicleta("GW");
        ColorVehiculo color = new ColorVehiculo(Color.AZUL);
        var command = new AgregarBicicletaCommand(ciclistaId, bicicletaId, tipoBicicleta, marca, color);
        var usecase = new AgregarBicicletaUseCase();


        when(repository.getEventsBy("xxxx")).thenReturn(getEvent());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ciclistaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (BicicletaAgregada) events.get(0);

        Assertions.assertEquals("yyyy", event.getBicicletaId().value());
        Assertions.assertEquals(TipoBicicleta.PISTA, event.getTipoBicicleta());
        Assertions.assertEquals(Color.AZUL, event.getColor().value());
        Assertions.assertEquals("GW", event.getMarca().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    @Test
    void agregarBicicleta_errorPorCantidad(){

        CiclistaId ciclistaId = CiclistaId.of("xxxx");
        BicicletaId bicicletaId = BicicletaId.of("yyyy");
        TipoBicicleta tipoBicicleta = TipoBicicleta.PISTA;
        MarcaBicicleta marca = new MarcaBicicleta("GW");
        ColorVehiculo color = new ColorVehiculo(Color.AZUL);
        var command = new AgregarBicicletaCommand(ciclistaId, bicicletaId, tipoBicicleta, marca, color);
        var usecase = new AgregarBicicletaUseCase();


        when(repository.getEventsBy("xxxx")).thenReturn(getEvents());
        usecase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, ()->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(ciclistaId.value())
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> getEvent() {
        return List.of(
                new CiclistaCreado(
                        PersonaId.of("bbbb"),
                        BicicletaId.of("cccc"),
                        TipoBicicleta.TROCHA,
                        new MarcaBicicleta("GW"),
                        new ColorVehiculo(Color.AZUL)
                )
        );
    }

    private List<DomainEvent> getEvents() {
        return List.of(
                new CiclistaCreado(
                        PersonaId.of("bbbb"),
                        BicicletaId.of("cccc"),
                        TipoBicicleta.TROCHA,
                        new MarcaBicicleta("GW"),
                        new ColorVehiculo(Color.AZUL)
                ),
                new BicicletaAgregada(
                        BicicletaId.of("dddd"),
                        TipoBicicleta.TROCHA,
                        new MarcaBicicleta("GW"),
                        new ColorVehiculo(Color.AZUL)
                ),
                new BicicletaAgregada(
                        BicicletaId.of("eeee"),
                        TipoBicicleta.TROCHA,
                        new MarcaBicicleta("GW"),
                        new ColorVehiculo(Color.AZUL)
                ),
                new BicicletaAgregada(
                        BicicletaId.of("ffff"),
                        TipoBicicleta.TROCHA,
                        new MarcaBicicleta("GW"),
                        new ColorVehiculo(Color.AZUL)
                ),
                new BicicletaAgregada(
                        BicicletaId.of("gggg"),
                        TipoBicicleta.TROCHA,
                        new MarcaBicicleta("GW"),
                        new ColorVehiculo(Color.AZUL)
                )
        );
    }

}