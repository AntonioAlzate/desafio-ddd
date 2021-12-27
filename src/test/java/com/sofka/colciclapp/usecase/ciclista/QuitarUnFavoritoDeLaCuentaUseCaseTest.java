package com.sofka.colciclapp.usecase.ciclista;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.ciclista.commands.AgregarUnFavoritoALaCuentaCommand;
import com.sofka.colciclapp.domain.ciclista.commands.QuitarUnFavoritoDeLaCuentaCommand;
import com.sofka.colciclapp.domain.ciclista.events.CiclistaCreado;
import com.sofka.colciclapp.domain.ciclista.events.FavoritoAgregadoALaCuenta;
import com.sofka.colciclapp.domain.ciclista.events.FavoritoQuitadoDeLaCuenta;
import com.sofka.colciclapp.domain.ciclista.values.*;
import com.sofka.colciclapp.domain.genericos.Color;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
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
class QuitarUnFavoritoDeLaCuentaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void quitarUnFavoritoDeLaCuenta(){
        RecorridoId recorridoId = RecorridoId.of("aaaa");
        CiclistaId ciclistaId = CiclistaId.of("xxxx");
        Favorito favorito = new Favorito(recorridoId);
        var command = new QuitarUnFavoritoDeLaCuentaCommand(ciclistaId, favorito);
        var usecase = new QuitarUnFavoritoDeLaCuentaUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(getEvents());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ciclistaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (FavoritoQuitadoDeLaCuenta) events.get(0);

        Assertions.assertEquals("aaaa", event.getFavorito().value().toString());
        Mockito.verify(repository).getEventsBy("xxxx");
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
                new FavoritoAgregadoALaCuenta(
                        new Favorito(RecorridoId.of("aaaa"))
                )
        );
    }
}