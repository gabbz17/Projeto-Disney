package com.Project.Disney.web.dto;

import com.Project.Disney.entity.Plan;
import com.Project.Disney.entity.more.Active;

public record PeopleResponseDto(
        Long id,
        String name,
        Active active,
        Plan plan
) {
}
