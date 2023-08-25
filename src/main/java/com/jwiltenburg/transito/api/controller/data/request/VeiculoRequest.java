package com.jwiltenburg.transito.api.controller.data.request;

import com.jwiltenburg.transito.domain.model.Proprietario;
import com.jwiltenburg.transito.domain.model.StatusVeiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class VeiculoRequest implements Serializable {

    private Proprietario proprietarioId;

    @NotBlank
    @Size(max = 20)
    private String marca;

    @NotBlank
    @Size(max = 20)
    private String modelo;

    @NotBlank
    @Size(max = 7)
    private String placa;

    private StatusVeiculo status;

    private LocalDateTime dataCadastro;

}
