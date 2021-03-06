package com.barreto.developer.capstroremenager.service;

import com.barreto.developer.capstroremenager.dto.CapDTO;
import com.barreto.developer.capstroremenager.entity.Caps;
import com.barreto.developer.capstroremenager.exception.CapNotFoundException;
import com.barreto.developer.capstroremenager.repository.CapRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.barreto.developer.capstroremenager.utils.CapUtils.createFakeCap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CapServiceTest {

    @Mock
    private CapRepository capRepository;

    @InjectMocks
    private CapService capService;

    @Test
    void whenGivingExistingIdThenReturnThisCap() throws CapNotFoundException {
        Caps expectedFoundCap = createFakeCap();

        when(capRepository.findById(expectedFoundCap.getId()))
                .thenReturn(Optional.of(expectedFoundCap));

        CapDTO capDTO = capService.findById((expectedFoundCap.getId()));

        assertEquals(expectedFoundCap.getMarca(), capDTO.getMarca());
        assertEquals(expectedFoundCap.getCor(), capDTO.getCor());
        assertEquals(expectedFoundCap.getTamanho(), capDTO.getTamanho());
    }

    @Test
    void whenGivingUnexistingIdThenNotFindThrowAnException() {
        var invalidId = 10L;


        when(capRepository.findById(invalidId)).thenReturn(Optional.ofNullable(any(Caps.class)));

        assertThrows(CapNotFoundException.class, () -> capService.findById(invalidId));
    }
}
