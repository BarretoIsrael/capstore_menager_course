package com.barreto.developer.capstroremenager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;

    private String name;

    private Integer cod;

    public AuthorDTO() {
    }
}
