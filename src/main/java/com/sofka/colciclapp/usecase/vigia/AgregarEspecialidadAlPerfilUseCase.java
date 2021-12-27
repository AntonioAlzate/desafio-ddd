package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.vigia.Vigia;
import com.sofka.colciclapp.domain.vigia.commands.AgregarEspecialidadAlPerfilCommand;

public class AgregarEspecialidadAlPerfilUseCase extends UseCase<RequestCommand<AgregarEspecialidadAlPerfilCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEspecialidadAlPerfilCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var vigia = Vigia.from(command.getVigiaId(), retrieveEvents());

        vigia.agregarEspecialidadAlPerfil(
                command.getEspecialidad()
        );

        emit().onResponse(new ResponseEvents(vigia.getUncommittedChanges()));
    }
}
