package com.roldaice.myboardgames.infrastructure.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JacksonXmlRootElement(localName = "item")
public class BoardGameXmlDto {

    @JacksonXmlProperty(isAttribute = true)
    private String type;

    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty(localName = "name")
    private BoardGameNameXmlDto name;

    @JacksonXmlProperty(localName = "yearpublished")
    private BoardGameYearPublishedXmlDto yearPublished;

    @Getter
    @Setter
    public static class BoardGameNameXmlDto {

        @JacksonXmlProperty(isAttribute = true)
        private String type;

        @JacksonXmlProperty(isAttribute = true)
        private String value;
    }

    @Getter
    @Setter
    public static class BoardGameYearPublishedXmlDto {

        @JacksonXmlProperty(isAttribute = true)
        private int value;
    }
}
