package com.unicam.IDS.tempo;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Questa classe rappresenta un timer che notifica gli observer ogni clock millisecondi.
 */
public class Timer {

    private Set<ObserverTime> observers;
    private LocalDateTime now;
    private java.util.Timer timer;

    /**
     * Costruttore del timer.
     * @param clock intervallo di tempo in millisecondi tra le notifiche agli observer.
     * @param observers gli observer da notificare.
     */
    public Timer(int clock, Collection<ObserverTime> observers) {
        this.observers = new HashSet<>(observers);
        // per notificare gli observer ogni clock millisecondi usando thread
        this.timer = new java.util.Timer();
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                setNow(LocalDateTime.now());
            }
        }, 0, clock);
    }

    /**
     * Imposta l'ora attuale e notifica gli observer.
     * @param now l'ora attuale.
     */
    public void setNow(LocalDateTime now) {
        this.now = now;
        notifyObservers();
    }

    private void notifyObservers() {
        this.observers.parallelStream().forEach(observer -> observer.update(this.now));
    }

    /**
     * Aggiunge un observer alla lista di observer.
     * @param observer l'observer da aggiungere.
     */
    public void subscribe(ObserverTime observer) {
        observers.add(observer);
    }

    /**
     * Rimuove un observer dalla lista di observer.
     * @param observer l'observer da rimuovere.
     */
    public void unsubscribe(ObserverTime observer) {
        observers.remove(observer);
    }
}