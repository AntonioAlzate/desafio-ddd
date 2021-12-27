package com.sofka.colciclapp.usecase.vigia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import com.sofka.colciclapp.domain.vigia.commands.CrearVigiaCommand;
import com.sofka.colciclapp.domain.vigia.events.VigiaCreado;
import com.sofka.colciclapp.domain.vigia.values.Especialidad;
import com.sofka.colciclapp.domain.vigia.values.PerfilId;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearVigiaUseCaseTest {

    @Test
    void crearVigia() {
        VigiaId vigiaId = VigiaId.of("xxxx");
        PersonaId personaId = PersonaId.of("aaaa");
        PerfilId perfilId = PerfilId.of("bbbb");
        Descripcion descripcion = new Descripcion("Mecanico de bicicletas con basta experiencia");
        Especialidad especialidad = Especialidad.MECANICA;
        var command = new CrearVigiaCommand(vigiaId, personaId, perfilId, descripcion, especialidad);
        var usecase = new CrearVigiaUseCase();

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        // asserts
        VigiaCreado event = (VigiaCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getPersonaId().value());
        Assertions.assertEquals("bbbb", event.getPerfilId().value());
        Assertions.assertEquals("Mecanico de bicicletas con basta experiencia", event.getDescripcion().value());
        Assertions.assertEquals(Especialidad.MECANICA, event.getEspecialidad());

    }

}