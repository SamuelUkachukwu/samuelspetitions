package com.CT5209_CA.samuelspetitions.service.interfaces;

import com.CT5209_CA.samuelspetitions.domain.entity.Petition;
import com.CT5209_CA.samuelspetitions.web.dto.PetitionRequestDTO;
import com.CT5209_CA.samuelspetitions.web.dto.SignatureRequestDTO;

import java.util.Optional;

public interface PetitionService {
    void save(PetitionRequestDTO dto);
    Optional<Petition> findById(Long id);
    Iterable<Petition> findAll();
    Iterable<Petition> searchByTitle(String query);

    void addSignature(Long petitionId, SignatureRequestDTO dto);
}
