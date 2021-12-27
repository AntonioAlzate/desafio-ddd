package com.sofka.colciclapp.usecase.recorrido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.recorrido.Recorrido;
import com.sofka.colciclapp.domain.recorrido.commands.CrearRecorridoCommand;

public class CrearRecorridoUseCase extends UseCase<RequestCommand<CrearRecorridoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRecorridoCommand> requestCommand) {
        var command = requestCommand.getCommand();

        var recorrido = new Recorrido(
                command.getEntityId(),
                command.getRutaId(),
                command.getDireccionOrigen(),
                command.getDireccionDestino(),
                command.getDescripcion(),
                command.getFecha()
        );

        emit().onResponse(new ResponseEvents(recorrido.getUncommittedChanges()));
    }
}
