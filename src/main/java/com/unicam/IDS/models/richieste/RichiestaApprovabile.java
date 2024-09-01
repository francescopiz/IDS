package com.unicam.IDS.models.richieste;

import com.unicam.IDS.models.approvabili.Approvabile;
import jakarta.persistence.Entity;

//private GestoreComunale gestoreComunale;

@Entity
public class RichiestaApprovabile extends Richiesta {

    public RichiestaApprovabile(Approvabile approvabile) {
        super(approvabile);
    }

    public RichiestaApprovabile() {
    }

    @Override
    public void esegui(boolean approva) {
        if (approva) {
            //TODO implementa
        }
    }

    //TODO implementa equals e hashCode
}