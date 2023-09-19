package com.jwiltenburg.transito.api.controller.data.request;

import com.jwiltenburg.transito.domain.model.Proprietario;
import com.jwiltenburg.transito.domain.model.StatusVeiculo;
import com.jwiltenburg.transito.domain.validation.ValidationGroups;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class VeiculoRequest implements Serializable {

    @Valid
    @ConvertGroup(to = ValidationGroups.ProprietarioId.class)
    @NotNull
    private Proprietario proprietarioId;

    @NotBlank
    @Size(max = 20)
    private String marca;

    @NotBlank
    @Size(max = 20)
    private String modelo;

    @NotBlank
    @Size(max = 7)
    @Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
    private String placa;

    private StatusVeiculo status;

    private LocalDateTime dataCadastro;

}
