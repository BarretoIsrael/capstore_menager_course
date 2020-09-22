package com.barreto.developer.capstroremenager.controller;

import com.barreto.developer.capstroremenager.dto.CapDTO;
import com.barreto.developer.capstroremenager.dto.MessageResponseDTO;
import com.barreto.developer.capstroremenager.entity.Caps;
import com.barreto.developer.capstroremenager.repository.CapRepository;
import com.barreto.developer.capstroremenager.service.CapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/caps")
public class CapController {

    private CapService capService;

    @Autowired
    public CapController(CapService capService) {

        this.capService = capService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid CapDTO capDTO){
        return capService.create(capDTO);
    }
}
