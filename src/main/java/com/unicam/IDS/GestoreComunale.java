package com.unicam.IDS;
import com.unicam.IDS.GestoreContest;
import com.unicam.IDS.models.AnalizzatorePosizione.AnalizzatorePosizione;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.GestoreApprovabili;
import com.unicam.IDS.models.approvabili.Posizione;
import com.unicam.IDS.models.richieste.GestoreRichieste;
import com.unicam.IDS.osm.ServizioOSM;
import com.unicam.IDS.repositorys.ComuniRepository;

public class GestoreComunale {
    private final GestoreApprovabili gestoreApprovabili;
    private final GestoreContest gestoreContest;
    private final GestoreRichieste gestoreRichieste;
    private final Comune comune;
    public final ComuniRepository comuniRepository;
    public final AnalizzatorePosizione analizzatorePosizione;

    public GestoreComunale(ComuniRepository comuniRepository, GestoreApprovabili gestoreApprovabili, GestoreRichieste gestoreRichieste, GestoreContest gestoreContest, Comune comune) {
        this.gestoreApprovabili = gestoreApprovabili;
        this.comuniRepository = comuniRepository;
        this.gestoreRichieste = gestoreRichieste;
        this.gestoreContest = gestoreContest;
        this.comune = comune;
        this.analizzatorePosizione= new AnalizzatorePosizione(new ServizioOSM());
    }

    public boolean isPosizioneInComune(Posizione posizione) {
        return this.analizzatorePosizione.isPosizioneInComune(posizione, comune);
    }

    public Comune getComune() {
        return comune;
    }
}