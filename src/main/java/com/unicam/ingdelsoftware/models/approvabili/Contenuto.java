package com.unicam.ingdelsoftware.models.approvabili;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un Contenuto, estende Approvabile.
 */
public class Contenuto extends Approvabile {
    private String nome;
    private String descrizione;
    private List<File> fileMultimediali;

    /**
     * Costruttore per creare un Contenuto con una lista di file multimediali.
     *
     * @param id              l'id del contenuto
     * @param nome            il nome del contenuto
     * @param descrizione     la descrizione del contenuto
     * @param fileMultimediali la lista di file multimediali del contenuto
     */
    public Contenuto(int id, String nome, String descrizione, List<File> fileMultimediali) {
        super(nome, descrizione);
        this.fileMultimediali = fileMultimediali;
    }

    /**
     * Costruttore per creare un Contenuto senza una lista di file multimediali.
     *
     * @param id          l'id del contenuto
     * @param nome        il nome del contenuto
     * @param descrizione la descrizione del contenuto
     */
    public Contenuto(int id, String nome, String descrizione) {
        super(nome, descrizione);
        this.fileMultimediali = new ArrayList<>();
    }

    /**
     * Restituisce il nome del contenuto.
     *
     * @return il nome del contenuto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce la descrizione del contenuto.
     *
     * @return la descrizione del contenuto
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Restituisce la lista di file multimediali del contenuto.
     *
     * @return la lista di file multimediali
     */
    public List<File> getFileMultimediali() {
        return fileMultimediali;
    }

    /**
     * Restituisce una rappresentazione in stringa del contenuto.
     *
     * @return una stringa che rappresenta il contenuto
     */
    @Override
    public String toString() {
        return "Contenuto{" +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", fileMultimediali=" + fileMultimediali +
                '}';
    }
}