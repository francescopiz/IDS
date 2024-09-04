package com.unicam.IDS.tempo;

import java.time.LocalDateTime;

/**
 * Observer per il tempo.
 */
public interface ObserverTime {

    /**
     * Aggiorna il tempo.
     *
     * @param now giorno e orario corrente.
     */
    void update(LocalDateTime now);
}
