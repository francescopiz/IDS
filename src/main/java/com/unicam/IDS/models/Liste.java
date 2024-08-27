package com.unicam.IDS.models;

import com.unicam.IDS.models.approvabili.*;
import com.unicam.IDS.models.ruoli.Utente;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//classe univoca che contiene tutte le liste dei con tutte le varie istanze di oggetti
public class Liste {
    private List<Comune> listaComuni;
    private List<POI> listaPOI;
    private List<Contenuto> listaContenuti;
    private List<GruppoPOI> listaGruppiPOI;
    private List<Utente> listaUtenti;


    public Liste(){
        listaComuni = new ArrayList<>();
    }

    public List<Comune> getListaComuni() {
        return listaComuni;
    }

    public void addComune(Comune comune) {
        this.listaComuni.add(comune);
    }


    // METODI TEMPORANEI

    //metodo fittizio
    public boolean Save(){
        return true;
    }

    public POI getPOI(int POIID){
        for ( POI poi : listaPOI) {
            if(true)
                return poi;
        }
        return null;
    }

    public boolean addUtente(Utente utente){
        listaUtenti.add(utente);
        return true;
    }

    public boolean removeUtente(int utenteID){
        for (Utente utente: listaUtenti) {
            if(utente.getId() == utenteID){
                listaUtenti.remove(utente);
                return true;
            }
        }
        return false;
    }

    public List<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public Utente getUtente(int utenteID){
        for (Utente utente: listaUtenti) {
            if(utente.getId() == utenteID)
                return utente;
        }
        return null;
    }

    public boolean containsUtente(int utenteID){
        for (Utente utente: listaUtenti) {
            if(utente.getId() == utenteID)
                return true;
        }
        return false;
    }

    public POI getPOIInComune(int comuneID, String nomePOI){
        //possibile usare una jquery al posto della ricerca
        //TODO quindi questo metodo va fatto tramite OSR o lo simuliamo in qualche modo?
        return null;
    }

    public boolean addPOI(String nome, Posizione pos){
        int x = listaPOI.size();
        //TODO c'è da fare un controllo se in quel comune esiste già un poi con quel nome
        //listaPOI.add(new POI(x,nome, pos));
        return true;
    }

    public boolean addPOI(String nome, Posizione pos, Date dataInizio, Date dataFine){
        int x = listaPOI.size();
        //TODO c'è da fare un controllo se in quel comune esiste già un poi con quel nome
        if(dataFine==null) {
            //listaPOI.add(new POI(x,nome, pos));
        }
        else { //listaPOI.add( new Evento(x,nome, pos, dataInizio, dataFine));
             }
        return true;
    }

    public GruppoPOI getGruppoPOI(int gruppoPOIID){
        for ( GruppoPOI gruppo : listaGruppiPOI) {
            if(true)
                return gruppo;
        }
        return null;
    }

    public boolean addContenuto(int POIId, String nome, String descrizione, File[] file) {
        POI poi = getPOI(POIId);
        if(poi == null)
            return false;
        Contenuto x = new Contenuto(listaContenuti.size(), nome, descrizione, Arrays.stream(file).toList());
        listaContenuti.add(x);
        //poi.addContenuto(x);
        return true;
    }

    public boolean removeContenuto(int contenutoId){
        for (Contenuto item: listaContenuti) {
            if(true){
                listaContenuti.remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean changeNomeContenuto(int POIid, int contenutoId, String nome) {
        for (Contenuto item:listaContenuti) {
            if (true){
                //item.setNome(nome);
                return true;
            }
        }
        return false;
    }

    public void SetNomePOI(int POIID, String nome) {
        POI poi = getPOI(POIID);
        //poi.setNome(nome);
    }

    public boolean addGruppoPOI(List<POI> listaPOI){
        int x = listaPOI.size();
        //TODO c'è da fare un controllo se in quel comune esiste già un poi con quel nome
        //listaGruppiPOI.add(new GruppoPOI(listaPOI));
        return true;
    }

    public GruppoPOI getGruppo(int idGruppo){
        return listaGruppiPOI.get(idGruppo);
    }

    public boolean setDescrizioneContenuto(int contenutoId, String descrizione) {
        for (Contenuto item: listaContenuti) {
            if(true) {
                //item.setTesto(descrizione);
                return true;
            }
        }
        return false;
    }

    public Comune getComuneFromPosition(Posizione posizione) {
        if(listaComuni.size()==0) {
            System.out.println("la lista comunin è vuota");
            return null;
        }
        return listaComuni.get(0);
    }

    public List<POI> getPOIsFromComune(Comune comune) {
        System.out.println("metodo getPOIsFromComune riconsegna tutti i POI");  //TODO da cambiare
        return listaPOI;
    }
}
