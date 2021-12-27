package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.vigia.Vigia;
import com.sofka.colciclapp.domain.vigia.commands.AgregarCalificacionCommand;

public class AgregarCalificacionUseCase extends UseCase<RequestCommand<AgregarCalificacionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCalificacionCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var vigia = Vigia.from(command.getVigiaId(), retrieveEvents());

        vigia.agregarCalificacion(
                command.getEntityId(),
                command.getPuntuacion()
        );

        emit().onResponse(new ResponseEvents(vigia.getUncommittedChanges()));
    }
}
