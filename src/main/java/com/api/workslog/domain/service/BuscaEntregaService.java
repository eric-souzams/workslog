package com.api.workslog.domain.service;

import com.api.workslog.domain.exception.EntidadeNaoEncontradaException;
import com.api.workslog.domain.model.Entrega;
import com.api.workslog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada."));
    }

}
