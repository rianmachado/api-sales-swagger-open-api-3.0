package br.com.rian.sales.exceptions;

import org.springframework.http.HttpStatus;

public class ApiSalesException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApiSalesException(String message) {
        super(message);
    }

    public ApiSalesException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getErrorCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
