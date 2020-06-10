package br.com.rian.sales.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rian.sales.model.ReceivableSummaryModel;
import io.swagger.annotations.ApiParam;

@Controller
public class SummaryReceivablesApiController implements SummaryReceivablesApi {

    private static final Logger log = LoggerFactory.getLogger(SummaryReceivablesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SummaryReceivablesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ReceivableSummaryModel> getSalesreceivablesSummaryByDate(
        @NotNull @ApiParam(value = "Data início do Agendamento - Formato dd/mm/yyyy", required = true) @Valid @RequestParam(
            value = "initialDate",
                required = true) String initialDate,
        @NotNull @ApiParam(value = "Data fim Agendamento - Formato dd/mm/yyyy", required = true) @Valid @RequestParam(
            value = "finalDate",
                required = true) String finalDate,
        @NotNull @ApiParam(value = "Id Stelo", required = true) @Valid @RequestParam(value = "idStelo", required = true) List<Long> idStelo,
        @ApiParam(value = "Identificadores de Bandeiras de Cartão") @Valid @RequestParam(value = "cardBrandIds", required = false) List<
            Integer> cardBrandIds,
        @ApiParam(value = "Identificadores meio de pagamento") @Valid @RequestParam(value = "paymentIds", required = false) List<Integer> paymentIds,
        @ApiParam(
            value = "Quantidade de Itens da Lista de Transação",
                defaultValue = "10") @Valid @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
        @ApiParam(
            value = "Página da Lista de Transação",
                defaultValue = "0") @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ReceivableSummaryModel>(objectMapper.readValue(
                    "{  \"summary\" : {    \"totalAmount\" : 6.027456183070403,    \"totalQuantity\" : 0,    \"totalNetAmount\" : 1.4658129805029452,    \"secondaryFields\" : [ \"secondaryFields\", \"secondaryFields\" ]  },  \"itens\" : [ {    \"settlementType\" : \"settlementType\",    \"saleId\" : \"saleId\",    \"authorizationCode\" : \"authorizationCode\",    \"netAmount\" : 5.637376656633329,    \"grossAmount\" : 6.027456183070403,    \"saleDate\" : \"saleDate\",    \"terminal\" : \"terminal\",    \"paymentType\" : \"paymentType\",    \"cardBrandId\" : 0,    \"nsu\" : \"nsu\",    \"settlementTypeId\" : 7,    \"paymentTypeId\" : 2,    \"installments\" : 5,    \"merchantId\" : \"merchantId\",    \"installment\" : 1,    \"cardBrand\" : \"cardBrand\",    \"paymentDate\" : \"paymentDate\",    \"cardNumber\" : \"cardNumber\"  }, {    \"settlementType\" : \"settlementType\",    \"saleId\" : \"saleId\",    \"authorizationCode\" : \"authorizationCode\",    \"netAmount\" : 5.637376656633329,    \"grossAmount\" : 6.027456183070403,    \"saleDate\" : \"saleDate\",    \"terminal\" : \"terminal\",    \"paymentType\" : \"paymentType\",    \"cardBrandId\" : 0,    \"nsu\" : \"nsu\",    \"settlementTypeId\" : 7,    \"paymentTypeId\" : 2,    \"installments\" : 5,    \"merchantId\" : \"merchantId\",    \"installment\" : 1,    \"cardBrand\" : \"cardBrand\",    \"paymentDate\" : \"paymentDate\",    \"cardNumber\" : \"cardNumber\"  } ],  \"idStelo\" : 5}",
                    ReceivableSummaryModel.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ReceivableSummaryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json;charset=UTF-8")) {
            try {
                return new ResponseEntity<ReceivableSummaryModel>(objectMapper.readValue(
                    "{  \"summary\" : {    \"totalAmount\" : 6.027456183070403,    \"totalQuantity\" : 0,    \"totalNetAmount\" : 1.4658129805029452,    \"secondaryFields\" : [ \"secondaryFields\", \"secondaryFields\" ]  },  \"itens\" : [ {    \"settlementType\" : \"settlementType\",    \"saleId\" : \"saleId\",    \"authorizationCode\" : \"authorizationCode\",    \"netAmount\" : 5.637376656633329,    \"grossAmount\" : 6.027456183070403,    \"saleDate\" : \"saleDate\",    \"terminal\" : \"terminal\",    \"paymentType\" : \"paymentType\",    \"cardBrandId\" : 0,    \"nsu\" : \"nsu\",    \"settlementTypeId\" : 7,    \"paymentTypeId\" : 2,    \"installments\" : 5,    \"merchantId\" : \"merchantId\",    \"installment\" : 1,    \"cardBrand\" : \"cardBrand\",    \"paymentDate\" : \"paymentDate\",    \"cardNumber\" : \"cardNumber\"  }, {    \"settlementType\" : \"settlementType\",    \"saleId\" : \"saleId\",    \"authorizationCode\" : \"authorizationCode\",    \"netAmount\" : 5.637376656633329,    \"grossAmount\" : 6.027456183070403,    \"saleDate\" : \"saleDate\",    \"terminal\" : \"terminal\",    \"paymentType\" : \"paymentType\",    \"cardBrandId\" : 0,    \"nsu\" : \"nsu\",    \"settlementTypeId\" : 7,    \"paymentTypeId\" : 2,    \"installments\" : 5,    \"merchantId\" : \"merchantId\",    \"installment\" : 1,    \"cardBrand\" : \"cardBrand\",    \"paymentDate\" : \"paymentDate\",    \"cardNumber\" : \"cardNumber\"  } ],  \"idStelo\" : 5}",
                    ReceivableSummaryModel.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json;charset=UTF-8", e);
                return new ResponseEntity<ReceivableSummaryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ReceivableSummaryModel>(HttpStatus.NOT_IMPLEMENTED);
    }

}
