package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.vigia.Vigia;
import com.sofka.colciclapp.domain.vigia.commands.CrearVigiaCommand;

public class CrearVigiaUseCase extends UseCase<RequestCommand<CrearVigiaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVigiaCommand> requestCommand) {
        var command = requestCommand.getCommand();

        var vigia = new Vigia(
            command.getEntityId(),
            command.getPersonaId(),
            command.getPerfilId(),
            command.getDescripcion(),
            command.getEspecialidad()
        );

        emit().onResponse(new ResponseEvents(vigia.getUncommittedChanges()));
    }
}
