package br.com.rian.sales.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rian.sales.filters.SalesFilter;
import br.com.rian.sales.model.Receivable;
import br.com.rian.sales.services.ReceivableService;
import io.swagger.annotations.ApiParam;

@Controller
public class ReceivablesApiController implements ReceivablesApi {

    private static final Logger log = LoggerFactory.getLogger(ReceivablesApiController.class);

    @Autowired
    private ReceivableService receivableService;

    @Override
    public ResponseEntity<Receivable> getSalesreceivablesByDate(
        @NotNull @ApiParam(value = "Data início do Agendamento - Formato dd/mm/yyyy", required = true) @Valid @RequestParam(
            value = "initialDate",
                required = true) String initialDate,
        @NotNull @ApiParam(value = "Data fim Agendamento - Formato dd/mm/yyyy", required = true) @Valid @RequestParam(
            value = "finalDate",
                required = true) String finalDate,
        @NotNull @ApiParam(value = "Id Stelo", required = true) @Valid @RequestParam(value = "idStelo", required = true) List<Long> idStelo,
        @ApiParam(
            value = "Quantidade de Itens da Lista de Transação",
                defaultValue = "10") @Valid @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
        @ApiParam(
            value = "Página da Lista de Transação",
                defaultValue = "0") @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {
        try {
            receivableService.recoverReceivablesByscheduleDate(
                SalesFilter.builder().dataInicio(initialDate).dataFim(finalDate).idsStelo(idStelo).build());
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Receivable>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Receivable>(HttpStatus.NOT_IMPLEMENTED);
    }

}
