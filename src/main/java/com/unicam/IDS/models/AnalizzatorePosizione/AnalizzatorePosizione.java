package com.unicam.IDS.models.AnalizzatorePosizione;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.Posizione;
import com.unicam.IDS.osm.InterfacciaOSM;
import com.unicam.IDS.osm.ServizioOSM;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AnalizzatorePosizione implements AnalizzatorePosizioneInterfaccia {

    private InterfacciaOSM osm;


    public AnalizzatorePosizione(ServizioOSM osm) {
        this.osm = osm;

    }


    @Override
    public boolean isPosizioneInComune(Posizione posizione, Comune comune) {
        String comuneDaPosizione = getComuneDaPosizione(posizione);
        if (comuneDaPosizione == null || comuneDaPosizione.isEmpty()) {
            return false;
        }
        return comuneDaPosizione.equalsIgnoreCase(comune.getNome().trim());
    }


    @Override
    public String getComuneDaPosizione(Posizione posizione) {
        JSONObject risultatoChiamata = null;
        try {
            risultatoChiamata = new JSONObject(osm.getInfoPunto(posizione));
            if (risultatoChiamata.has("address")) {
                JSONObject address = risultatoChiamata.getJSONObject("address");
                if (address.has("city")) return address.getString("city").trim();
                if (address.has("town")) return address.getString("town").trim();
            }
            return "";
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return "";
        }
    }
}
