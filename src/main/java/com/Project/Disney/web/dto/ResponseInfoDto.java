package com.Project.Disney.web.dto;

public record ResponseInfoDto(
        Integer totalPages,
        Integer count,
        String previousPage,
        String nextPage
) {
}
