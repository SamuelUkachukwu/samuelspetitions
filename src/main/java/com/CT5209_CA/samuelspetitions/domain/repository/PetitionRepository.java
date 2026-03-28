package com.CT5209_CA.samuelspetitions.domain.repository;

import com.CT5209_CA.samuelspetitions.domain.entity.Petition;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PetitionRepository extends CrudRepository<Petition, Long> {
    Optional<Petition> findByTitle(String title);
}