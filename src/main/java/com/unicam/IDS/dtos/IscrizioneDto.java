package com.unicam.IDS.dtos;

import org.springframework.web.multipart.MultipartFile;

public record IscrizioneDto (String idContest, String idutente, MultipartFile file) {
}
