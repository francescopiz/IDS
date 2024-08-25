package com.unicam.IDS.models.ruoli;

import com.unicam.IDS.models.Comune;

/**
 * Rappresenta il ruolo che un utente ha all'interno di uno specifico comune
 */
public record RuoloInComune(Comune comune, Ruolo ruolo) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RuoloInComune ruoloComune)) return false;
        return comune.equals(ruoloComune.comune) && this.ruolo == ruoloComune.ruolo;
    }

    @Override
    public int hashCode() {
        return comune.hashCode() + ruolo.hashCode();
    }

    @Override
    public String toString() {
        return "RuoloComune{" +
                "comune=" + comune +
                ", ruolo=" + ruolo +
                '}';
    }

}
