package com.example.myboardgames.infrastructure.client;

import com.example.myboardgames.domain.dto.BoardGameDto;
import com.example.myboardgames.infrastructure.dto.BoardGamesXmlResponseDto;
import com.example.myboardgames.infrastructure.mapper.BoardGameDtoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class BoardGameGeekClient implements IBoardGameGeekClient {

    private static final String BOARD_GAME_TYPE = "boardgame";
    private static final String BOARD_GAME_GEEK_BASE_URL = "https://boardgamegeek.com/xmlapi2";

    private final WebClient.Builder webClientBuilder;
    private final BoardGameDtoMapper mapper;

    private WebClient webClient;
    private XmlMapper xmlMapper;

    @PostConstruct
    public void init() {
        xmlMapper = new XmlMapper();
        this.webClient = webClientBuilder
            .baseUrl("https://boardgamegeek.com/xmlapi2")
            .build();
    }

    public List<BoardGameDto> searchBoardGamesByName(String name) {
        String xml = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/search")
                .queryParam("type", BOARD_GAME_TYPE)
                .queryParam("query", name.replace(" ", "+"))
                .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();

        BoardGamesXmlResponseDto xmlDtos;
        try {
            xmlDtos = xmlMapper.readValue(xml, BoardGamesXmlResponseDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to parse XML response get from BoardGameGeek", e);
        }
        return xmlDtos.getItems().stream()
            .map(mapper::fromBoardGameXml)
            .collect(Collectors.toList());
    }
}
