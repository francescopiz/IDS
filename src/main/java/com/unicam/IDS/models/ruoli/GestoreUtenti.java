package com.unicam.IDS.models.ruoli;

import com.unicam.IDS.repositorys.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GestoreUtenti {

    // Il gestore dei ruoli
    private final GestoreRuoli gestoreRuoli;

    // La repository degli utenti
    private UtentiRepository utentiRepository;

    /**
     * Costruttore per la classe GestoreUtenti.
     *
     * @param utentiRepository La repository degli utenti.
     */
    @Autowired
    public GestoreUtenti(UtentiRepository utentiRepository) {
        gestoreRuoli = new GestoreRuoli();
        this.utentiRepository = utentiRepository;
    }

    /**
     * Aggiunge un utente alla lista.
     *
     * @param utente L'utente da aggiungere.
     * @return true se l'utente è stato aggiunto con successo.
     */
    public boolean addUtente(Utente utente) {
        this.utentiRepository.save(utente);
        return true;
    }

    /**
     * Rimuove un utente dalla lista.
     *
     * @param utente L'utente da rimuovere.
     * @return true se l'utente è stato rimosso con successo, false altrimenti.
     */
    public boolean deleteUtente(Utente utente) {
        if (this.utentiRepository.existsById(utente.getId())) {
            this.utentiRepository.delete(utente);
            return true;
        }
        return false;
    }

    /**
     * Imposta il ruolo di un utente.
     *
     * @param utente      L'utente a cui impostare il ruolo.
     * @param ruoloComune Il ruolo da impostare.
     * @return true se il ruolo è stato impostato con successo.
     */
    public boolean setRuoloUtente(Utente utente, RuoloInComune ruoloComune) {
        if (utente == null || ruoloComune == null) return false;
        if (this.utentiRepository.existsById(utente.getId())) {
            return gestoreRuoli.conferisciRuoloComuneAUtente(utente, ruoloComune);
        }
        return false;
    }

    /**
     * Restituisce il gestore dei ruoli.
     *
     * @return Il gestore dei ruoli.
     */
    public GestoreRuoli getGestoreRuoli() {
        return gestoreRuoli;
    }

    public Set<Utente> getUtenti() {
        return new HashSet<>(utentiRepository.findAll());
    }

    /**
     * Restituisce un utente in base al suo ID.
     *
     * @param idUtente L'ID dell'utente.
     * @return L'utente con l'ID dato, o null se non esiste un utente con tale ID.
     */
    public Utente getUtenteById(int idUtente) {
        return utentiRepository.findById(idUtente).orElse(null);
    }

    /**
     * Restituisce una rappresentazione in stringa dell'oggetto GestoreUtenti.
     *
     * @return Una rappresentazione in stringa dell'oggetto GestoreUtenti.
     */
    @Override
    public String toString() {
        return "GestoreUtenti{" +
                "utenti=" + this.utentiRepository.count() +
                '}';
    }

}
