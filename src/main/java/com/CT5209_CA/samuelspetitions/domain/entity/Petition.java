package com.CT5209_CA.samuelspetitions.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Petition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String emoji;
    private String petitionerFirstName;
    private String petitionerLastName;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String petitionBody;
    private LocalDate petitionDate = LocalDate.now();

    @OneToMany(mappedBy = "petition", cascade = CascadeType.ALL)
    private List<Signature> signatures = new ArrayList<>();

    // constructors
    public Petition() {}

    public Petition(String title, String description, String emoji, String petitionerFirstName, String petitionerLastName, String petitionBody) {
        this.title = title;
        this.description = description;
        this.emoji = emoji;
        this.petitionerFirstName = petitionerFirstName;
        this.petitionerLastName = petitionerLastName;
        this.petitionBody = petitionBody;
        this.petitionDate = LocalDate.now();
    }

    public void addSignature(Signature signature) {
        signatures.add(signature);
    }
}