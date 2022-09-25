package com.springmessenger.service.mapper;

import com.springmessenger.dto.ChatDto;
import com.springmessenger.entity.Chat;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatDto chatToChatDto(Chat chat);

    Chat chatDtoToChat(ChatDto chatDto);
}
