package com.springmessenger.service.mapper;


import com.springmessenger.dto.MessageDto;
import com.springmessenger.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ChatMapper.class)
public interface MessageMapper {
    @Mapping(target = "chatId", source = "chat.id")
    MessageDto toDTO(Message message);

//    @Mapping(target = "chat", source = "messageDto.chatId")
//    Message toModel(MessageDto messageDto);
}
