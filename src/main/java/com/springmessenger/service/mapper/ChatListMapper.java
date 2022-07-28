package com.springmessenger.service.mapper;

import com.springmessenger.dto.ChatDto;
import com.springmessenger.entity.Chat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ChatMapper.class)
public interface ChatListMapper {

    List<ChatDto> toDTOList(List<Chat> messageList);

    List<Chat> toModelList(List<ChatDto> messageDtoList);
}
