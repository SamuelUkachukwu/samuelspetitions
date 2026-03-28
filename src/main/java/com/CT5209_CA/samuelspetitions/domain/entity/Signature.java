package com.CT5209_CA.samuelspetitions.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String signerFirstName;
    private String signerLastName;
    private String signerEmail;
    private LocalDate signedDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "petition_id")
    private Petition petition;

    // constructors
    public Signature() {}

    public Signature(String signerFirstName, String signerLastName, String signerEmail, Petition petition) {
        this.signerFirstName = signerFirstName;
        this.signerLastName = signerLastName;
        this.signerEmail = signerEmail;
        this.petition = petition;
        this.signedDate = LocalDate.now();
    }
}