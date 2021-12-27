package com.sofka.colciclapp.usecase.recorrido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.recorrido.Recorrido;
import com.sofka.colciclapp.domain.recorrido.commands.AsociarVigiaCommand;

public class AsociarVigiaUseCase extends UseCase<RequestCommand<AsociarVigiaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarVigiaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var recorrido = Recorrido.from(command.getRecorridoId(), retrieveEvents());

        recorrido.asociarVigia(command.getVigiaId());

        emit().onResponse(new ResponseEvents(recorrido.getUncommittedChanges()));
    }
}
