package com.unicam.IDS.restControllers;

import com.unicam.IDS.controllers.ControllerRichieste;
import com.unicam.IDS.dtos.RichiestaApprovabileDto;
import com.unicam.IDS.dtos.RichiestaSegnalazioneDto;
import com.unicam.IDS.dtos.ValutazioneDto;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/richieste")
public class RichiesteRestController {
    private ControllerRichieste controllerRichieste;

    @Autowired
    public RichiesteRestController(ControllerRichieste controllerRichieste) {
        this.controllerRichieste = controllerRichieste;
    }

    @PostMapping("/contenuti/addRichiestaApprovabile")
    public ResponseEntity<Object> addRichiestaApprovabile(@PathParam("idComune") int idComune, @RequestBody RichiestaApprovabileDto richiestaApprovabileDto) {
        boolean response = controllerRichieste.addRichiestaApprovabile(richiestaApprovabileDto, idComune);
        if (response)
            return ResponseEntity.ok("RichiestaApprovabile aggiunta correttamente");
        else
            return ResponseEntity.badRequest().body("Errore nell'aggiunta della richiesta");
    }

    @PostMapping("/contenuti/addSegnalazione")
    public ResponseEntity<Object> addSegnalazione(@RequestBody RichiestaSegnalazioneDto richiestaSegnalazioneDto) {
        boolean response = controllerRichieste.addRichiestaSegnalazione(richiestaSegnalazioneDto.idApprovabile(),
                richiestaSegnalazioneDto.descrizione());
        if (response)
            return ResponseEntity.ok("Segnalazione aggiunta correttamente");
        else
            return ResponseEntity.badRequest().body("Errore nell'aggiunta della segnalazione");
    }

    @PostMapping("/valuta")
    public ResponseEntity<Object> valutaRichiesta(@RequestBody ValutazioneDto valutazioneDto) {
        boolean response = controllerRichieste.valutaRichiesta(valutazioneDto.idRichiesta(), valutazioneDto.approva());
        if (response)
            return new ResponseEntity<>("Richiesta valutata correttamente", HttpStatus.OK);
        else
            return new ResponseEntity<>("Errore nella valutazione della richiesta", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getRichiesteByComune")
    public ResponseEntity<Object> getRichiesteByComune(@PathParam("idComune") int idComune) {
        return ResponseEntity.ok(controllerRichieste.getRichiesteByComune(idComune));
    }
}