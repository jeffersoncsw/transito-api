package com.jwiltenburg.transito.domain.service;

import com.jwiltenburg.transito.api.controller.data.request.VeiculoRequest;
import com.jwiltenburg.transito.api.controller.data.response.VeiculoResponse;

public interface VeiculoService {
    VeiculoResponse salvar(VeiculoRequest request);

}
