package com.unicam.IDS.restControllers;

import com.unicam.IDS.controllers.ControllerUtenti;
import com.unicam.IDS.dtos.RuoloComuneDto;
import com.unicam.IDS.dtos.UtenteDto;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.ruoli.Ruolo;
import com.unicam.IDS.models.ruoli.RuoloInComune;
import com.unicam.IDS.models.ruoli.Utente;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v0/utenti")
public class UtentiRestController {

    private final ControllerUtenti controllerUtenti;

    @Autowired
    public UtentiRestController(ControllerUtenti controllerUtenti) {
        this.controllerUtenti = controllerUtenti;
    }

    @PostMapping("/addUtente")
    public ResponseEntity<Object> aggiungiUtente(@RequestBody UtenteDto utente) {
        boolean risultato = controllerUtenti.addUtente(new Utente(utente.nome(), utente.email()));
        if (risultato) return new ResponseEntity<>("Utente aggiunto correttamente.", HttpStatus.OK);
        else return new ResponseEntity<>("Errore nell'aggiunta dell'utente.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteUtente")
    public ResponseEntity<Object> rimuoviUtente(@PathParam("id") int id) {
        boolean risultato = controllerUtenti.deleteUtente(id);
        if (risultato) return new ResponseEntity<>("Utente rimosso correttamente.", HttpStatus.OK);
        else return new ResponseEntity<>("Errore nella rimozione dell'utente.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/setRuoloUtente")
    public ResponseEntity<Object> setRuoloUtente(@PathParam("id") int id, @RequestBody RuoloComuneDto ruolo) {
        boolean risultato = controllerUtenti.setRuoloUtente(id, new RuoloInComune(ruolo.comune(), ruolo.ruolo()));
        if (risultato) return new ResponseEntity<>("Ruolo utente aggiornato correttamente.", HttpStatus.OK);
        else return new ResponseEntity<>("Errore nell'aggiornamento del ruolo utente.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getComuniAbilitati")
    public ResponseEntity<Set<Comune>> getComuniAbilitati(@PathParam("id") int id, @PathParam("ruolo") Ruolo ruolo) {
        return new ResponseEntity<>(controllerUtenti.getComuniConRuoloUtente(id, ruolo), HttpStatus.OK);
    }

    @GetMapping("/getUtenti")
    public ResponseEntity<Set<Utente>> getUtenti() {
        return new ResponseEntity<>(controllerUtenti.getUtenti(), HttpStatus.OK);
    }
}