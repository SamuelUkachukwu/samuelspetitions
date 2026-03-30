package com.CT5209_CA.samuelspetitions.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetitionRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "First name is required")
    private String petitionerFirstName;

    @NotBlank(message = "Last name is required")
    private String petitionerLastName;

    @NotBlank(message = "Body is required")
    private String petitionBody;
}
