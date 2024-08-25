package com.unicam.IDS.models.approvabili.itinerario;

import com.unicam.IDS.models.approvabili.POI;

import java.util.List;

public class ItinerarioIterator implements POIIterator {
    private List<POI> listaPOI;
    private int position = 0;

    public ItinerarioIterator(List<POI> listaPOI) {
        this.listaPOI = listaPOI;
    }

    @Override
    public boolean hasNext() {
        return position < listaPOI.size();
    }

    @Override
    public POI next() {
        if (this.hasNext()) {
            return listaPOI.get(position++);
        }
        return null;
    }
}