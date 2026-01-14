package com.Project.Disney.service;

import com.Project.Disney.web.dto.ResponseIdDto;
import com.Project.Disney.web.dto.ResponseMovieDto;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public ResponseMovieDto findByName(String name) {
        ResponseEntity<ResponseMovieDto> movie = restTemplate().getForEntity(String.format("https://api.disneyapi.dev/character?name=%s", name), ResponseMovieDto.class);
        return movie.getBody();
    }

    public List<ResponseMovieDto> findAll() {

        ParameterizedTypeReference<List<ResponseMovieDto>> typeRef = new ParameterizedTypeReference<List<ResponseMovieDto>>() {};

        ResponseEntity<List<ResponseMovieDto>> movie = restTemplate().exchange("https://api.disneyapi.dev/character", HttpMethod.GET, null, typeRef);
        return movie.getBody();
    }

    public ResponseIdDto findById(Long id) {
        ResponseEntity<ResponseIdDto> movie = restTemplate().getForEntity(String.format("https://api.disneyapi.dev/character/%d", id), ResponseIdDto.class);
        return movie.getBody();
    }
}
