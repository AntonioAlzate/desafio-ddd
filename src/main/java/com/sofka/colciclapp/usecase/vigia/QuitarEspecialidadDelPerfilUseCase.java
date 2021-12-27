package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.vigia.Vigia;
import com.sofka.colciclapp.domain.vigia.commands.QuitarEspecialidadAlPerfilCommand;

public class QuitarEspecialidadDelPerfilUseCase extends UseCase<RequestCommand<QuitarEspecialidadAlPerfilCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<QuitarEspecialidadAlPerfilCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var vigia = Vigia.from(command.getVigiaId(), retrieveEvents());

        vigia.quitarEspecialidadAlPerfil(command.getEspecialidad());

        emit().onResponse(new ResponseEvents(vigia.getUncommittedChanges()));
    }
}
