package com.CT5209_CA.samuelspetitions.web.controller;

import com.CT5209_CA.samuelspetitions.domain.entity.Petition;
import com.CT5209_CA.samuelspetitions.domain.entity.Signature;
import com.CT5209_CA.samuelspetitions.domain.repository.PetitionRepository;
import com.CT5209_CA.samuelspetitions.service.interfaces.PetitionService;
import com.CT5209_CA.samuelspetitions.web.dto.PetitionRequestDTO;
import com.CT5209_CA.samuelspetitions.web.dto.SignatureRequestDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetitionController {
    private final PetitionService petitionService;
//    private PetitionRepository petitionRepository;

    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    // http://localhost:8080/
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("petitions", petitionService.findAll());
        return "index";
    }

    // http://localhost:8080/detail/{id}
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Petition petition = petitionService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Petition not found with id: " + id));
        model.addAttribute("petition", petition);
        model.addAttribute("signature",  new SignatureRequestDTO());
        return "detail";
    }

    @PostMapping("/petition/{id}")
    public String addSignatures(
            @PathVariable Long id,
            @ModelAttribute("signature") SignatureRequestDTO signatureDTO
    ) {
        petitionService.addSignature(id, signatureDTO);
        return "redirect:/detail/" + id;
    }

    // http://localhost:8080/create
    @GetMapping("/create")
    public String createPetitionPage(Model model) {
        model.addAttribute("petition", new PetitionRequestDTO());
        return "create";
    }

    @PostMapping("/create-petition")
    public String createPetition(@Valid @ModelAttribute("petition") PetitionRequestDTO petitionRequestDTO,  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "create";
        }
        petitionService.save(petitionRequestDTO);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        model.addAttribute("petitions", petitionService.searchByTitle(query));
        model.addAttribute("query", query);
        return "search";
    }
}
