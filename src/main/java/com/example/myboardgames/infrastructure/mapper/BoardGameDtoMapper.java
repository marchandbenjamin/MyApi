package com.example.myboardgames.infrastructure.mapper;

import com.example.myboardgames.domain.dto.BoardGameDto;
import com.example.myboardgames.infrastructure.dto.BoardGameXmlDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BoardGameDtoMapper {

    @Mapping(source = "name.value", target = "name")
    @Mapping(source = "yearPublished.value", target = "yearPublished")
    BoardGameDto fromBoardGameXml(BoardGameXmlDto dto);
}
