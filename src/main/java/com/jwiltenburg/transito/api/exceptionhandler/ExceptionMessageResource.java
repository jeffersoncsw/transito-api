package com.jwiltenburg.transito.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ExceptionMessageResource {
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campo;

    @AllArgsConstructor
    @Getter
    public static class Campo {

        private String nome;
        private String mensagem;
    }
}
