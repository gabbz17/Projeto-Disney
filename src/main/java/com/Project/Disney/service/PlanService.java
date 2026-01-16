package com.Project.Disney.service;

import com.Project.Disney.entity.Plan;
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
        return repository.save(plan);
    }

    public List<Plan> findAll() {
        return repository.findAll();
    }

    public Plan findById(Long id) {
        return repository.findById(id).get();
    }
}
