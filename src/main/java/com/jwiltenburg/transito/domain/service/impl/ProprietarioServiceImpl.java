package com.jwiltenburg.transito.domain.service.impl;

import com.jwiltenburg.transito.api.controller.data.request.ProprietarioRequest;
import com.jwiltenburg.transito.api.controller.data.request.ProprietarioUpdateRequest;
import com.jwiltenburg.transito.api.controller.data.response.ProprietarioResponse;
import com.jwiltenburg.transito.api.converter.ProprietarioConverter;
import com.jwiltenburg.transito.domain.exception.BusinessRuleException;
import com.jwiltenburg.transito.domain.exception.ResourceNotFoundException;
import com.jwiltenburg.transito.domain.model.Proprietario;
import com.jwiltenburg.transito.domain.repository.ProprietarioRepository;
import com.jwiltenburg.transito.domain.service.ProprietarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ProprietarioServiceImpl implements ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;
    private final ProprietarioConverter converter;

    @Override
    @Transactional
    public ProprietarioResponse salvar(ProprietarioRequest request) {
        existsEmail(request.getEmail());

        var proprietarioSalvo = proprietarioRepository.save(converter.toProprietarioModel(request));

        return converter.toProprietarioResponse(proprietarioSalvo);
    }

    @Override
    @Transactional
    public Page<ProprietarioResponse> listar(Pageable page) {
        var pages = proprietarioRepository.findAll(page);

        if(pages.isEmpty()){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        return pages.map(proprietario -> converter.toProprietarioResponse(proprietario));
    }

    @Override
    @Transactional
    public ProprietarioResponse buscar(Long proprietarioId) {
        Proprietario proprietario = getProprietarioId(proprietarioId);
        return converter.toProprietarioResponse(proprietario);
    }

    @Override
    @Transactional
    public ProprietarioResponse atualizar(Long proprietarioId, ProprietarioUpdateRequest request) {
        this.existsProprietario(proprietarioId);
        var proprietario = converter.toProprietarioUpdateModel(proprietarioId, request);
        existsEmail(request.getEmail());
        var proprietarioSalvo = proprietarioRepository.saveAndFlush(proprietario);
        return converter.toProprietarioResponse(proprietarioSalvo);
    }

    @Override
    @Transactional
    public void remover(Long proprietarioId) {
        this.existsProprietario(proprietarioId);
        proprietarioRepository.deleteById(proprietarioId);
    }

    private Proprietario getProprietarioId(Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
    }

    private void existsProprietario(Long proprietarioId){
        if(!proprietarioRepository.existsById(proprietarioId)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    private void existsEmail(String email) {
        boolean existEmail = proprietarioRepository.existsByEmail(email);
        if(existEmail){
            throw new BusinessRuleException("Já existe um proprietário cadastrado com este e-mail.");
        }
    }
}
