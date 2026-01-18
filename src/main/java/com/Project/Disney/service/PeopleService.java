package com.Project.Disney.service;

import com.Project.Disney.entity.People;
import com.Project.Disney.entity.Plan;
import com.Project.Disney.exception.IdNotFoundException;
import com.Project.Disney.repository.PeopleRepository;
import com.Project.Disney.web.dto.PeopleRequestDto;
import com.Project.Disney.web.dto.PeopleResponseDto;
import com.Project.Disney.web.mapper.PeopleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    public final PeopleRepository repository;
    public final PlanService planService;

    public PeopleService(PeopleRepository repository, PlanService planService) {
        this.repository = repository;
        this.planService = planService;
    }

    public People create(PeopleRequestDto dto) {
        People people = new People();
        Plan plan = planService.findById(dto.plan());

        people.setName(dto.name());
        people.setCpf(dto.cpf());
        people.setEmail(dto.email());
        people.setActive(dto.active());
        people.setPlan(plan);

        return repository.save(people);
    }

    public List<People> findAll() {
        return repository.findAll();
    }

    public PeopleResponseDto findById(Long id) {
        People people = repository.findById(id).orElseThrow(() ->
                new IdNotFoundException("Cliente não encontrado!"));

        return PeopleMapper.toDto(people);
    }
}
