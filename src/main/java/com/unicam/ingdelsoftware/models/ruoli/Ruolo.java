package com.unicam.ingdelsoftware.models.ruoli;

/**
 * Enumerazione che rappresenta i ruoli che un utente può avere all'interno della piattaforma
 */
public enum Ruolo {
    CONTRIBUTOR("CONTRIBUTOR"),
    CONTRIBUTOR_AUTORIZZATO("CONTRIBUTOR_AUTORIZZATO"),
    TURISTA("TURISTA"),
    TURISTA_AUTENTICATO("TURISTA_AUTENTICATO"),
    ANIMATORE("ANIMATORE"),
    CURATORE("CURATORE"),
    GESTORE_PIATTAFORMA("GESTORE_PIATTAFORMA"),
    GESTORE_COMUNE("GESTORE_COMUNE");


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