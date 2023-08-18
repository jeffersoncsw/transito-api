package com.jwiltenburg.transito.api.controller.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProprietarioResponse implements Serializable {

    private Long proprietarioId;
    private String nome;
    private String email;
    private String telefone;

}
