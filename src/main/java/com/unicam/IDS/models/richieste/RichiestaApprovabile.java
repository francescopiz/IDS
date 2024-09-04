package com.unicam.IDS.models.richieste;

import com.unicam.IDS.models.approvabili.Approvabile;
import jakarta.persistence.Entity;

/**
 * Questa classe rappresenta una richiesta di approvazione di un oggetto approvabile.
 */
@Entity
public class RichiestaApprovabile extends Richiesta {

    public RichiestaApprovabile(Approvabile approvabile) {
        super(approvabile);
    }

    public RichiestaApprovabile() {
    }

    @Override
    public void esegui(boolean approva) {
        this.getApprovabile().setVisibile(approva);
    }


}