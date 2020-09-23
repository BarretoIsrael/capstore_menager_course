package com.barreto.developer.capstroremenager.utils;

import com.github.javafaker.Faker;
import com.barreto.developer.capstroremenager.dto.AuthorDTO;
import com.barreto.developer.capstroremenager.entity.Author;

public class AuthorUtils {

    private static final Faker faker = Faker.instance();

    public static AuthorDTO createFakeAuthorDTO() {
        return AuthorDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().author())
                .cod(faker.number().numberBetween(0, 9999))
                .build();
    }

    public static Author createFakeAuthor() {
        return Author.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().author())
                .cod(faker.number().numberBetween(0, 9999))
                .build();
    }

    public static Author createFakeAuthorFrom(AuthorDTO authorDTO) {
        return Author.builder()
                .id(authorDTO.getId())
                .name(authorDTO.getName())
                .cod(authorDTO.getCod())
                .build();
    }
}
