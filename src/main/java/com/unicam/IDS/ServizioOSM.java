package com.unicam.IDS;

import com.unicam.IDS.models.approvabili.Posizione;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ServizioOSM implements InterfacciaOSM {

    @Override
    public String getInfoPunto(Posizione posizione) throws IOException {
        return getJson(getUrlConnection(posizione));
    }

    private String getJson(URLConnection connessione) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connessione.getInputStream()))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        }
    }

    private URLConnection getUrlConnection(Posizione posizione) throws IOException {
        String link = String.format("https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=%s&lon=%s",
                posizione.y(), posizione.x());
        return new URL(link).openConnection();
    }

    @Override
    public Posizione getPosizione(String comune) throws IOException, JSONException {
        String link = String.format("https://nominatim.openstreetmap.org/search.php?q=%s&format=jsonv2",
                comune.replace(" ", "+"));
        String risultato = getJson(new URL(link).openConnection());
        JSONArray risultatoChiamata = new JSONArray(risultato);
        return new Posizione(risultatoChiamata.getJSONObject(0).getDouble("lat"),
                risultatoChiamata.getJSONObject(0).getDouble("lon"));
    }
}