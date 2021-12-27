package com.sofka.colciclapp.usecase.ciclista;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.ciclista.Ciclista;
import com.sofka.colciclapp.domain.ciclista.commands.AgregarBicicletaCommand;

public class AgregarBicicletaUseCase extends UseCase<RequestCommand<AgregarBicicletaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarBicicletaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var ciclista = Ciclista.from(command.getCiclistaId(), retrieveEvents());

        if(ciclista.bicicletas().size() == 5){
            throw new BusinessException(command.getCiclistaId().value(), "No puede tener más bicicletas");
        }

        ciclista.agregarBicicleta(
                command.getBicicletaId(),
                command.getTipoBicicleta(),
                command.getMarca(),
                command.getColor()
        );

        emit().onResponse(new ResponseEvents(ciclista.getUncommittedChanges()));
    }
}
