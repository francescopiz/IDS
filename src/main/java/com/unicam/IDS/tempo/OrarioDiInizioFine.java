package com.unicam.IDS.tempo;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public final class OrarioDiInizioFine implements Comparable<OrarioDiInizioFine> {
    private LocalDateTime inizio;
    private LocalDateTime fine;

    /**
     * Costruttore che inizializza l'orario di inizio e fine.
     *
     * @param inizio l'orario di inizio.
     * @param fine   l'orario di fine.
     */
    public OrarioDiInizioFine(LocalDateTime inizio, LocalDateTime fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

    public OrarioDiInizioFine() {
    }

    /**
     * Controlla se una parte dell'orario è compresa tra l'orario di inizio e l'orario di fine.
     *
     * @param orarioDiInizioFine l'orario da controllare.
     * @return true se l'orario è compreso tra l'orario di inizio e l'orario di fine.
     */
    public boolean sovrapposto(OrarioDiInizioFine orarioDiInizioFine) {
        return (inizio.isBefore(orarioDiInizioFine.fine) || inizio.isEqual(orarioDiInizioFine.fine))
                && (fine.isAfter(orarioDiInizioFine.inizio) || fine.isEqual(orarioDiInizioFine.inizio));
    }

    /**
     * Controlla se un orario è compreso tra l'orario di inizio e l'orario di fine.
     *
     * @param orario l'orario da controllare.
     * @return true se l'orario è compreso tra l'orario di inizio e l'orario di fine, compresi gli estremi, false altrimenti.
     */
    public boolean contiene(LocalDateTime orario) {
        return (inizio.isBefore(orario) || inizio.isEqual(orario)) && (fine.isAfter(orario) || fine.isEqual(orario));
    }

    /**
     * Confronta due orari di inizio e fine.
     * Un orario è minore di un altro se il suo orario di fine è minore dell'orario di fine dell'altro.
     *
     * @param o l'orario da confrontare.
     * @return un valore negativo, zero o positivo se l'orario è minore, uguale o maggiore.
     */
    @Override
    public int compareTo(OrarioDiInizioFine o) {
        return fine.compareTo(o.fine);
    }

    @Override
    public String toString() {
        if (inizio.equals(fine)) return "Sempre attivo";
        return "Inizio: " + inizio + " Fine: " + fine;
    }

    public LocalDateTime inizio() {
        return inizio;
    }

    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }

    public LocalDateTime fine() {
        return fine;
    }

    public void setFine(LocalDateTime fine) {
        this.fine = fine;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (OrarioDiInizioFine) obj;
        return Objects.equals(this.inizio, that.inizio) &&
                Objects.equals(this.fine, that.fine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inizio, fine);
    }
}