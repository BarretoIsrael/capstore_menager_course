package com.barreto.developer.capstroremenager.dto;

import com.barreto.developer.capstroremenager.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CapDTO {

    private Long id;

    @NotBlank
    @Size(max = 200)
    private String marca;

    @NotBlank
    @Size(max = 100)
    private String cor;

    @NotNull
    private Integer tamanho;

    @Valid
    @NotNull
    private AuthorDTO author;
}
