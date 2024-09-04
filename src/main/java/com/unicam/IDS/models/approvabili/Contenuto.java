package com.unicam.IDS.models.approvabili;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Contenuto extends Approvabile {


    @ManyToOne(fetch = FetchType.EAGER)
    private POI poi;

    @Transient
    private List<MultipartFile> fileMultimediali;

    public Contenuto(String nome, String descrizione, POI poi) {
        super(nome, descrizione);
        this.fileMultimediali = null;
        this.poi = poi;
    }

    public Contenuto(String nome, String descrizione, List<MultipartFile> fileMultimediali, POI poi) {
        this(nome, descrizione, poi);
        this.fileMultimediali = fileMultimediali;
    }

    public Contenuto() {
        this.fileMultimediali = new ArrayList<>();
    }

    public List<MultipartFile> getFileMultimediali() {
        return fileMultimediali;
    }

    @Override
    public String toString() {
        return "Contenuto{" +
                "nome='" + getNome() + '\'' +
                ", descrizione='" + getDescrizione() + '\'' +
                ", fileMultimediali=" + fileMultimediali +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contenuto contenuto)) return false;
        return Objects.equals(poi, contenuto.poi) && Objects.equals(fileMultimediali, contenuto.fileMultimediali) && Objects.equals(getNome(), contenuto.getNome()) && Objects.equals(getDescrizione(), contenuto.getDescrizione());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDescrizione(), poi, fileMultimediali);
    }
}