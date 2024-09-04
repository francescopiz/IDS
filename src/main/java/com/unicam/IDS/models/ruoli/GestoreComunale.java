package com.unicam.IDS.models.ruoli;

import com.unicam.IDS.models.AnalizzatorePosizione.AnalizzatorePosizione;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.Posizione;
import com.unicam.IDS.models.richieste.GestoreRichieste;
import com.unicam.IDS.osm.ServizioOSM;
import com.unicam.IDS.repositorys.ComuniRepository;


public class GestoreComunale {
    private final Comune comune;
    public final ComuniRepository comuniRepository;
    public final AnalizzatorePosizione analizzatorePosizione;

    public GestoreComunale(ComuniRepository comuniRepository, GestoreApprovabili gestoreApprovabili, GestoreRichieste gestoreRichieste, GestoreContest gestoreContest, Comune comune) {
        this.comuniRepository = comuniRepository;
        this.comune = comune;
        this.analizzatorePosizione = new AnalizzatorePosizione(new ServizioOSM());
    }

    public boolean isPosizioneInComune(Posizione posizione) {
        return this.analizzatorePosizione.isPosizioneInComune(posizione, comune);
    }
    public Comune getComune() {
        return comune;
    }
}