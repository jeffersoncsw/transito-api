package com.jwiltenburg.transito.api.controller;

import com.jwiltenburg.transito.api.controller.data.request.ProprietarioRequest;
import com.jwiltenburg.transito.api.controller.data.response.ProprietarioResponse;
import com.jwiltenburg.transito.domain.service.ProprietarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProprietarioResponse adicionar(@RequestBody @Valid ProprietarioRequest request){
        return proprietarioService.salvar(request);
    }

    @GetMapping
    public ResponseEntity<?> listar(@PageableDefault(page = 0, size = 10) Pageable page){
        var response = proprietarioService.listar(page);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{proprietarioId}")
    public ProprietarioResponse buscar(@PathVariable Long proprietarioId){
        return proprietarioService.buscar(proprietarioId);
    }

    @PutMapping("/{proprietarioId}")
    public ProprietarioResponse atualizar(@PathVariable Long proprietarioId, @RequestBody @Valid ProprietarioRequest request){
        return proprietarioService.atualizar(proprietarioId, request);
    }

    @DeleteMapping("/{proprietarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long proprietarioId){
        proprietarioService.remover(proprietarioId);
    }

}
