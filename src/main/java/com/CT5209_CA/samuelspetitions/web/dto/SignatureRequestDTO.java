package com.CT5209_CA.samuelspetitions.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignatureRequestDTO {
    private String signerFirstName;
    private String signerLastName;
    private String signerEmail;
}
