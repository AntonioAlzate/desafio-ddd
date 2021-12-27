package com.sofka.colciclapp.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.ciclista.events.RecorridoGenerado;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.events.RecorridoCreado;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.recorrido.values.RutaId;
import com.sofka.colciclapp.usecase.services.DistanciaARecorrerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalcularDistanciaRecorridoUseCaseTest {

    @Mock
    DistanciaARecorrerService distanciaARecorrerService;

    @Mock
    DomainEventRepository repository;

    @Test
    void calcularDistaciaARecorrer() {
        RecorridoId recorridoId = RecorridoId.of("xxxx");
        RutaId rutaId = RutaId.of("aaaa");
        Direccion direccionOrigen = new Direccion("Cll4-45", 12d, 3d);
        Direccion direccionDestino = new Direccion("Cll56-122", 13d, 5d);
        Descripcion descripcion = new Descripcion("Paseo de rutina");
        Fecha fecha = new Fecha(LocalDateTime.now());

        var event = new RecorridoGenerado(recorridoId, rutaId, direccionOrigen, direccionDestino, descripcion, fecha);
        event.setAggregateRootId(recorridoId.value());
        var usecase = new CalcularDistanciaRecorridoUseCase();

        when(distanciaARecorrerService.calcularDistancia(
                recorridoId,
                direccionOrigen,
                direccionDestino
        )).thenReturn(100d);

        when(repository.getEventsBy("xxxx")).thenReturn(getEvent());
        usecase.addRepository(repository);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(distanciaARecorrerService);
        usecase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(recorridoId.value())
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(distanciaARecorrerService).calcularDistancia(
                recorridoId,
                direccionOrigen,
                direccionDestino
        );
    }

    @Test
    void calcularDistaciaARecorrer_errorEnValorDevuelto() {
        RecorridoId recorridoId = RecorridoId.of("xxxx");
        RutaId rutaId = RutaId.of("aaaa");
        Direccion direccionOrigen = new Direccion("Cll4-45", 12d, 3d);
        Direccion direccionDestino = new Direccion("Cll56-122", 13d, 5d);
        Descripcion descripcion = new Descripcion("Paseo de rutina");
        Fecha fecha = new Fecha(LocalDateTime.now());

        var event = new RecorridoGenerado(recorridoId, rutaId, direccionOrigen, direccionDestino, descripcion, fecha);
        event.setAggregateRootId(recorridoId.value());
        var usecase = new CalcularDistanciaRecorridoUseCase();

        when(distanciaARecorrerService.calcularDistancia(
                recorridoId,
                direccionOrigen,
                direccionDestino
        )).thenReturn(-100d);

        when(repository.getEventsBy("xxxx")).thenReturn(getEvent());
        usecase.addRepository(repository);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(distanciaARecorrerService);
        usecase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(recorridoId.value())
                    .syncExecutor(usecase, new TriggeredEvent<>(event))
                    .orElseThrow();
        });
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