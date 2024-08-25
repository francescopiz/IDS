package com.unicam.IDS.tempo;

import java.time.LocalDateTime;
import java.util.function.Function;

/**
 * La classe Periodo rappresenta un periodo di tempo regolato da una funzione di aggiustamento.
 * Implementa l'interfaccia Time.
 */
public class Periodo implements Time {
    private Function<LocalDateTime, OrarioDiInizioFine> timeAdjuster;

    /**
     * Costruttore che inizializza la funzione di aggiustamento.
     *
     * @param timeAdjuster la funzione di aggiustamento che calcola l'orario di inizio e fine.
     */
    public Periodo(Function<LocalDateTime, OrarioDiInizioFine> timeAdjuster) {
        this.timeAdjuster = timeAdjuster;
    }

    /**
     * Costruttore di default.
     */
    public Periodo() {
    }

    /**
     * Controlla se l'time passato come parametro è compreso tra gli orari di inizio e fine calcolati dalla funzione di aggiustamento.
     *
     * @param time da controllare.
     * @return true se time è compreso tra gli orari di inizio e fine, false altrimenti.
     */
    @Override
    public boolean attivato(LocalDateTime time) {
        return timeAdjuster.apply(time).contiene(time);
    }

    /**
     * Restituisce l'orario di inizio e fine successivo a quello passato come parametro, calcolato dalla funzione di aggiustamento.
     *
     * @param ora l'orario da cui partire per trovare il prossimo orario di inizio e fine.
     * @return l'orario di inizio e fine successivo a quello passato come parametro.
     */
    @Override
    public OrarioDiInizioFine getNextTime(LocalDateTime ora) {
        return timeAdjuster.apply(ora);
    }
}