package com.Project.Disney.service;

import com.Project.Disney.entity.Plan;
import com.Project.Disney.exception.IdNotFoundException;
import com.Project.Disney.exception.ListNotFoundException;
import com.Project.Disney.exception.NameUniqueException;
import com.Project.Disney.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    public final PlanRepository repository;

    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    public Plan create(Plan plan) {
        try {

            return repository.save(plan);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {

            throw new NameUniqueException(String.format("Plano com o nome (%s), já cadastrado!", plan.getName()));
        }
    }

    public List<Plan> findAll() {
        if (repository.findAll().isEmpty()) {
            throw  new ListNotFoundException("Produtos não encontrados!");
        }

        return repository.findAll();
    }

    public Plan findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new IdNotFoundException(String.format("Plano com o id (%d), não encontrado!", id)));
    }
}
