package com.unicam.IDS.dtos;

import org.springframework.web.multipart.MultipartFile;

public record IscrizioneDto (String idContest, String idUtente, MultipartFile file) {
}
