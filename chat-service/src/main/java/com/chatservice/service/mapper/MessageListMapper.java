package com.chatservice.service.mapper;

import com.chatservice.dto.MessageDto;
import com.chatservice.entity.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = MessageMapper.class)
public interface MessageListMapper {
    List<MessageDto> toDTOList(List<Message> messageList);

    List<Message> toModelList(List<MessageDto> messageDtoList);
}
