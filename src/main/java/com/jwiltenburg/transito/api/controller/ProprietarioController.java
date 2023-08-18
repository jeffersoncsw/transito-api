package com.jwiltenburg.transito.api.controller;

import com.jwiltenburg.transito.api.controller.data.request.ProprietarioRequest;
import com.jwiltenburg.transito.api.controller.data.response.ProprietarioResponse;
import com.jwiltenburg.transito.domain.service.impl.ProprietarioServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private ProprietarioServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProprietarioResponse adicionar(@RequestBody @Valid ProprietarioRequest request){
        return service.salvar(request);
    }

}