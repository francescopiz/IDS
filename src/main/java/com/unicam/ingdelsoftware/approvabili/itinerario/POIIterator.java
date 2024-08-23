package com.unicam.ingdelsoftware.approvabili.itinerario;

import com.unicam.ingdelsoftware.approvabili.POI;

public interface POIIterator {
    boolean hasNext();
    POI next();
}