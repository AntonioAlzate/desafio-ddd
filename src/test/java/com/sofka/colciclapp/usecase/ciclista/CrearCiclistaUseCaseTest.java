package com.sofka.colciclapp.usecase.ciclista;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.colciclapp.domain.ciclista.commands.CrearCiclistaCommand;
import com.sofka.colciclapp.domain.ciclista.events.CiclistaCreado;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.ciclista.values.MarcaBicicleta;
import com.sofka.colciclapp.domain.ciclista.values.TipoBicicleta;
import com.sofka.colciclapp.domain.genericos.Color;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearCiclistaUseCaseTest {

    @Test
    void crearCiclista() {

        // arrange
        CiclistaId ciclistaId = CiclistaId.of("xxxx");
        PersonaId personaId = PersonaId.of("yyyy");
        BicicletaId bicicletaId = BicicletaId.of("zzzz");
        TipoBicicleta tipoBicicleta = TipoBicicleta.PISTA;
        MarcaBicicleta marca = new MarcaBicicleta("GW");
        ColorVehiculo color = new ColorVehiculo(Color.NEGRO);
        var command = new CrearCiclistaCommand(ciclistaId, personaId, bicicletaId, tipoBicicleta, marca, color);
        var usecase = new CrearCiclistaUseCase();

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        // asserts
        CiclistaCreado event = (CiclistaCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getPersonaId().value());
        Assertions.assertEquals("zzzz", event.getBicicletaId().value());
    }

}