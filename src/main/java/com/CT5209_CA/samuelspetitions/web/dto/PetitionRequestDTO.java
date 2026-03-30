package com.CT5209_CA.samuelspetitions.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetitionRequestDTO {
    private String title;
    private String description;
    private String petitionerFirstName;
    private String petitionerLastName;
    private String petitionBody;
}
