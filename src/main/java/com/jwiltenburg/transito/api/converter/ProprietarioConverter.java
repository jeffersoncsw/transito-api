package com.jwiltenburg.transito.api.converter;

import com.jwiltenburg.transito.api.controller.data.request.ProprietarioRequest;
import com.jwiltenburg.transito.api.controller.data.response.ProprietarioResponse;
import com.jwiltenburg.transito.domain.model.Proprietario;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Generated
@RequiredArgsConstructor
public class ProprietarioConverter {

    public Proprietario toProprietarioModel(ProprietarioRequest request){
        return Proprietario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .telefone(request.getTelefone())
                .build();
    }

    public ProprietarioResponse toProprietarioResponse(Proprietario proprietario) {
        return ProprietarioResponse.builder()
                .proprietarioId(proprietario.getId())
                .nome(proprietario.getNome())
                .email(proprietario.getEmail())
                .telefone(proprietario.getTelefone())
                .build();
    }
}
