package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.vigia.Vigia;
import com.sofka.colciclapp.domain.vigia.commands.QuitarUnaMotoCommand;

public class QuitarMotoUseCase extends UseCase<RequestCommand<QuitarUnaMotoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<QuitarUnaMotoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var vigia = Vigia.from(command.getVigiaId(), retrieveEvents());

        vigia.quitarUnaMoto(command.getMotoId());

        emit().onResponse(new ResponseEvents(vigia.getUncommittedChanges()));
    }
}
