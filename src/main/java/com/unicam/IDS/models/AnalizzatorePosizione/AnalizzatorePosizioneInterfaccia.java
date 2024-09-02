package com.unicam.IDS.models.AnalizzatorePosizione;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.approvabili.Posizione;

public interface AnalizzatorePosizioneInterfaccia {

    public boolean isPosizioneInComune(Posizione pos, Comune com);

    public String getComuneDaPosizione(Posizione pos);
}
