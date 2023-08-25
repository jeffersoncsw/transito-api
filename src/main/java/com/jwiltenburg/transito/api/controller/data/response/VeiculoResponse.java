package com.jwiltenburg.transito.api.controller.data.response;

import com.jwiltenburg.transito.domain.model.Proprietario;
import com.jwiltenburg.transito.domain.model.StatusVeiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VeiculoResponse implements Serializable {

    private Long veiculoId;
    private Proprietario proprietario;
    private String marca;
    private String modelo;
    private String placa;
    private StatusVeiculo status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataApreensao;

}
