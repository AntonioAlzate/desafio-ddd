package com.sofka.colciclapp.usecase.services;

import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

public interface EnviarNotificacionService {
    boolean enviar(String correo, String descripcion, RecorridoId recorridoId);
}
