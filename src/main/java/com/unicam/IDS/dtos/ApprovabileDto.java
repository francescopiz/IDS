package com.unicam.IDS.dtos;

import com.unicam.IDS.models.approvabili.Contenuto;
import com.unicam.IDS.models.approvabili.POI;
import com.unicam.IDS.models.approvabili.Posizione;
import com.unicam.IDS.models.ruoli.Utente;
import com.unicam.IDS.tempo.AbstractTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public record ApprovabileDto(
        String nome,
        String descrizione,
        Set<Utente> iscritti,
        List<POI> listaPOI,
        List<MultipartFile> listafileMultimediali,
        List<Contenuto> listaContenuti,
        POI poi,
        boolean isItinerario,
        AbstractTime tempo,
        Posizione posizione) {

}
