package com.CT5209_CA.samuelspetitions.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignatureRequestDTO {
    private String signerFirstName;
    private String signerLastName;
    private String signerEmail;
}
