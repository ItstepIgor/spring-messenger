package com.springmessenger.service.mapper;


import com.springmessenger.dto.MessageDto;
import com.springmessenger.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(target = "chatDto", source = "chat")
    MessageDto toDTO(Message message);

    @Mapping(target = "chat", source = "chatDto")
    Message toModel(MessageDto messageDto);
}
