package com.Project.Disney.web.controller;

import com.Project.Disney.entity.Plan;
import com.Project.Disney.service.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/plan")
public class PlanController {

    public final PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Plan> create(@RequestBody Plan plan) {
        Plan plan_created = service.create(plan);
        return ResponseEntity.ok(plan_created);
    }
}
