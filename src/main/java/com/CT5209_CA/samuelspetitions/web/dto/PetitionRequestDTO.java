package com.CT5209_CA.samuelspetitions.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetitionRequestDTO {
    private String title;
    private String description;
    private String emoji;
    private String petitionerFirstName;
    private String petitionerLastName;
    private String petitionBody;
}
