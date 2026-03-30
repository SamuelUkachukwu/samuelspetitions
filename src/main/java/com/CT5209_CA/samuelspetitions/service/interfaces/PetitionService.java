package com.CT5209_CA.samuelspetitions.service.interfaces;

import com.CT5209_CA.samuelspetitions.domain.entity.Petition;
import com.CT5209_CA.samuelspetitions.web.dto.PetitionRequestDTO;
import com.CT5209_CA.samuelspetitions.web.dto.SignatureRequestDTO;

import java.util.Optional;

public interface PetitionService {
    Petition save(PetitionRequestDTO dto);
    Optional<Petition> findById(Long id);
    Iterable<Petition> findAll();
    Optional<Petition> findByTitle(String title);

    void addSignature(Long petitionId, SignatureRequestDTO dto);
}
