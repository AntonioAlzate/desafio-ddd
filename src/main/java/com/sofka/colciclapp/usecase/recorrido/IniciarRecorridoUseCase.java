package com.sofka.colciclapp.usecase.recorrido;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.recorrido.Recorrido;
import com.sofka.colciclapp.domain.recorrido.commands.IniciarRecorridoCommand;

public class IniciarRecorridoUseCase extends UseCase<RequestCommand<IniciarRecorridoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<IniciarRecorridoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var recorrido = Recorrido
                .from(command.getRecorridoId(), retrieveEvents());

        if(recorrido.iniciado().value().equals(Boolean.TRUE)){
            throw new BusinessException(command.getRecorridoId().value()
                    ,"El recorrido ya se ha iniciado anteriormente");
        }

        recorrido.iniciarRecorrido();

        emit().onResponse(new ResponseEvents(recorrido.getUncommittedChanges()));
    }
}
