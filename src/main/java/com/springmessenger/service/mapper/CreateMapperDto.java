package com.springmessenger.service.mapper;

import com.springmessenger.dto.CreateMessageDto;
import com.springmessenger.dto.MessageDto;
import com.springmessenger.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateMapperDto {
    CreateMessageDto toDTO(Message message);

    Message toModel(CreateMessageDto createMessageDto);
}
