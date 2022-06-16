package com.springmessenger.service.mapper;


import com.springmessenger.dto.MessageDto;
import com.springmessenger.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDto toDTO(Message message);

    Message toModel(MessageDto messageDto);
}
