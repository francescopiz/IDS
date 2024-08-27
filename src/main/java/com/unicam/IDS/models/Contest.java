package com.unicam.IDS.models;

import com.unicam.ingdelsoftware.models.ruoli.Utente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contest {

    private String descrizione;
    private int id;
    private String nome;
    private Utente animatore;
    private Iscrizione vincitore;
    private List<Integer> utentiIscritti;
    private List<Integer> utentiAmmessi;

    Contest(int id, String nome, String descrizione, Utente animatore) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.animatore = animatore;
        this.vincitore = null;
        this.utentiIscritti = new ArrayList<>();
        this.utentiAmmessi = new ArrayList<>();
    }
    Contest(int id, String nome, String descrizione, Utente animatore, List<Integer> utentiAmmessi){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.animatore = animatore;
        this.vincitore = null;
        this.utentiIscritti = new ArrayList<>();
        this.utentiAmmessi = utentiAmmessi;
    }

    public List<Integer> getListaAmmessi(){
        if (this.utentiAmmessi.size() > 0)
            return utentiAmmessi;
        return new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public List<Integer> getListaIscritti(){
        return utentiIscritti;
    }

    public boolean contestPrivato(){
        return this.utentiAmmessi.size() > 0;
    }

    public Iscrizione getVincitore() {
        return this.vincitore;
    }

    public boolean setVincitore(Iscrizione iscrizione){
        this.vincitore = iscrizione;
        return true;
    }
    
    //TODO in qualche modo deve restituire false? I vari controlli sono fatti sul gestore, bisogna metterli lì o qui
    public boolean iscriviUtente(int idUtente){
        utentiIscritti.add(idUtente);
        return true;
    }

    /**
     * Metodo per vedere se un utente può iscriversi o meno a un contest
     * @param utente
     * @return true se l'utente può iscriversi
     * @return false se non si può iscrivere (nel caso in cui il contest sia privato e non ci sta scritto il suo nome)
     */
    public boolean utenteAbilitato (Utente utente){
        if(this.utentiAmmessi == null || this.utentiAmmessi.size() == 0)
            return true;
        return this.utentiAmmessi.contains(utente.getId());
    }

}
