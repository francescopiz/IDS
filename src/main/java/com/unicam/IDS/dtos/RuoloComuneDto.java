package com.unicam.IDS.dtos;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.ruoli.Ruolo;

public record RuoloComuneDto(Comune comune, Ruolo ruolo) {
}