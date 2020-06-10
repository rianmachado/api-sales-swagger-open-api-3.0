package br.com.rian.sales.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ReceivableModel
 */
@Validated
@QueryEntity
@Document("receivable")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Receivable {

    @Id
    private String id;

    @JsonProperty("authorizationCode")
    private String authorizationCode = null;

    @JsonProperty("cardBrand")
    private String cardBrand = null;

    @JsonProperty("cardBrandId")
    private Integer cardBrandId = null;

    @JsonProperty("cardNumber")
    private String cardNumber = null;

    @JsonProperty("grossAmount")
    private Double grossAmount = null;

    @JsonProperty("installment")
    private Integer installment = null;

    @JsonProperty("installments")
    private Integer installments = null;

    @JsonProperty("merchantId")
    @Indexed(direction = IndexDirection.ASCENDING)
    private Long merchantId = null;

    @JsonProperty("netAmount")
    private Double netAmount = null;

    @JsonProperty("nsu")
    private String nsu = null;

    @JsonProperty("paymentDate")
    private String paymentDate = null;

    @JsonProperty("paymentType")
    private String paymentType = null;

    @JsonProperty("paymentTypeId")
    private Integer paymentTypeId = null;

    @JsonProperty("saleDate")
    private String saleDate = null;

    @JsonProperty("saleId")
    private String saleId = null;

    @JsonProperty("terminal")
    private String terminal = null;

    @JsonProperty("settlementTypeId")
    private Integer settlementTypeId = null;

    @JsonProperty("settlementType")
    private String settlementType = null;

    private LocalDateTime paymentScheduleDate;

}
