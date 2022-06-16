package com.springmessenger.service.mapper;

import com.springmessenger.dto.MessageCSVDto;
import com.springmessenger.entity.MessageCSV;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = MessageCSVMapper.class)
public interface MessageCSVListMapper {
    List<MessageCSVDto> toDTOList(List<MessageCSV> messageCSVList);

    List<MessageCSV> toModelList(List<MessageCSVDto> messageCSVDtoList);
}
