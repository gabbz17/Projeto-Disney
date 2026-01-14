package com.Project.Disney.dto;

public record ResponseInfoDto(
        Integer totalPages,
        Integer count,
        String previousPage,
        String nextPage
) {
}
