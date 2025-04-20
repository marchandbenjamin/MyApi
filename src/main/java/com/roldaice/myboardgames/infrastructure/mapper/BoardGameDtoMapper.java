package com.roldaice.myboardgames.infrastructure.mapper;

import com.roldaice.myboardgames.domain.dto.BoardGameDto;
import com.roldaice.myboardgames.infrastructure.dto.BoardGameXmlDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BoardGameDtoMapper {

    @Mapping(source = "name.value", target = "name")
    @Mapping(source = "yearPublished.value", target = "yearPublished")
    BoardGameDto fromBoardGameXml(BoardGameXmlDto dto);
}
