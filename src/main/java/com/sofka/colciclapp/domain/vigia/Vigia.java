package com.sofka.colciclapp.domain.vigia;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.*;
import com.sofka.colciclapp.domain.vigia.events.*;
import com.sofka.colciclapp.domain.vigia.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Vigia extends AggregateEvent<VigiaId> {

    protected PersonaId personaId;
    protected Set<Moto> motos;
    protected Perfil perfil;
    protected Set<Calificacion> calificaciones;
    protected EstadoEntidad estado;

    public Vigia(VigiaId entityId, PersonaId personaId, PerfilId perfilId, Descripcion descripcion, Especialidad especialidad) {
        super(entityId);
        appendChange(new VigiaCreado(personaId, perfilId, descripcion, especialidad)).apply();
    }

    private Vigia(VigiaId vigiaId) {
        super(vigiaId);
        subscribe(new VigiaChange(this));
    }

    public static Vigia from(VigiaId vigiaId, List<DomainEvent> events) {
        var vigia = new Vigia(vigiaId);
        events.forEach(vigia::applyEvent);
        return vigia;
    }

    public void agregarCalificacion(CalificacionId entityId, Puntuacion puntuacion) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(puntuacion);
        appendChange(new CalificacionAgregada(entityId, puntuacion)).apply();
    }

    public void actualizarMarcaDeUnaMoto(MotoId motoId, MarcaMoto marca) {
        Objects.requireNonNull(motoId);
        Objects.requireNonNull(marca);
        appendChange(new MarcaDeMotoActualizada(motoId, marca)).apply();
    }

    public void actualizarColorDeUnaMoto(MotoId motoId, Color color) {
        Objects.requireNonNull(motoId);
        Objects.requireNonNull(color);
        appendChange(new ColorDeMotoActualizada(motoId, color)).apply();
    }

    public void actualizarTipoDeUnaMoto(MotoId motoId, TipoMoto tipo) {
        Objects.requireNonNull(motoId);
        Objects.requireNonNull(tipo);
        appendChange(new TipoDeMotoActualizada(motoId, tipo)).apply();
    }

    public void agregarMoto(MotoId entityId, TipoMoto tipo, MarcaMoto marca, ColorVehiculo color) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(marca);
        Objects.requireNonNull(color);
        appendChange(new MotoAgregada(entityId, tipo, marca, color)).apply();
    }

    public void quitarUnaMoto(MotoId motoId) {
        Objects.requireNonNull(motoId);
        appendChange(new MotoQuitada(motoId)).apply();
    }

    public void agregarEspecialidadAlPerfil(Especialidad especialidad) {
        Objects.requireNonNull(especialidad);
        appendChange(new EspecialidadAgregadaAlPerfil(especialidad)).apply();
    }

    public void quitarEspecialidadAlPerfil(Especialidad especialidad) {
        Objects.requireNonNull(especialidad);
        appendChange(new EspecialidadQuitadaDelPerfil(especialidad)).apply();
    }

    public void actualizarDescripcionDelPerfil(Descripcion descripcion) {
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionPerfilActualizada(descripcion)).apply();
    }

    public void actualizarPuntuacionDeUnaCalificacion(CalificacionId entityId, Puntuacion puntuacion) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(puntuacion);
        appendChange(new PuntuacionDeCalificacionActualizada(entityId, puntuacion)).apply();
    }

    protected Optional<Moto> obtenerMotoPorId(MotoId motoId) {
        return motos
                .stream()
                .filter(moto -> moto.identity().equals(motoId))
                .findFirst();
    }

    protected Optional<Calificacion> obtenerCalificacionPorId(CalificacionId calificacionId) {
        return calificaciones
                .stream()
                .filter(calificacion -> calificacion.identity().equals(calificacionId))
                .findFirst();
    }

    public PersonaId personaId() {
        return personaId;
    }

    public Set<Moto> motos() {
        return motos;
    }

    public Perfil perfil() {
        return perfil;
    }

    public Set<Calificacion> calificaciones() {
        return calificaciones;
    }

    public EstadoEntidad estado() {
        return estado;
    }
}
