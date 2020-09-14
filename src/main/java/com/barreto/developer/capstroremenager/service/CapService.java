package com.barreto.developer.capstroremenager.service;

import com.barreto.developer.capstroremenager.dto.MessageResponseDTO;
import com.barreto.developer.capstroremenager.entity.Caps;
import com.barreto.developer.capstroremenager.repository.CapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CapService {

    private CapRepository capRepository;

    @Autowired
    public CapService(CapRepository capRepository) {
        this.capRepository = capRepository;
    }

    public MessageResponseDTO create(Caps caps){
        Caps savedCap = capRepository.save(caps);
        return MessageResponseDTO.builder()
                .message("Cap created with ID " + savedCap.getId())
                .build();
    }
}
