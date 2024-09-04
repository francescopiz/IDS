package com.unicam.IDS.dtos;

import com.unicam.IDS.models.ruoli.Utente;

import java.util.List;

public record ContestDto(String nome, String descrizione, int idAnimatore, List<Utente> utentiAbilitati) {
}
