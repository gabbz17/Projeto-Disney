package com.Project.Disney.web.mapper;

import com.Project.Disney.entity.People;
import com.Project.Disney.web.dto.PeopleResponseDto;

public class PeopleMapper {

    public static PeopleResponseDto toDto(People people) {
        return new PeopleResponseDto(people.getId(), people.getName(), people.getActive(), people.getPlan());
    }
}
