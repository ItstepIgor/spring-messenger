package com.springmessenger.service.mapper;


import com.springmessenger.dto.ChatDto;
import com.springmessenger.dto.MessageDto;
import com.springmessenger.entity.Chat;
import com.springmessenger.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(target = "chatDto", source = "chat")
    MessageDto toDTO(Message message);

    ChatDto chatToChatDto(Chat chat);

    @Mapping(target = "chat", source = "chatDto")
    Message toModel(MessageDto messageDto);

    Chat chatDtoToChat(ChatDto chatDto);
}
