package com.sofka.colciclapp.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.colciclapp.domain.ciclista.events.RecorridoGenerado;
import com.sofka.colciclapp.domain.recorrido.Recorrido;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.usecase.services.DistanciaARecorrerService;

import java.util.List;

public class CalcularDistanciaRecorridoUseCase extends UseCase<TriggeredEvent<RecorridoGenerado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RecorridoGenerado> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();
        var recorridoId = RecorridoId.of(event.aggregateRootId());
        var recorrido = Recorrido.from(recorridoId, retrieveEvents());
        var service = getService(DistanciaARecorrerService.class).orElseThrow();


        Double distanciaARecorrer =
                service.calcularDistancia(
                        recorridoId,
                        event.getDireccionOrigen(),
                        event.getDireccionDestino()
                );

        if (distanciaARecorrer <= 0) {
            throw new BusinessException(event.aggregateRootId(), "Error al calcular la distancia" +
                    " el valor no puede ser igual o menor a cero");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
