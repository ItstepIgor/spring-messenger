package com.messageservice.service.mapper;


import com.messageservice.dto.MessageDto;
import com.messageservice.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDto toDTO(Message message);

    Message toModel(MessageDto messageDto);
}
