package com.Project.Disney.web.dto;

import java.util.List;

public record ResponseMovieDto(
        ResponseInfoDto info,
        List<ResponseDataDto> data
) {
}
