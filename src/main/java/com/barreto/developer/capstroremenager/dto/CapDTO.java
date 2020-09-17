package com.barreto.developer.capstroremenager.dto;

import com.barreto.developer.capstroremenager.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CapDTO {

    private Long id;

    private String marca;

    private String cor;

    private Integer tamanho;

    private AuthorDTO author;
}
