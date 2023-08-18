package com.jwiltenburg.transito.domain.service.impl;

import com.jwiltenburg.transito.api.controller.data.request.ProprietarioRequest;
import com.jwiltenburg.transito.api.controller.data.response.ProprietarioResponse;
import com.jwiltenburg.transito.api.converter.ProprietarioConverter;
import com.jwiltenburg.transito.domain.exception.ResourceNotFoundException;
import com.jwiltenburg.transito.domain.repository.ProprietarioRepository;
import com.jwiltenburg.transito.domain.service.ProprietarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProprietarioServiceImpl implements ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;
    private final ProprietarioConverter converter;
    @Override
    public ProprietarioResponse salvar(ProprietarioRequest request) {
        var proprietarioSalvo = proprietarioRepository.save(converter.toProprietarioModel(request));

        return converter.toProprietarioResponse(proprietarioSalvo);
    }

    @Override
    public Page<ProprietarioResponse> listar(Pageable page) {
        var pages = proprietarioRepository.findAll(page);

        if(pages.isEmpty()){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        return pages.map(proprietario -> converter.toProprietarioResponse(proprietario));
    }
}
