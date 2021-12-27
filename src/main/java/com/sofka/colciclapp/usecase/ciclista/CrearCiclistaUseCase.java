package com.sofka.colciclapp.usecase.ciclista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.ciclista.Ciclista;
import com.sofka.colciclapp.domain.ciclista.commands.CrearCiclistaCommand;

public class CrearCiclistaUseCase extends UseCase<RequestCommand<CrearCiclistaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCiclistaCommand> requestCommand) {
        var command = requestCommand.getCommand();

        var ciclista = new Ciclista(
                command.getEntityId(),
                command.getPersonaId(),
                command.getBicicletaId(),
                command.getTipoBicicleta(),
                command.getMarca(),
                command.getColor()

        );

        emit().onResponse(new ResponseEvents(ciclista.getUncommittedChanges()));
    }
}
