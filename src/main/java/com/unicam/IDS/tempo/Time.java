package com.unicam.IDS.tempo;

import java.time.LocalDateTime;

/**
 * Questa interfaccia rappresenta il tempo in cui è attivo un contenuto.
 */
public interface Time {

    /**
     * Controlla se l'orario passato come parametro è compreso tra gli orari di inizio e fine.
     *
     * @param time l'orario da controllare.
     * @return true se l'orario passato come parametro è compreso tra gli orari di inizio e fine, false altrimenti.
     */
    boolean attivato(LocalDateTime time);

    /**
     * Restituisce l'orario di inizio e fine successivo a quello passato come parametro.
     *
     * @param now l'orario da cui partire per trovare il prossimo orario di inizio e fine.
     * @return l'orario di inizio e fine successivo a quello passato come parametro.
     */
    OrarioDiInizioFine getNextTime(LocalDateTime now);

}