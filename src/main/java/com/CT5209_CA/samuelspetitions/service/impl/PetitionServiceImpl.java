package com.CT5209_CA.samuelspetitions.service.impl;

import com.CT5209_CA.samuelspetitions.domain.entity.Petition;
import com.CT5209_CA.samuelspetitions.domain.entity.PetitionEmoji;
import com.CT5209_CA.samuelspetitions.domain.entity.Signature;
import com.CT5209_CA.samuelspetitions.domain.repository.PetitionRepository;
import com.CT5209_CA.samuelspetitions.service.interfaces.PetitionService;
import com.CT5209_CA.samuelspetitions.web.dto.PetitionRequestDTO;
import com.CT5209_CA.samuelspetitions.web.dto.SignatureRequestDTO;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PetitionServiceImpl implements PetitionService {
    private final PetitionRepository petitionRepository;

    public PetitionServiceImpl(PetitionRepository petitionRepository) {
        this.petitionRepository = petitionRepository;
    }

    @Override
    @Transactional
    public Petition save(PetitionRequestDTO dto) {

        validatePetition(dto);
        Petition petition = new Petition();
        updatePetitionFields(petition, dto);

        return petitionRepository.save(petition);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Petition> findById(Long id) {
        return petitionRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Petition> findAll() {
        return petitionRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Petition> findByTitle(String title) {
        return petitionRepository.findByTitle(title);
    }

    @Override
    public Petition addSignature(Long petitionId, SignatureRequestDTO dto) {
        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> new IllegalArgumentException("Petition not found"));

        Signature signature = new Signature(dto.getSignerFirstName(), dto.getSignerLastName(), dto.getSignerEmail(), petition);
        petition.addSignature(signature);

        return petitionRepository.save(petition);
    }

    // helper functions
    private void updatePetitionFields(@NonNull Petition petition, PetitionRequestDTO dto) {
        petition.setTitle(dto.getTitle());
        petition.setDescription(dto.getDescription());
        petition.setEmoji(dto.getEmoji());
        petition.setPetitionerFirstName(dto.getPetitionerFirstName());
        petition.setPetitionerLastName(dto.getPetitionerLastName());
        petition.setPetitionBody(dto.getPetitionBody());
    }

    private void validatePetition(PetitionRequestDTO petition) {
        if (petition == null) throw new IllegalArgumentException("PetitionRequestDTO is null");

        requireNotBlank(petition.getTitle(), "Title");
        requireNotBlank(petition.getDescription(), "Description");
        requireNotBlank(petition.getPetitionerFirstName(), "Petitioner First Name");
        requireNotBlank(petition.getPetitionerLastName(), "Petitioner Last Name");
        requireNotBlank(petition.getPetitionBody(), "Petition Body");

        validateEmoji(petition.getEmoji());
    }

    private void requireNotBlank(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " is required");
        }
    }

    private void validateEmoji(String emoji) {
        if (emoji == null || emoji.isBlank()) {
            throw new IllegalArgumentException("Emoji is required");
        }
        if (!PetitionEmoji.isValidEmoji(emoji)) {
            throw new IllegalArgumentException("Invalid emoji. Must be one of the allowed round-face emojis.");
        }
    }
}
