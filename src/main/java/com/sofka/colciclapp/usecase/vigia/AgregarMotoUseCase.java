package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.vigia.Vigia;
import com.sofka.colciclapp.domain.vigia.commands.AgregarMotoCommand;

public class AgregarMotoUseCase extends UseCase<RequestCommand<AgregarMotoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMotoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var vigia = Vigia.from(command.getVigiaId(), retrieveEvents());

        if(vigia.motos().size() == 5){
            throw new BusinessException(command.getVigiaId().value(), "No puede tener más bicicletas");
        }

        vigia.agregarMoto(
                command.getEntityId(),
                command.getTipo(),
                command.getMarca(),
                command.getColor()
        );

        emit().onResponse(new ResponseEvents(vigia.getUncommittedChanges()));
    }
}
