package com.example.myboardgames.infrastructure.client;

import com.example.myboardgames.config.MockBggWebClientConfig;
import com.example.myboardgames.domain.dto.BoardGameDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import(MockBggWebClientConfig.class)
public class BoardGameGeekClientTest {

    @Autowired
    private BoardGameGeekClient client;

    @Test
    void searchBoardGamesByName_ShouldReturnGames_WithGoodFilters() {
        // Act
        List<BoardGameDto> result = client.searchBoardGamesByName("Catan");

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Catan", result.getFirst().getName());
        assertEquals(123, result.getFirst().getId());
    }
}
