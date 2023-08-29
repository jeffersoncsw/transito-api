package com.jwiltenburg.transito.domain.service.impl;

import com.jwiltenburg.transito.api.controller.data.request.VeiculoRequest;
import com.jwiltenburg.transito.api.controller.data.response.VeiculoResponse;
import com.jwiltenburg.transito.api.converter.VeiculoConverter;
import com.jwiltenburg.transito.domain.repository.VeiculoRepository;
import com.jwiltenburg.transito.domain.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoConverter converter;
    @Override
    @Transactional
    public VeiculoResponse salvar(VeiculoRequest request) {

        var veiculoSalvo = veiculoRepository.save(converter.toVeiculoModel(request));

        return converter.toVeiculoResponse(veiculoSalvo);
    }
}
