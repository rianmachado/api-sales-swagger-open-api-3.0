package br.com.rian.sales.api;

import lombok.Getter;

@Getter
public class ApiException extends Exception {

    private static final long serialVersionUID = -354919082074182968L;
    private int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
