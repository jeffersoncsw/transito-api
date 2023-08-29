package com.jwiltenburg.transito.api.controller;

import com.jwiltenburg.transito.api.controller.data.request.VeiculoRequest;
import com.jwiltenburg.transito.api.controller.data.response.VeiculoResponse;
import com.jwiltenburg.transito.domain.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<?> listar(@PageableDefault(page = 0, size = 10) Pageable page){
        Page<VeiculoResponse> responsePage = veiculoService.listar(page);

        return new ResponseEntity<>(responsePage, HttpStatus.OK);
    }
}
