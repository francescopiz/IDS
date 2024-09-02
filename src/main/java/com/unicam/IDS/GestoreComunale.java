package com.unicam.IDS;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.GestoreApprovabili;
import com.unicam.IDS.models.approvabili.GestoreComuni;
import com.unicam.IDS.models.richieste.GestoreRichieste;

public class GestoreComunale {
    private final GestoreApprovabili gestoreApprovabili;
    private final GestoreRichieste gestoreRichieste;
    private final GestoreComuni gestoreComuni;
    private final Comune comune;
    //TODO aggiungi analizzatorePosizione (controlla se una posizione è nel comune)

    public GestoreComunale(GestoreApprovabili gestoreApprovabili, GestoreRichieste gestoreRichieste, GestoreComuni gestoreComuni, Comune comune) {
        this.gestoreApprovabili = gestoreApprovabili;
        this.gestoreRichieste = gestoreRichieste;
        this.gestoreComuni = gestoreComuni;
        this.comune = comune;
    }

    public GestoreComuni getGestoreComuni() {
        return gestoreComuni;
    }

    public GestoreApprovabili getGestoreApprovabili() {
        return gestoreApprovabili;
    }

    public GestoreRichieste getGestoreRichieste() {
        return gestoreRichieste;
    }
}