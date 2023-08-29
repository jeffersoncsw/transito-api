package com.jwiltenburg.transito.domain.service;

import com.jwiltenburg.transito.api.controller.data.request.VeiculoRequest;
import com.jwiltenburg.transito.api.controller.data.response.VeiculoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VeiculoService {
    VeiculoResponse salvar(VeiculoRequest request);
    Page<VeiculoResponse> listar(Pageable page);
    VeiculoResponse buscar(Long veiculoId);

}
