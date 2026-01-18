package com.Project.Disney.web.controller;

import com.Project.Disney.entity.People;
import com.Project.Disney.service.PeopleService;
import com.Project.Disney.web.dto.EmailRequestDto;
import com.Project.Disney.web.dto.PeopleRequestDto;
import com.Project.Disney.web.dto.PeopleResponseDto;
import com.Project.Disney.web.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PeopleController {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    public final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PeopleRequestDto dto) {
        service.create(dto);
        EmailRequestDto requestDto = new EmailRequestDto(dto.name(), dto.email());
        kafkaTemplate.send("email-Disney-topic", requestDto);
        return ResponseEntity.status(201).body("Usuário criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<People>> findAll() {
        List<People> getAll = service.findAll();
        return ResponseEntity.ok(getAll);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PeopleResponseDto> findById(@PathVariable Long id) {
        PeopleResponseDto getById = service.findById(id);
        return ResponseEntity.ok(getById);
    }
}
