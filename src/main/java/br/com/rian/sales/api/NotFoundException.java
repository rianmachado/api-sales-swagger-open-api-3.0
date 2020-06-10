package br.com.rian.sales.api;

import lombok.Getter;

@Getter
public class NotFoundException extends ApiException {
    /**
     * 
     */
    private static final long serialVersionUID = -5741364257087119906L;
    private int code;

    public NotFoundException(int code, String msg) {
        super(code, msg);
        this.code = code;
    }

}
