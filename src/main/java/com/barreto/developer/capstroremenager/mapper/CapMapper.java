package com.barreto.developer.capstroremenager.mapper;

import com.barreto.developer.capstroremenager.dto.CapDTO;
import com.barreto.developer.capstroremenager.entity.Caps;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CapMapper {

    CapMapper INSTANCE = Mappers.getMapper((CapMapper.class));

    Caps toModel(CapDTO capDTO);

    CapDTO toDTO(Caps caps);
}
