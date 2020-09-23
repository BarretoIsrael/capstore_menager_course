package com.barreto.developer.capstroremenager.utils;

import com.barreto.developer.capstroremenager.dto.CapDTO;
import com.barreto.developer.capstroremenager.entity.Caps;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;

import static com.barreto.developer.capstroremenager.utils.AuthorUtils.createFakeAuthor;
import static com.barreto.developer.capstroremenager.utils.AuthorUtils.createFakeAuthorDTO;
import static com.barreto.developer.capstroremenager.utils.AuthorUtils.createFakeAuthorFrom;

public class CapUtils {

    private static final Faker faker = Faker.instance();

    public static CapDTO createFakeCapDTO() {
        return CapDTO.builder()
                .id(faker.number().randomNumber())
                .marca(faker.book().title())
                .cor(faker.book().title())
                .tamanho(faker.number().numberBetween(1, 3))
                .author(createFakeAuthorDTO())
                .build();
    }

    public static Caps createFakeCap() {
        return Caps.builder()
                .id(faker.number().randomNumber())
                .marca(faker.book().title())
                .cor(faker.book().title())
                .tamanho(faker.number().numberBetween(1, 3))
                .author(createFakeAuthor())
                .build();
    }

    public static Caps createFakeCapFrom(CapDTO capDTO) {
        return Caps.builder()
                .id(capDTO.getId())
                .marca(capDTO.getMarca())
                .cor(capDTO.getCor())
                .tamanho(capDTO.getTamanho())
                .author(createFakeAuthorFrom(capDTO.getAuthor()))
                .build();
    }

    public static String asJsonString(CapDTO capDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(capDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}