package com.unicam.IDS.models.AnalizzatorePosizione;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.Posizione;
import com.unicam.IDS.osm.InterfacciaOSM;
import com.unicam.IDS.osm.ServizioOSM;
import org.json.JSONObject;

public class AnalizzatorePosizione implements AnalizzatorePosizioneInterfaccia {

    private InterfacciaOSM osm;


    public AnalizzatorePosizione(ServizioOSM osm) {
        this.osm = osm;

    }



    public boolean isPosizioneInComune(Posizione pos, Comune com){
        JSONObject infoPunto = null;
        try {
            infoPunto = new JSONObject(osm.getInfoPunto(pos));
        } catch (Exception e) {System.out.println("OSM ha lanciato un'eccezione");}


        try {
            if (infoPunto != null) {
                if (infoPunto.getJSONObject("address").getString("city").equals(com.getNome()))
                    return true;
                if (infoPunto.getJSONObject("address").getString("town").equals(com.getNome()))
                    return true;
            }
        }catch (Exception e) {System.out.println("JSON ha lanciato un'eccezione");} //TODO ricorda di gestirla
        return false;
    }


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
                    return city;
                if (town != null)
                    return town;
            } catch (Exception e){System.out.println("JSON ha lanciato un'eccezione");} //TODO metti logger anche qui
        return "";
    }




}
