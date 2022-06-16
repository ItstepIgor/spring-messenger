package com.springmessenger.service.mapper;

import com.springmessenger.dto.MessageCSVDto;
import com.springmessenger.entity.MessageCSV;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageCSVMapper {
    MessageCSVDto toDTO(MessageCSV messageCSV);

    MessageCSV toModel(MessageCSVDto messageCSVDto);
}
