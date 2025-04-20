package com.roldaice.myboardgames.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardGameDto {
    private Long id;
    private String name;
    private String type;
    private int yearPublished;
}
