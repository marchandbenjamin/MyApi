package com.example.myboardgames.api.controller;

import com.example.myboardgames.domain.dto.BoardGameDto;
import com.example.myboardgames.infrastructure.client.IBoardGameGeekClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/api/board-games")
public class BoardGameController {

    @Autowired
    private IBoardGameGeekClient boardGameGeekClient;

    @Operation(
        summary = "Get a list of board game by name",
        description = "Returns a list of board games that match the given name.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Board game list",
                content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = BoardGameDto.class)))
            )
        })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BoardGameDto>> getBoardGames(@RequestParam String name) {
        return ResponseEntity.ok(boardGameGeekClient.searchBoardGamesByName(name));
    }
}
