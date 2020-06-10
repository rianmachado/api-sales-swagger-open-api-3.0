package br.com.rian.sales.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rian.sales.model.Receivable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "receivables", description = "the receivables API")
public interface ReceivablesApi {

    @ApiOperation(
        value = "Obtém as vendas recebidas de acordo com a data informada",
            nickname = "getSalesreceivablesByDate",
            notes = "",
            response = Receivable.class,
            tags = {"Recebimento de vendas",})
    @ApiResponses(
        value = {@ApiResponse(code = 200, message = "Retorna o recebimento das vendas com sucesso", response = Receivable.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Parâmetros inválidos", response = Receivable.class)})
    @RequestMapping(value = "/receivables", produces = {"application/json", "application/json;charset=UTF-8"}, method = RequestMethod.GET)
    ResponseEntity<Receivable> getSalesreceivablesByDate(
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
                defaultValue = "0") @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset);

}
