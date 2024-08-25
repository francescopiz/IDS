package com.unicam.IDS.models;

import com.unicam.IDS.models.ruoli.Utente;

import java.util.ArrayList;
import java.util.List;

public class Contest {

    private String descrizione;
    private int id;
    private String nome;
    private Utente animatore;

    private List<Integer> listaIscritti;   //TODO vedere se vogliamo modificarlo
    private boolean privato;
    private List<Integer> utentiAmmessi;

    Contest(int id, String nome, String descrizione, Utente animatore) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.animatore = animatore;
    }

    public boolean iscriviUtente(int idUtente){
        if(listaIscritti.contains(idUtente))
            return false;
        if(privato)
            if (!utentiAmmessi.contains(idUtente))
                return false;
        listaIscritti.add(idUtente);
        return true;
    }

    public List<Integer> getListaAmmessi(){
        if (privato)
            return utentiAmmessi;
        return new ArrayList<>();
    }


    public List<Integer> getListaIscritti(){
        return listaIscritti;
    }

    public boolean ContestPrivato(){
        return privato;
    }





}
