package com.unicam.IDS.controllers;

import com.unicam.IDS.models.ruoli.RuoloInComune;
import com.unicam.IDS.models.ruoli.Utente;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.ruoli.Ruolo;

import java.util.*;

/**
 * Si occupa della gestione dei ruoli implementando il singleton pattern
 */
public class GestoreRuoli {

    private final Map<Utente, Set<RuoloInComune>> mappaUtenteRuoliComune; // Mappa che associa utenti a insiemi di ruoli in comuni

    public GestoreRuoli() {
        mappaUtenteRuoliComune = new HashMap<>(); // Inizializza la mappa
    }

    /**
     * Restituisce i comuni in cui un utente ricopre un certo ruolo
     *
     * @param utente Utente per cui si vogliono ottenere i comuni
     * @param ruolo  Ruolo da ricercare
     * @return Set di comuni in cui l'utente ricopre il ruolo specificato
     */
    public Set<Comune> getComuniConRuoloUtente(Utente utente, Ruolo ruolo) {
        if (utente == null || ruolo == null) {
            throw new IllegalArgumentException("Ruolo o utente nulli non ammessi");
        }
        Set<Comune> comuniConRuolo = new HashSet<>();
        mappaUtenteRuoliComune.getOrDefault(utente, new HashSet<>()).stream().filter(ruoloComune ->
                        ruoloComune != null && ruoloComune.ruolo().equals(ruolo)).
                map(RuoloInComune::comune).forEach(comuniConRuolo::add);
        return comuniConRuolo;
    }

    /**
     * Associa un ruolo in un comune ad un certo utente
     *
     * @param utente      Utente a cui associare il ruolo
     * @param ruoloComune RuoloInComune da associare
     * @return true se l'associazione è avvenuta con
     * successo, false altrimenti
     */
    public boolean conferisciRuoloComuneAUtente(Utente utente, RuoloInComune ruoloComune) {
        return mappaUtenteRuoliComune.computeIfAbsent(utente, k -> new HashSet<>()).add(ruoloComune);
    }


    @Override
    public String toString() {
        return "GestoreRuoli{" + "mappaUtenteRuoliComune=" + mappaUtenteRuoliComune.size() + '}';
    }
}
