package com.api.workslog.domain.service;

import com.api.workslog.domain.exception.NegocioException;
import com.api.workslog.domain.model.Cliente;
import com.api.workslog.domain.model.Entrega;
import com.api.workslog.domain.model.StatusEntrega;
import com.api.workslog.domain.repository.ClienteRepository;
import com.api.workslog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        entrega.setCliente(cliente);

        return entregaRepository.save(entrega);
    }

}
