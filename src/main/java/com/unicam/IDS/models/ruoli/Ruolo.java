package com.unicam.IDS.models.ruoli;

/**
 * Enumerazione che rappresenta i ruoli che un utente può avere all'interno della piattaforma
 */
public enum Ruolo {
    TURISTA("TURISTA"),
    TURISTA_AUTENTICATO("TURISTA_AUTENTICATO"),
    CONTRIBUTOR("CONTRIBUTOR"),
    CONTRIBUTOR_AUTORIZZATO("CONTRIBUTOR_AUTORIZZATO"),
    ANIMATORE("ANIMATORE"),
    CURATORE("CURATORE"),
    GESTORE_COMUNALE("GESTORE_COMUNALE"),
    GESTORE_PIATTAFORMA("GESTORE_PIATTAFORMA");


    public final String ruolo;

    Ruolo(String ruolo) {
        this.ruolo = ruolo;
    }


    public static Ruolo getRuolo(String ruolo) {
        for (Ruolo r : Ruolo.values()) {
            if (r.ruolo.equalsIgnoreCase(ruolo)) return r;
        }
        return null;
    }

}