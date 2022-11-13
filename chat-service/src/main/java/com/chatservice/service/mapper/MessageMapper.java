package com.chatservice.service.mapper;


import com.chatservice.dto.MessageDto;
import com.chatservice.entity.Message;
import com.chatservice.service.ChatService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {ChatService.class})
public interface MessageMapper {

    @Mapping(target = "chatId", source = "chat.id")
    MessageDto toDTO(Message message);

    @Mapping(target = "chat", source = "chatId")
    Message toModel(MessageDto messageDto);

}
