package com.sofka.colciclapp.usecase.services;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.colciclapp.domain.ciclista.events.RecorridoGenerado;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.recorrido.values.RutaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarRecorridoGeneradoExitosamenteUseCaseTest {

    @Mock
    EnviarNotificacionService notificacionService;

    @Test
    void notificarRecorridoGenerado(){
        RecorridoId recorridoId = RecorridoId.of("xxxx");
        RutaId rutaId = RutaId.of("aaaa");
        Direccion direccionOrigen=new Direccion("Cll4-45", 12d, 3d);
        Direccion direccionDestino=new Direccion("Cll56-122", 13d, 5d);
        Descripcion descripcion=new Descripcion("Paseo de rutina");
        Fecha fecha = new Fecha(LocalDateTime.now());

        var event = new RecorridoGenerado(recorridoId, rutaId, direccionOrigen, direccionDestino, descripcion, fecha);
        event.setAggregateRootId(recorridoId.value());
        var usecase = new NotificarRecorridoGeneradoExitosamenteUseCase();

        when(notificacionService.enviar("soporte@colciclapp.com",
                "Recorrido creado exitosamente",
                recorridoId)).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(notificacionService);
        usecase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(notificacionService).enviar(
                "soporte@colciclapp.com",
                "Recorrido creado exitosamente",
                recorridoId);
    }

    @Test
    void notificarRecorridoGenerado_error(){
        RecorridoId recorridoId = RecorridoId.of("xxxx");
        RutaId rutaId = RutaId.of("aaaa");
        Direccion direccionOrigen=new Direccion("Cll4-45", 12d, 3d);
        Direccion direccionDestino=new Direccion("Cll56-122", 13d, 5d);
        Descripcion descripcion=new Descripcion("Paseo de rutina");
        Fecha fecha = new Fecha(LocalDateTime.now());

        var event = new RecorridoGenerado(recorridoId, rutaId, direccionOrigen, direccionDestino, descripcion, fecha);
        event.setAggregateRootId(recorridoId.value());
        var usecase = new NotificarRecorridoGeneradoExitosamenteUseCase();

        when(notificacionService.enviar("soporte@colciclapp.com",
                "Recorrido creado exitosamente",
                recorridoId)).thenReturn(false);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(notificacionService);
        usecase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () ->{
            UseCaseHandler.getInstance()
                    .syncExecutor(usecase, new TriggeredEvent<>(event))
                    .orElseThrow();
        });
    }
}