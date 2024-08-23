package com.unicam.ingdelsoftware.approvabili;

import com.unicam.ingdelsoftware.approvabili.itinerario.Itinerario;
import com.unicam.ingdelsoftware.models.ruoli.Utente;
import com.unicam.ingdelsoftware.tempo.Time;

import java.io.File;
import java.util.*;

/**
 * Classe Builder per creare istanze di Approvabile.
 */
public class ApprovabileBuilder {
    private final String id;
    private String descrizione;
    private String nome;
    private Optional<Posizione> posizione;
    private Optional<Time> tempo;
    private List<File> fileMultimediali;
    private List<POI> listaPOI;
    private List<Contenuto> elencoContenuti;
    private Set<Utente> iscritti;
    private Optional<Boolean> approvato;
    private boolean isItinerario;

    /**
     * Costruttore di default che inizializza il builder con valori di default.
     */
    public ApprovabileBuilder() {
        this.id = "";
        this.nome = "";
        this.descrizione = "";
        this.posizione = Optional.empty();
        this.tempo = Optional.empty();
        this.fileMultimediali = new LinkedList<>();
        this.listaPOI = new LinkedList<>();
        this.elencoContenuti = new LinkedList<>();
        this.iscritti = new HashSet<>();
        this.approvato = Optional.empty();
        this.isItinerario = false;
    }

    /**
     * Verifica se una stringa è nulla, vuota o composta solo da spazi bianchi.
     *
     * @param stringa la stringa da verificare
     * @return true se la stringa è nulla, vuota o composta solo da spazi bianchi; false altrimenti
     */
    private boolean checkString(String stringa) {
        return stringa == null || stringa.isEmpty() || stringa.isBlank();
    }

    /**
     * Imposta il nome dell'Approvabile.
     *
     * @param nome il nome da impostare
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se il nome è nullo o vuoto
     */
    public ApprovabileBuilder setNome(String nome) {
        if (checkString(nome))
            throw new IllegalArgumentException("Il nome non può essere nullo.");
        this.nome = nome;
        return this;
    }

    /**
     * Imposta la descrizione dell'Approvabile.
     *
     * @param descrizione la descrizione da impostare
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se la descrizione è nulla o vuota
     */
    public ApprovabileBuilder setDescrizione(String descrizione) {
        if (checkString(descrizione))
            throw new IllegalArgumentException("La descrizione non può essere nulla.");
        this.descrizione = descrizione;
        return this;
    }

    /**
     * Imposta la posizione dell'Approvabile.
     *
     * @param posizione la posizione da impostare
     * @return l'istanza corrente di ApprovabileBuilder
     */
    public ApprovabileBuilder setPosizione(Posizione posizione) {
        this.posizione = Optional.ofNullable(posizione);
        return this;
    }

    /**
     * Imposta il tempo dell'Approvabile.
     *
     * @param tempo il tempo da impostare
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se il tempo è nullo
     */
    public ApprovabileBuilder setTempo(Time tempo) {
        this.tempo = Optional.ofNullable(tempo);
        return this;
    }

    /**
     * Aggiunge una collezione di file multimediali all'Approvabile.
     *
     * @param fileMultimediali la collezione di file da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se la collezione è nulla
     */
    public ApprovabileBuilder addFileMultimediali(Collection<File> fileMultimediali) {
        if (fileMultimediali == null)
            throw new IllegalArgumentException("La lista di file non può essere nulla.");
        this.fileMultimediali.addAll(fileMultimediali);
        return this;
    }

    /**
     * Aggiunge un singolo file multimediale all'Approvabile.
     *
     * @param file il file da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se il file è nullo
     */
    public ApprovabileBuilder addFileMultimediale(File file) {
        return addFileMultimediali(Collections.singletonList(file));
    }

    /**
     * Aggiunge un singolo POI all'Approvabile.
     *
     * @param poi il POI da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se il POI è nullo
     */
    public ApprovabileBuilder addPOI(POI poi) {
        return addListaPOI(Collections.singletonList(poi));
    }

    /**
     * Aggiunge una collezione di POI all'Approvabile.
     *
     * @param listaPOI la collezione di POI da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se la collezione è nulla
     */
    public ApprovabileBuilder addListaPOI(Collection<POI> listaPOI) {
        if (listaPOI == null)
            throw new IllegalArgumentException("Il POI non può essere nullo.");
        this.listaPOI.addAll(listaPOI);
        return this;
    }

    /**
     * Aggiunge un singolo contenuto all'Approvabile.
     *
     * @param contenuto il contenuto da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se il contenuto è nullo
     */
    public ApprovabileBuilder addContenuto(Contenuto contenuto) {
        return addElencoContenuti(Collections.singletonList(contenuto));
    }

    /**
     * Aggiunge una collezione di contenuti all'Approvabile.
     *
     * @param elencoContenuti la collezione di contenuti da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se la collezione è nulla
     */
    public ApprovabileBuilder addElencoContenuti(Collection<Contenuto> elencoContenuti) {
        if (elencoContenuti == null)
            throw new IllegalArgumentException("L'elenco dei contenuti non può essere nullo.");
        this.elencoContenuti.addAll(elencoContenuti);
        return this;
    }

    /**
     * Aggiunge un singolo utente alla lista degli iscritti.
     *
     * @param iscritto l'utente da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se l'utente è nullo
     */
    public ApprovabileBuilder addIscritto(Utente iscritto) {
        return addIscritti(Collections.singletonList(iscritto));
    }

    /**
     * Aggiunge una collezione di utenti alla lista degli iscritti.
     *
     * @param iscritti la collezione di utenti da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se la collezione è nulla
     */
    public ApprovabileBuilder addIscritti(Collection<Utente> iscritti) {
        if (iscritti == null)
            throw new IllegalArgumentException("L'iscritto non può essere nullo.");
        this.iscritti.addAll(iscritti);
        return this;
    }

    /**
     * Inserisce il valore di approvato.
     *
     * @param approvato il valore di approvato
     * @return l'istanza corrente di ApprovabileBuilder
     */
    public ApprovabileBuilder setApprovato(boolean approvato) {
        this.approvato = Optional.of(approvato);
        return this;
    }

    /**
     * Costruisce e restituisce un'istanza di Approvabile basata sullo stato corrente del builder.
     *
     * @return un'istanza di Approvabile
     * @throws IllegalStateException se il nome o la descrizione non sono impostati
     */
    public Approvabile build() {
        if (checkString(nome) || checkString(descrizione)) {
            throw new IllegalStateException("Nome o descrizione non impostati.");
        }
        if (posizione.isEmpty()) {
            return isItinerario ? new Itinerario(nome, descrizione, listaPOI) : new GruppoPOI(nome, descrizione, listaPOI);
        } else {
            if (tempo.isEmpty()) {
                return new POI(nome, descrizione, posizione.get(), elencoContenuti);
            } else {
                return iscritti.isEmpty() ? new Evento(nome, descrizione, posizione.get(), tempo.get(), elencoContenuti) : new Evento(nome, descrizione, posizione.get(), tempo.get(), elencoContenuti, iscritti);
            }
        }
    }

    /**
     * Reimposta il builder al suo stato di default.
     *
     * @return una nuova istanza di ApprovabileBuilder
     */
    public ApprovabileBuilder reset() {
        return new ApprovabileBuilder();
    }
}