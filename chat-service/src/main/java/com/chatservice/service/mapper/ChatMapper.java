package com.chatservice.service.mapper;

import com.chatservice.dto.ChatDto;
import com.chatservice.entity.Chat;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatDto chatToChatDto(Chat chat);

    Chat chatDtoToChat(ChatDto chatDto);
}
