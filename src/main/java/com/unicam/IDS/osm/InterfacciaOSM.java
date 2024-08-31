package com.unicam.IDS.osm;

import com.unicam.IDS.models.approvabili.Posizione;
import org.json.JSONException;

import java.io.IOException;

public interface InterfacciaOSM {

    /**
     * Metodo utilizzato per ottenere le informazioni di un punto
     * geografico da OpenStreetMap.
     *
     * @param posizione Le coordinate del punto di cui si vogliono ottenere le informazioni.
     * @return Le informazioni, in formato JSON, ottenute da OSM riguardanti il punto dato.
     */
    String getInfoPunto(Posizione posizione) throws IOException;

    /**
     * Metodo utilizzato per ottenere la posizione di un comune.
     *
     * @param comune Il comune di cui si vogliono ottenere le coordinate.
     * @return Le coordinate del comune dato.
     * @throws IOException Se si verifica un errore di I/O.
     */
    Posizione getPosizione(String comune) throws IOException, JSONException;


}