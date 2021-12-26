package com.sofka.colciclapp.domain.vigia;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.vigia.values.Especialidad;
import com.sofka.colciclapp.domain.vigia.values.PerfilId;

import java.util.Objects;
import java.util.Set;

public class Perfil extends Entity<PerfilId> {

    private Descripcion descripcion;
    private Set<Especialidad> especialidades;

    public Perfil(PerfilId entityId, Descripcion descripcion, Set<Especialidad> especialidades) {
        super(entityId);
        this.descripcion = descripcion;
        this.especialidades = especialidades;
    }

    public void agregarEspecialidad(Especialidad especialidad) {
        if (especialidades.contains(especialidad)) {
            throw new IllegalArgumentException("La especialidad ya se encuentra agregada");
        }
        this.especialidades.add(especialidad);
    }

    public void quitarEspecialidad(Especialidad especialidad) {
        if (!especialidades.contains(especialidad)) {
            throw new IllegalArgumentException("No se puede eliminar una especialidad que no se encuentra agregada");
        }
        this.especialidades.remove(especialidad);
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Set<Especialidad> especialidades() {
        return especialidades;
    }
}
