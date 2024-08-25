package com.unicam.IDS.tempo;

import java.time.LocalDateTime;

/**
 * Observer per il tempo.
 */
public interface ObserverTime {

    /**
     * Aggiorna il tempo.
     * @param dataOra data e ora correnti.
     */
    void update(LocalDateTime dataOra);
}
