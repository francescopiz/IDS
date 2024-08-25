package com.unicam.IDS.models.approvabili.itinerario;

import com.unicam.IDS.models.approvabili.POI;

public interface POIIterator {
    boolean hasNext();
    POI next();
}