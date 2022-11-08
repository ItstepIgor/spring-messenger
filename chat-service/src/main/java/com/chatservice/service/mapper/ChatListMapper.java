package com.chatservice.service.mapper;

import com.chatservice.dto.ChatDto;
import com.chatservice.entity.Chat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ChatMapper.class)
public interface ChatListMapper {

    List<ChatDto> toDTOList(List<Chat> messageList);

    List<Chat> toModelList(List<ChatDto> messageDtoList);
}
