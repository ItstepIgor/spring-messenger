package com.springmessenger.service.mapper;

import com.springmessenger.dto.MessageDto;
import com.springmessenger.entity.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = MessageMapper.class)
public interface MessageListMapper {
    List<MessageDto> toDTOList(List<Message> messageList);

//    List<Message> toModelList(List<MessageDto> messageDtoList);
}
