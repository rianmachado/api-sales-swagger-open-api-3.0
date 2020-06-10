package br.com.rian.sales.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.rian.sales.constants.ConstantsMsg;
import br.com.rian.sales.constants.ConstantsUtil;
import br.com.rian.sales.exceptions.ApiSalesException;
import br.com.rian.sales.filters.SalesFilter;
import br.com.rian.sales.filters.SalesFilter.SalesFilterBuilder;

@Component
public class ServiceUtilits {

    private static final Logger LOGGER = LogManager.getLogger(ServiceUtilits.class);

    public SalesFilterBuilder montarFiltroDataFormatado(String dataInicio, String dataFim, String formato) {

        SalesFilterBuilder filter = SalesFilter.builder()
            .dataInicio(Optional.ofNullable(dataInicio)
                .orElseThrow(() -> new ApiSalesException(ConstantsMsg.ERRO_FILTRO_INVALIDO)))
            .dataFim(Optional.ofNullable(dataFim)
                .orElseThrow(() -> new ApiSalesException(ConstantsMsg.ERRO_FILTRO_INVALIDO)));

        if (!Optional.of(dataInicio).isPresent() == true) {
            new ApiSalesException(ConstantsMsg.ERRO_FILTRO_INVALIDO);
        }
        if (!Optional.of(dataFim).isPresent() == true) {
            new ApiSalesException(ConstantsMsg.ERRO_FILTRO_INVALIDO);
        }
        filter.dataInicio(dataInicio.matches(ConstantsUtil.REGEX_HHMMSS) == true ? dataInicio
            : (dataInicio.split(" "))[0] + ConstantsUtil.HORA_INICIAL_DEFAULT_FILTRO);

        filter.dataFim(dataFim.matches(ConstantsUtil.REGEX_HHMMSS) == true ? dataFim
            : (dataFim.split(" ")[0]) + ConstantsUtil.HORA_FINAL_DEFAULT_FILTRO);

        try {
            filter.dataInicioFormatada(LocalDateTime.parse(filter.build().getDataInicio(),
                DateTimeFormatter.ofPattern(formato)));
            filter.dataFimFormatada(LocalDateTime.parse(filter.build().getDataFim(),
                DateTimeFormatter.ofPattern(formato)));
        } catch (Exception e) {
            LOGGER.error(e);
            throw new ApiSalesException(ConstantsMsg.ERRO_FILTRO_INVALIDO);
        }
        return filter;
    }

    public boolean validarParametrosDatasInicioFim(String dataInicio, String dataFim) {
        Optional<String> inicio = Optional.ofNullable(dataInicio);
        Optional<String> fim = Optional.ofNullable(dataFim);
        return (inicio.isPresent() && fim.isPresent()) ? true : false;

    }

}
