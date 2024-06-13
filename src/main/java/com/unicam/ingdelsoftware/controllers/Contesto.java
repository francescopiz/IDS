package com.unicam.ingdelsoftware.controllers;

import com.unicam.ingdelsoftware.controllers.GestorePOI;
import com.unicam.ingdelsoftware.models.Comune;
import com.unicam.ingdelsoftware.models.Liste;
import com.unicam.ingdelsoftware.models.Posizione;

public class Contesto {

    private final Liste liste;


    public Contesto(Liste liste){
        this.liste = liste;
    }

    public static class Gestore{
        private static Liste liste;
        private static GestorePOI gestorePOI = null;


        public Gestore(Liste liste){
            Gestore.liste = liste;
        }

        public static GestorePOI GetGestorePOI(){
            if(gestorePOI != null)
                return gestorePOI;
            gestorePOI = new GestorePOI(liste);
            return gestorePOI;
        }

    }




    //TODO metodo messo qui giusto per non far dare errore
    public static Comune getComuneFromPosition(Posizione pos){
        return new Comune();
    }
}
