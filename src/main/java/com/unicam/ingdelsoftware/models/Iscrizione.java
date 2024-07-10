package com.unicam.ingdelsoftware.models;

import com.unicam.ingdelsoftware.models.ruoli.Utente;

public class Iscrizione {
    private int idUtente;
    private int idContest;
    private Contenuto Contenuto;

    public Iscrizione(int c, int u,  Contenuto co){
        idUtente = u;
        idContest = c;
        Contenuto = co;
    }

    public int getIdContest(){
        return idContest;
    }

    public int getIdUtente(){
        return idUtente;
    }

    public Contenuto getContenuto(){
        return Contenuto;
    }

}
