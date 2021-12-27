package com.sofka.colciclapp.usecase.ciclista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.colciclapp.domain.ciclista.Ciclista;
import com.sofka.colciclapp.domain.ciclista.commands.QuitarUnFavoritoDeLaCuentaCommand;

public class QuitarUnFavoritoDeLaCuentaUseCase extends UseCase<RequestCommand<QuitarUnFavoritoDeLaCuentaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<QuitarUnFavoritoDeLaCuentaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var ciclista = Ciclista.from(command.getCiclistaId(), retrieveEvents());

        ciclista.quitarUnFavoritoDeLaCuenta(command.getFavorito());

        emit().onResponse(new ResponseEvents(ciclista.getUncommittedChanges()));
    }
}
