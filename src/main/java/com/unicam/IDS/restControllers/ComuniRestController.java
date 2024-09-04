package com.unicam.IDS.restControllers;

import com.unicam.IDS.GestorePiattaformaBuilder;
import com.unicam.IDS.controllers.ControllerComuni;
import com.unicam.IDS.dtos.ComuneDto;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.osm.ServizioOSM;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v0/comuni")
public class ComuniRestController {
    private ControllerComuni controllerComuni;

    @Autowired
    public ComuniRestController(GestorePiattaformaBuilder builder) {
        this.controllerComuni = new ControllerComuni(builder);
    }

    @PostMapping("/addComune")
    public ResponseEntity<String> addComune(@RequestBody ComuneDto comune) throws JSONException, IOException {
        boolean aggiunto = false;
        try {
            ServizioOSM servizioOSM = new ServizioOSM();
            aggiunto = this.controllerComuni.addComune(
                    new Comune(comune.nome(),
                            comune.provincia(),
                            servizioOSM.getPosizione(comune.nome())
                    )
            );
        } catch (Exception ignored) {
        }
        if (aggiunto)
            return ResponseEntity.ok("Comune aggiunto");
        else
            return ResponseEntity.badRequest().body("Comune non aggiunto");
    }

    @GetMapping("/getComuni")
    public ResponseEntity<?> getComuni() {
        return ResponseEntity.ok(controllerComuni.getComuni());
    }
}
