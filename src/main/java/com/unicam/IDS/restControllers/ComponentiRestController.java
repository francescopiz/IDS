package com.unicam.IDS.restControllers;

import com.unicam.IDS.controllers.ControllerComponenti;
import com.unicam.IDS.dtos.ApprovabileDto;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.Approvabile;
import com.unicam.IDS.models.ruoli.Ruolo;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v0/componenti")
public class ComponentiRestController {

    private ControllerComponenti controllerComponenti;

    @Autowired
    public ComponentiRestController(ControllerComponenti controllerComponenti) {
        this.controllerComponenti = controllerComponenti;
    }

    @PostMapping("/addApprovabile")
    public ResponseEntity<Object> addApprovabile(@PathParam("idComune") int idComune, @RequestBody ApprovabileDto approvabileDto) {
        boolean response = controllerComponenti.addApprovabile(approvabileDto, idComune);
        if (response)
            return new ResponseEntity<>("Componente aggiunto correttamente", HttpStatus.OK);
        else
            return new ResponseEntity<>("Errore nell'aggiunta del componente", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getApprovabili")
    public ResponseEntity<Set<Approvabile>> getApprovabili(@PathParam("idComune") int idComune) {
        return new ResponseEntity<>(controllerComponenti.getApprovabili(idComune), HttpStatus.OK);
    }
}