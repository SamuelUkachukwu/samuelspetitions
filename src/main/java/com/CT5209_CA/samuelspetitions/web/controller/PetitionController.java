package com.CT5209_CA.samuelspetitions.web.controller;

import com.CT5209_CA.samuelspetitions.service.interfaces.PetitionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetitionController {
    private final PetitionService petitionService;

    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    // http://localhost:8080/
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("petitions", petitionService.findAll());
        return "index";
    }
}
