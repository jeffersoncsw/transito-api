package com.jwiltenburg.transito.domain.service;

import com.jwiltenburg.transito.api.controller.data.request.ProprietarioRequest;
import com.jwiltenburg.transito.api.controller.data.response.ProprietarioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProprietarioService {

    ProprietarioResponse salvar(ProprietarioRequest request);
    Page<ProprietarioResponse> listar(Pageable page);

}
