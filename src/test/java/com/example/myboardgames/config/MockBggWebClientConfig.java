package com.example.myboardgames.config;

import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@TestConfiguration
public class MockBggWebClientConfig {

    @Bean
    @Primary
    public WebClient.Builder webClientBuilder() {
        WebClient mockWebClient = WebClient.builder()
            .exchangeFunction(request -> {
                ClientResponse response = ClientResponse.create(HttpStatus.OK)
                    .header("Content-Type", "application/xml")
                    .body("""
                            <items>
                              <item id="123">
                                <name value="Catan"/>
                                <yearpublished value="1995"/>
                              </item>
                            </items>
                        """)
                    .build();
                return Mono.just(response);
            })
            .baseUrl("https://boardgamegeek.com/xmlapi2")
            .build();

        WebClient.Builder builderMock = Mockito.mock(WebClient.Builder.class);
        Mockito.when(builderMock.baseUrl(Mockito.anyString())).thenReturn(builderMock);
        Mockito.when(builderMock.build()).thenReturn(mockWebClient);

        return builderMock;
    }
}