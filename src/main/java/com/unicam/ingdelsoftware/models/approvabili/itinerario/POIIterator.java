package com.unicam.ingdelsoftware.models.approvabili.itinerario;

import com.unicam.ingdelsoftware.models.approvabili.POI;

public interface POIIterator {
    boolean hasNext();
    POI next();
}