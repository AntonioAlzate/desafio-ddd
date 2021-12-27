package com.sofka.colciclapp.domain.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import com.sofka.colciclapp.domain.vigia.values.Especialidad;
import com.sofka.colciclapp.domain.vigia.values.PerfilId;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

import java.util.Set;

public class CrearVigiaCommand extends Command {

    private final VigiaId entityId;
    private final PersonaId personaId;
    private final PerfilId perfilId;
    private final Descripcion descripcion;
    private final Especialidad especialidad;

    public CrearVigiaCommand(VigiaId entityId, PersonaId personaId, PerfilId perfilId, Descripcion descripcion, Especialidad especialidad) {

        this.entityId = entityId;
        this.personaId = personaId;
        this.perfilId = perfilId;
        this.descripcion = descripcion;
        this.especialidad = especialidad;
    }

    public VigiaId getEntityId() {
        return entityId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
