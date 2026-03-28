package com.CT5209_CA.samuelspetitions.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignatureResponseDTO {
    private String signerFirstName;
    private String signerLastName;
    private String signerEmail;
    private LocalDate signedDate;
}
