package com.unicam.IDS.models.approvabili;

import com.unicam.IDS.models.ruoli.Utente;
import com.unicam.IDS.tempo.AbstractTime;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * Classe Builder per creare istanze di Approvabile.
 */
public class ApprovabileBuilder {
    private String descrizione;
    private String nome;
    private Posizione posizione;
    private AbstractTime tempo;
    private List<MultipartFile> fileMultimediali;
    private List<POI> listaPOI;
    private List<Contenuto> listaContenuti;
    private Set<Utente> iscritti;
    private boolean isItinerario;
    private POI poi;

    /**
     * Costruttore di default che inizializza il builder con valori di default.
     */
    public ApprovabileBuilder() {
        this.nome = "";
        this.descrizione = "";
        this.posizione = null;
        this.tempo = null;
        this.fileMultimediali = new LinkedList<>();
        this.listaPOI = new LinkedList<>();
        this.listaContenuti = new LinkedList<>();
        this.iscritti = new HashSet<>();
        this.isItinerario = false;
    }

    public ApprovabileBuilder setIsItinerario(boolean isItinerario) {
        this.isItinerario = isItinerario;
        return this;
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
        this.posizione = posizione;
        return this;
    }

    /**
     * Imposta il tempo dell'Approvabile.
     *
     * @param tempo il tempo da impostare
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se il tempo è nullo
     */
    public ApprovabileBuilder setTempo(AbstractTime tempo) {
        this.tempo = tempo;
        return this;
    }

    /**
     * Aggiunge una collezione di file multimediali all'Approvabile.
     *
     * @param fileMultimediali la collezione di file da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se la collezione è nulla
     */
    public ApprovabileBuilder addFileMultimediali(Collection<MultipartFile> fileMultimediali) {
        if (fileMultimediali != null)
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
    public ApprovabileBuilder addFileMultimediale(MultipartFile file) {
        return addFileMultimediali(Collections.singletonList(file));
    }

    /**
     * Aggiunge una collezione di POI all'Approvabile.
     *
     * @param listaPOI la collezione di POI da aggiungere
     * @return l'istanza corrente di ApprovabileBuilder
     * @throws IllegalArgumentException se la collezione è nulla
     */
    public ApprovabileBuilder addListaPOI(Collection<POI> listaPOI) {
        if (listaPOI != null)
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
        if (elencoContenuti != null)
            this.listaContenuti.addAll(elencoContenuti);
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
        if (iscritti != null)
            this.iscritti.addAll(iscritti);
        return this;
    }

    public ApprovabileBuilder setPOI(POI poi) {
        this.poi = poi;
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
        if (posizione == null) {
            if (poi != null) {
                return new Contenuto(nome, descrizione, fileMultimediali, poi);
            }
            return isItinerario ? new Itinerario(nome, descrizione, listaPOI) : new GruppoPOI(nome, descrizione, listaPOI);
        }
        if (tempo == null) {
            return new POI(nome, descrizione, posizione, listaContenuti);
        }
        return iscritti.isEmpty() ? new Evento(nome, descrizione, posizione, tempo, listaContenuti) : new Evento(nome, descrizione, posizione, tempo, listaContenuti, iscritti);
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