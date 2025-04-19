package com.example.myboardgames.infrastructure.client;

import com.example.myboardgames.domain.dto.BoardGameDto;
import java.util.List;

public interface IBoardGameGeekClient {
    List<BoardGameDto> searchBoardGamesByName(String name);
}
