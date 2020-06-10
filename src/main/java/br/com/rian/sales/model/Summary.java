package br.com.rian.sales.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Summary
 */
@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
    @JsonProperty("totalQuantity")
    private Long totalQuantity = null;

    @JsonProperty("totalAmount")
    private Double totalAmount = null;

    @JsonProperty("totalNetAmount")
    private Double totalNetAmount = null;

    @JsonProperty("secondaryFields")
    @Valid
    private List<String> secondaryFields = null;

}
