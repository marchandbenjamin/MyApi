package com.roldaice.myboardgames.infrastructure.client;

import com.roldaice.myboardgames.domain.dto.BoardGameDto;
import java.util.List;

public interface IBoardGameGeekClient {
    List<BoardGameDto> searchBoardGamesByName(String name);
}
