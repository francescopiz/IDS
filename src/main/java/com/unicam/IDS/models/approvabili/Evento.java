package com.unicam.IDS.models.approvabili;

import com.unicam.IDS.models.ruoli.Utente;
import com.unicam.IDS.tempo.ObserverTime;
import com.unicam.IDS.tempo.Time;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Classe che rappresenta un Evento, estende POI e implementa ObserverTime.
 */
public class Evento extends POI implements ObserverTime {

    private Set<Utente> iscritti;
    private Time time;

    /**
     * Costruttore per creare un Evento con una lista di contenuti e senza iscritti.
     *
     * @param nome            il nome dell'evento
     * @param descrizione     la descrizione dell'evento
     * @param posizione       la posizione dell'evento
     * @param time            il tempo dell'evento
     * @param elencoContenuti la lista dei contenuti dell'evento
     */
    public Evento(String nome, String descrizione, Posizione posizione, Time time, List<Contenuto> elencoContenuti) {
        super(nome, descrizione, posizione, elencoContenuti);
        this.time = time;
        this.iscritti = new HashSet<>();
    }

    /**
     * Costruttore per creare un Evento con una lista di contenuti e iscritti.
     *
     * @param nome            il nome dell'evento
     * @param descrizione     la descrizione dell'evento
     * @param posizione       la posizione dell'evento
     * @param time            il tempo dell'evento
     * @param elencoContenuti la lista dei contenuti dell'evento
     * @param iscritti        il set degli iscritti all'evento
     */
    public Evento(String nome, String descrizione, Posizione posizione, Time time, List<Contenuto> elencoContenuti, Set<Utente> iscritti) {
        super(nome, descrizione, posizione, elencoContenuti);
        this.time = time;
        this.iscritti = iscritti;
    }

    /**
     * Metodo chiamato per aggiornare l'evento con una nuova data e ora.
     *
     * @param dataOra la nuova data e ora
     */
    @Override
    public void update(LocalDateTime dataOra) {
        // Implementazione del metodo di aggiornamento
    }

    /**
     * Aggiunge un utente al set degli iscritti.
     *
     * @param utente l'utente da aggiungere
     * @return true se l'utente è stato aggiunto, false altrimenti
     */
    public boolean iscrizione(Utente utente) {
        return iscritti.add(utente);
    }

    /**
     * Rimuove un utente dal set degli iscritti.
     *
     * @param utente l'utente da rimuovere
     * @return true se l'utente è stato rimosso, false altrimenti
     */
    public boolean disiscrizione(Utente utente) {
        return iscritti.remove(utente);
    }

    /**
     * Aggiunge una collezione di utenti al set degli iscritti.
     *
     * @param utente la collezione di utenti da aggiungere
     * @return true se gli utenti sono stati aggiunti, false altrimenti
     */
    public boolean iscriviAll(Collection<Utente> utente) {
        return iscritti.addAll(utente);
    }

    /**
     * Restituisce una rappresentazione in stringa dell'evento.
     *
     * @return una stringa che rappresenta l'evento
     */
    @Override
    public String toString() {
        return "Evento{" +
                "iscritti=" + iscritti +
                ", time=" + time +
                '}';
    }
}