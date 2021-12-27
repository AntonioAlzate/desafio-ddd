package com.sofka.colciclapp.usecase.ciclista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.ciclista.Ciclista;
import com.sofka.colciclapp.domain.ciclista.commands.AgregarUnFavoritoALaCuentaCommand;

public class AgregarUnFavoritoALaCuentaUseCase extends UseCase<RequestCommand<AgregarUnFavoritoALaCuentaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarUnFavoritoALaCuentaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var ciclista = Ciclista.from(command.getCiclistaId(), retrieveEvents());

        ciclista.agregarUnFavoritoALaCuenta(command.getFavorito());

        emit().onResponse(new ResponseEvents(ciclista.getUncommittedChanges()));
    }
}
