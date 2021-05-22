package com.api.workslog.domain.exception;

public class NegocioException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public NegocioException(String mensagem) {
        super(mensagem);
    }

}
