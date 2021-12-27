package com.sofka.colciclapp.usecase.services;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.colciclapp.domain.ciclista.events.RecorridoGenerado;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

import java.util.List;

public class NotificarRecorridoGeneradoExitosamenteUseCase extends UseCase<TriggeredEvent<RecorridoGenerado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RecorridoGenerado> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();

        var service = getService(EnviarNotificacionService.class).orElseThrow();

        Boolean esValido = service.enviar(
                "soporte@colciclapp.com",
                "Recorrido creado exitosamente",
                RecorridoId.of(event.aggregateRootId())
        );

        if (!esValido) {
            throw new BusinessException(event.aggregateRootId(), "No es posible notificar la creación del recorrido");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
