package com.CT5209_CA.samuelspetitions.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetitionResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String emoji;
    private String petitionerFirstName;
    private String petitionerLastName;
    private String petitionBody;
    private LocalDate petitionDate;
}
