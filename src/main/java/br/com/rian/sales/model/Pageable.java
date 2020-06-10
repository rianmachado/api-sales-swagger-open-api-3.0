package br.com.rian.sales.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Pageable
 */
@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pageable {
    @JsonProperty("offset")
    private Long offset = null;

    @JsonProperty("pageNumber")
    private Integer pageNumber = null;

    @JsonProperty("pageSize")
    private Integer pageSize = null;

    @JsonProperty("paged")
    private Boolean paged = null;

    @JsonProperty("sort")
    private Sort sort = null;

    @JsonProperty("unpaged")
    private Boolean unpaged = null;

}
