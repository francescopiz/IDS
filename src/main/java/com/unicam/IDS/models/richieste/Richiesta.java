package com.unicam.IDS.models.richieste;

import com.unicam.IDS.models.approvabili.Approvabile;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public abstract class Richiesta {
    @Id
    @GeneratedValue
    private int id;

    private int idComune;

    @OneToOne
    private Approvabile approvabile;

    public Richiesta(Approvabile approvabile) {
        this.approvabile = approvabile;
    }

    public Richiesta() {
    }

    public Approvabile getApprovabile() {
        return approvabile;
    }

    public void setIdComune(int idComune) {
        this.idComune = idComune;
    }

    public int getIdComune() {
        return idComune;
    }

    public int getId() {
        return id;
    }

    public void esegui(boolean accetta) {
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Richiesta richiesta)) return false;
        return richiesta.id == this.id;
    }
    @Override
    public int hashCode() {
        return id;
    }
}
