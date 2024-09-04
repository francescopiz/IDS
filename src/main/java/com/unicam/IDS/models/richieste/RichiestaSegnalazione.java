package com.unicam.IDS.models.richieste;

import com.unicam.IDS.models.approvabili.Approvabile;
import jakarta.persistence.Entity;

@Entity
public class RichiestaSegnalazione extends Richiesta {

    private String descrizione;

    public RichiestaSegnalazione(Approvabile approvabile, String descrizione) {
        super(approvabile);
        this.descrizione = descrizione;
    }

    public RichiestaSegnalazione() {
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public void esegui(boolean approva) {
        this.getApprovabile().setVisibile(!approva);
    }

}
