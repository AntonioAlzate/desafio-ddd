package com.sofka.colciclapp.ciclista;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.ciclista.events.*;
import com.sofka.colciclapp.ciclista.values.*;
import com.sofka.colciclapp.genericos.ColorVehiculo;
import com.sofka.colciclapp.genericos.EstadoEntidad;
import com.sofka.colciclapp.genericos.Fecha;
import com.sofka.colciclapp.genericos.PersonaId;
import com.sofka.colciclapp.recorrido.Ruta;
import com.sofka.colciclapp.recorrido.Servicio;
import com.sofka.colciclapp.recorrido.values.RecorridoId;
import com.sofka.colciclapp.recorrido.values.ServicioId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Ciclista extends AggregateEvent<CiclistaId> {

    protected PersonaId personaId;
    protected Set<RecorridoId> recorridoIds;
    protected Set<Bicicleta> bicicletas;
    protected Cuenta cuenta;
    protected EstadoEntidad estado;

    public Ciclista(CiclistaId entityId,PersonaId personaId, BicicletaId bicicletaId, TipoBicicleta tipoBicicleta, MarcaBicicleta marca, ColorVehiculo color) {
        super(entityId);
        Objects.requireNonNull(personaId);
        Objects.requireNonNull(bicicletaId);
        Objects.requireNonNull(tipoBicicleta);
        Objects.requireNonNull(marca);
        Objects.requireNonNull(color);
        appendChange(new CiclistaCreado(personaId,bicicletaId,tipoBicicleta,marca,color)).apply();
    }

        private Ciclista(CiclistaId ciclistaId) {
        super(ciclistaId);
        subscribe(new CiclistaChange(this));
    }

    public static Ciclista from(CiclistaId ciclistaId, List<DomainEvent> events) {
        var ciclista = new Ciclista(ciclistaId);
        events.forEach(ciclista::applyEvent);
        return ciclista;
    }

    public void generarRecorrido(RecorridoId recorridoId, Ruta ruta, Fecha fecha){
        Objects.requireNonNull(recorridoId);
        Objects.requireNonNull(ruta);
        Objects.requireNonNull(fecha);
        appendChange(new RecorridoGenerado(recorridoId, ruta, fecha)).apply();
    }

    public void agregarBicicleta(BicicletaId bicicletaId, TipoBicicleta tipoBicicleta, MarcaBicicleta marca, ColorVehiculo color){
        Objects.requireNonNull(bicicletaId);
        Objects.requireNonNull(tipoBicicleta);
        Objects.requireNonNull(marca);
        Objects.requireNonNull(color);
        appendChange(new BicicletaAgregada(bicicletaId,tipoBicicleta,marca,color)).apply();
    }

    public void actualizarMarcaDeUnaBicicleta(BicicletaId bicicletaId, MarcaBicicleta marca){
        Objects.requireNonNull(bicicletaId);
        Objects.requireNonNull(marca);
        appendChange(new MarcaBicicletaActualizada(bicicletaId, marca)).apply();
    }

    public void actualizarTipoDeUnaBicicleta(BicicletaId bicicletaId, TipoBicicleta tipo){
        Objects.requireNonNull(bicicletaId);
        Objects.requireNonNull(tipo);
        appendChange(new TipoBicicletaActualizada(bicicletaId, tipo)).apply();
    }

    public void actualizarColorDeUnaBicicleta(BicicletaId bicicletaId, ColorVehiculo color){
        Objects.requireNonNull(bicicletaId);
        Objects.requireNonNull(color);
        appendChange(new ColorBicicletaActualizada(bicicletaId, color)).apply();
    }

    public void agregarUnFavoritoALaCuenta(Favorito favorito){
        Objects.requireNonNull(favorito);
        appendChange(new FavoritoAgregadoALaCuenta(favorito)).apply();
    }

    public void quitarUnFavoritoDeLaCuenta(Favorito favorito){
        Objects.requireNonNull(favorito);
        appendChange(new FavoritoQuitadoDeLaCuenta(favorito)).apply();
    }

    public void actualizarEstadoCiclista(EstadoEntidad estado){
        Objects.requireNonNull(estado);
        appendChange(new EstadoCiclistaActualizado(estado)).apply();
    }

    protected Optional<Bicicleta> obtenerBicicletaPorId(BicicletaId bicicletaId) {
        return bicicletas
                .stream()
                .filter(bicicleta -> bicicleta.identity().equals(bicicletaId))
                .findFirst();
    }

    public PersonaId personaId() {
        return personaId;
    }

    public Set<RecorridoId> recorridoIds() {
        return recorridoIds;
    }

    public Set<Bicicleta> bicicletas() {
        return bicicletas;
    }

    public Cuenta cuenta() {
        return cuenta;
    }

    public EstadoEntidad estado() {
        return estado;
    }
}
