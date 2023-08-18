package com.jwiltenburg.transito.domain.service;

import com.jwiltenburg.transito.api.controller.data.request.ProprietarioRequest;
import com.jwiltenburg.transito.api.controller.data.response.ProprietarioResponse;

public interface ProprietarioService {

    ProprietarioResponse salvar(ProprietarioRequest request);

}
