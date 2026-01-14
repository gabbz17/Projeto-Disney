package com.Project.Disney.web.dto;


import java.util.List;

public record ResponseDataDto(
        Long id,
        List<String> films,
        List<String> shortFilms,
        List<String>tvShows,
        List<String> videoGames,
        List<String> enemies,
        String sourceUrl,
        String name,
        String imageUrl,
        String url
) {
}
