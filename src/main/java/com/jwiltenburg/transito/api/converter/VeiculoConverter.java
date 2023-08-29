package com.jwiltenburg.transito.api.converter;

import com.jwiltenburg.transito.api.controller.data.request.VeiculoRequest;
import com.jwiltenburg.transito.api.controller.data.response.VeiculoResponse;
import com.jwiltenburg.transito.domain.model.StatusVeiculo;
import com.jwiltenburg.transito.domain.model.Veiculo;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Generated
@RequiredArgsConstructor
public class VeiculoConverter {

    public Veiculo toVeiculoModel(VeiculoRequest request){
        return Veiculo.builder()
                .proprietario(request.getProprietarioId())
                .marca(request.getMarca())
                .modelo(request.getModelo())
                .placa(request.getPlaca())
                .status(StatusVeiculo.REGULAR)
                .dataCadastro(LocalDateTime.now())
                .build();
    }

    public VeiculoResponse toVeiculoResponse(Veiculo veiculo) {
        return VeiculoResponse.builder()
                .veiculoId(veiculo.getId())
                .proprietario(veiculo.getProprietario())
                .marca(veiculo.getMarca())
                .modelo(veiculo.getModelo())
                .placa(veiculo.getPlaca())
                .status(veiculo.getStatus())
                .dataCadastro(veiculo.getDataCadastro())
                .dataApreensao(veiculo.getDataApreensao())
                .build();
    }
}