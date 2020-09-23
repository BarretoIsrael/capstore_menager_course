package com.barreto.developer.capstroremenager.service;

import com.barreto.developer.capstroremenager.dto.CapDTO;
import com.barreto.developer.capstroremenager.dto.MessageResponseDTO;
import com.barreto.developer.capstroremenager.entity.Caps;
import com.barreto.developer.capstroremenager.exception.CapNotFoundException;
import com.barreto.developer.capstroremenager.mapper.CapMapper;
import com.barreto.developer.capstroremenager.repository.CapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class CapService {

    private CapRepository capRepository;

    private final CapMapper capMapper = CapMapper.INSTANCE;

    @Autowired
    public CapService(CapRepository capRepository) {
        this.capRepository = capRepository;
    }

    public MessageResponseDTO create(CapDTO capDTO){
        Caps capToSave = capMapper.toModel(capDTO);

        Caps savedCap = capRepository.save(capToSave);
        return MessageResponseDTO.builder()
                .message("Cap created with ID " + savedCap.getId())
                .build();
    }

    public CapDTO findById(Long id) throws CapNotFoundException {
       Caps caps = capRepository.findById(id).orElseThrow(() -> new CapNotFoundException(id));

        return capMapper.toDTO(caps);
    }
}
