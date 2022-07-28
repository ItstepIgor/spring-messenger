package com.springmessenger.service.mapper;

import com.springmessenger.dto.ChatDto;
import com.springmessenger.entity.Chat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    ChatDto toDTO(Chat chat);

    Chat toModel (ChatDto chatDto);
}
