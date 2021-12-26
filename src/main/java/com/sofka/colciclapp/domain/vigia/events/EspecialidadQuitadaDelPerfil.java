package com.sofka.colciclapp.domain.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.vigia.values.Especialidad;

public class EspecialidadQuitadaDelPerfil extends DomainEvent {
    private final Especialidad especialidad;

    public EspecialidadQuitadaDelPerfil(Especialidad especialidad) {
        super("sofka.vigia.especialidadQuitadaDelPerfil");
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
