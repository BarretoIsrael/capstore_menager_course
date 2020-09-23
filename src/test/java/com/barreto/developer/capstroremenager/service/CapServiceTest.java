package com.barreto.developer.capstroremenager.service;

import com.barreto.developer.capstroremenager.dto.CapDTO;
import com.barreto.developer.capstroremenager.entity.Caps;
import com.barreto.developer.capstroremenager.repository.CapRepository;
import com.barreto.developer.capstroremenager.utils.CapUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.barreto.developer.capstroremenager.utils.CapUtils.createFakeCap;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CapServiceTest {

    @Mock
    private CapRepository capRepository;

    @InjectMocks
    private CapService capService;

    @Test
    void whenGivingExistingIdThenReturnThisCap() {
        Caps expectedFoundCap = createFakeCap();

        Mockito.when(capRepository.findById(expectedFoundCap.getId()))
                .thenReturn(Optional.of(expectedFoundCap));

        CapDTO capDTO = capService.findById((expectedFoundCap.getId()));

        assertEquals(expectedFoundCap.getMarca(), capDTO.getMarca());
        assertEquals(expectedFoundCap.getCor(), capDTO.getCor());
        assertEquals(expectedFoundCap.getTamanho(), capDTO.getTamanho());
    }
}
