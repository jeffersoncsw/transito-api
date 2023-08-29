package com.jwiltenburg.transito.api.controller;

import com.jwiltenburg.transito.api.controller.data.request.VeiculoRequest;
import com.jwiltenburg.transito.api.controller.data.response.VeiculoResponse;
import com.jwiltenburg.transito.domain.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoResponse adicionar(@RequestBody @Valid VeiculoRequest request){
        return veiculoService.salvar(request);
    }
}
