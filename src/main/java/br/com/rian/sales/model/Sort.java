package br.com.rian.sales.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Sort
 */
@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sort {
    @JsonProperty("empty")
    private Boolean empty = null;

    @JsonProperty("sorted")
    private Boolean sorted = null;

    @JsonProperty("unsorted")
    private Boolean unsorted = null;

}
