package com.wellbridge.wellbridge.rest.dto.responses.patient;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpecializationResponse {
    private Long id;
    private String name;
    private String image;
}