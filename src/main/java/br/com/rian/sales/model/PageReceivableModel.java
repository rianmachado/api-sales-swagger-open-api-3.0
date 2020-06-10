package br.com.rian.sales.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PageReceivableModel
 */
@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageReceivableModel {
    @JsonProperty("content")
    @Valid
    private List<Receivable> content = null;

    @JsonProperty("empty")
    private Boolean empty = null;

    @JsonProperty("first")
    private Boolean first = null;

    @JsonProperty("last")
    private Boolean last = null;

    @JsonProperty("number")
    private Integer number = null;

    @JsonProperty("numberOfElements")
    private Integer numberOfElements = null;

    @JsonProperty("pageable")
    private Pageable pageable = null;

    @JsonProperty("size")
    private Integer size = null;

    @JsonProperty("sort")
    private Sort sort = null;

    @JsonProperty("totalElements")
    private Long totalElements = null;

    @JsonProperty("totalPages")
    private Integer totalPages = null;

    public PageReceivableModel content(List<Receivable> content) {
        this.content = content;
        return this;
    }

    public PageReceivableModel addContentItem(Receivable contentItem) {
        if (this.content == null) {
            this.content = new ArrayList<Receivable>();
        }
        this.content.add(contentItem);
        return this;
    }

}
