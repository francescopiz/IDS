package com.unicam.IDS.dtos;

import org.springframework.web.multipart.MultipartFile;

public record IscrizioneDto (int idContest, int idUtente, MultipartFile file) {
}
