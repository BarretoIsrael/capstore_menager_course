package com.barreto.developer.capstroremenager.controller;

import com.barreto.developer.capstroremenager.dto.CapDTO;
import com.barreto.developer.capstroremenager.dto.MessageResponseDTO;
import com.barreto.developer.capstroremenager.service.CapService;
import com.barreto.developer.capstroremenager.utils.CapUtils;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static com.barreto.developer.capstroremenager.utils.CapUtils.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CapControllerTest {

    public static final String CAP_API_URL_PATH = "/api/v1/caps";

    private MockMvc mockMvc;

    @Mock
    private CapService capService;

    @InjectMocks
    private CapController capController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(capController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void testWhenPostIsCalledThenACapShouldBeCreated() throws Exception {
        CapDTO capDTO = createFakeCapDTO();
        MessageResponseDTO expectedMessageResponse = MessageResponseDTO
                .builder()
                .message("Cap created with ID " + capDTO.getId())
                .build();

        when(capService.create(capDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(CAP_API_URL_PATH)
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(capDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
    }
    @Test
    void testWhenPOSTWithInvalidTamanhoIsCalledThenABadRequestShouldBeReturned() throws Exception {
        CapDTO capDTO = createFakeCapDTO();
        capDTO.setTamanho(5);

        mockMvc.perform(post(CAP_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(capDTO)))
                .andExpect(status().isBadRequest());
    }
}