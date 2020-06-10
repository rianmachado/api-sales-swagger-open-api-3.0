package br.com.rian.sales.filters;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SalesFilter {
    String dataInicio;
    String dataFim;
    LocalDateTime dataInicioFormatada;
    LocalDateTime dataFimFormatada;
    List<Long> idsStelo;

}
