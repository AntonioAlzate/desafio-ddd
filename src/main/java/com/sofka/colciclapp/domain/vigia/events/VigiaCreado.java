package com.sofka.colciclapp.domain.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.PersonaId;
import com.sofka.colciclapp.domain.vigia.values.Especialidad;
import com.sofka.colciclapp.domain.vigia.values.PerfilId;

import java.util.Set;

public class VigiaCreado extends DomainEvent {


    private final PerfilId perfilId;
    private final Descripcion descripcion;
    private final Set<Especialidad> especialidades;
    private final PersonaId personaId;

    public VigiaCreado(PersonaId personaId, PerfilId perfilId, Descripcion descripcion, Set<Especialidad> especialidades) {
        super("sofka.vigia.vigiacreado");

        this.perfilId = perfilId;
        this.descripcion = descripcion;
        this.especialidades = especialidades;
        this.personaId = personaId;
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
