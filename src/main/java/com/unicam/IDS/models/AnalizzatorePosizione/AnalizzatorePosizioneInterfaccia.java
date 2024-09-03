package com.unicam.IDS.models.AnalizzatorePosizione;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.Posizione;

public interface AnalizzatorePosizioneInterfaccia {

    /**
     *  Questo metodo preso una posizione controlla tramite chiamata a OSM se il punto fa parte del comune passato come argomento
     * @param pos posizione che si vuole controllare
     * @param com il comune dove ci aspettiamo che si trovi la posizione passata
     * @return true se la posizione fa parte del comune passato, false se la posizione non ne fa parte
     */
    public boolean isPosizioneInComune(Posizione pos, Comune com);

    /**
     *  Questo metodo preso una posizione interroga OSM su quale sia il Comune corrispondente al punto dato, questo viene poi direttamente convertito nel comune corrispondente
     *  nel nostro sistema.
     * @param pos coordinata scelta
     * @return L'oggetto comune del nostro sistema a cui appartiene il punto. NULL se non restituisce un comune o se non c'è corrispettivo esistente nel nostro sistema.
     */
    public String getComuneDaPosizione(Posizione pos);
}
