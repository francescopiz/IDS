package com.unicam.IDS.restControllers;

import com.unicam.IDS.controllers.ControllerComponenti;
import com.unicam.IDS.dtos.ApprovabileDto;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/componenti")
public class ComponentiRestController {

    private ControllerComponenti controllerComponenti;

    @Autowired
    public ComponentiRestController(ControllerComponenti controllerComponenti) {
        this.controllerComponenti = controllerComponenti;
    }

    @PostMapping("/addApprovabile")
    public ResponseEntity<Object> addApprovabile(@RequestBody ApprovabileDto approvabileDto) {
        boolean response = controllerComponenti.addApprovabile(approvabileDto);
        if (response)
            return new ResponseEntity<>("Componente aggiunto correttamente", HttpStatus.OK);
        else
            return new ResponseEntity<>("Errore nell'aggiunta del componente", HttpStatus.BAD_REQUEST);

    }
}
