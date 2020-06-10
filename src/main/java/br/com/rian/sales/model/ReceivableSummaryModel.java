package br.com.rian.sales.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ReceivableSummaryModel
 */
@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReceivableSummaryModel {
    @JsonProperty("summary")
    private Summary summary = null;

    @JsonProperty("idStelo")
    private Integer idStelo = null;

    @JsonProperty("itens")
    @Valid
    private List<Receivable> itens = null;

}
