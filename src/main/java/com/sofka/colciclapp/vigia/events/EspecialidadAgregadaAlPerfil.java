package com.sofka.colciclapp.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.vigia.values.Especialidad;

public class EspecialidadAgregadaAlPerfil extends DomainEvent {
    private final Especialidad especialidad;

    public EspecialidadAgregadaAlPerfil(Especialidad especialidad) {
        super("sofka.vigia.especialidadagregadaalperfil");
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
