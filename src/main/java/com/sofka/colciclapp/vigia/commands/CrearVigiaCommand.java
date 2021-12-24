package com.sofka.colciclapp.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.genericos.Descripcion;
import com.sofka.colciclapp.genericos.PersonaId;
import com.sofka.colciclapp.vigia.values.Especialidad;
import com.sofka.colciclapp.vigia.values.PerfilId;
import com.sofka.colciclapp.vigia.values.VigiaId;

import java.util.Set;

public class CrearVigiaCommand extends Command {

    private final VigiaId entityId;
    private final PersonaId personaId;
    private final PerfilId perfilId;
    private final Descripcion descripcion;
    private final Set<Especialidad> especialidades;

    public CrearVigiaCommand(VigiaId entityId, PersonaId personaId, PerfilId perfilId, Descripcion descripcion, Set<Especialidad> especialidades) {

        this.entityId = entityId;
        this.personaId = personaId;
        this.perfilId = perfilId;
        this.descripcion = descripcion;
        this.especialidades = especialidades;
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

    public Set<Especialidad> getEspecialidades() {
        return especialidades;
    }
}
