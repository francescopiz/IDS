package com.unicam.IDS.models.AnalizzatorePosizione;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.GestoreComuni;
import com.unicam.IDS.models.approvabili.Posizione;
import com.unicam.IDS.osm.InterfacciaOSM;
import com.unicam.IDS.osm.ServizioOSM;
import com.unicam.IDS.repositorys.ComuniRepository;
import org.json.JSONObject;

public class AnalizzatorePosizione implements AnalizzatorePosizioneInterfaccia {


    private InterfacciaOSM osm;

    AnalizzatorePosizione(ServizioOSM osm) {
        this.osm = osm;

    }



    public boolean isPosizioneInComune(Posizione pos, Comune com){
        JSONObject infoPunto = null;
        try {
            infoPunto = new JSONObject(osm.getInfoPunto(pos));
        } catch (Exception e) {System.out.println("OSM ha lanciato un'eccezione");}


        try {
            if (infoPunto != null) {
                if (infoPunto.getJSONObject("address").getString("city").equals(com.getNomeOSM()))
                    return true;
                if (infoPunto.getJSONObject("address").getString("town").equals(com.getNomeOSM()))
                    return true;
            }
        }catch (Exception e) {System.out.println("JSON ha lanciato un'eccezione");} //TODO ricorda di gestirla
        return false;
    }

    /**
     *  Questo metodo preso una posizione interroga OSM su quale sia il Comune corrispondente al punto dato, questo viene poi direttamente convertito nel comune corrispondente
     *  nel nostro sistema.
     * @param pos coordinata scelta
     * @return L'oggetto comune del nostro sistema a cui appartiene il punto. NULL se non restituisce un comune o se non c'è corrispettivo esistente nel nostro sistema.
     */
    public String getComuneDaPosizione(Posizione pos){
        JSONObject infoPunto = null;
        try {
            infoPunto = new JSONObject(osm.getInfoPunto(pos));
        } catch (Exception e) {System.out.println("OSM ha lanciato un'eccezione");}
        if(infoPunto != null)
            try {
                String city = infoPunto.getJSONObject("address").getString("city");
                String town = infoPunto.getJSONObject("address").getString("town");
                if (city != null)
                    return GestoreComuni.instance.getComuneDaNomeOSM(city);
                if (town != null)
                    return GestoreComuni.instance.getComuneDaNomeOSM(town);
            } catch (Exception e){System.out.println("JSON ha lanciato un'eccezione");} //TODO metti logger anche qui

    }




}
