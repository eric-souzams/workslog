package com.api.workslog.api.controller;

import com.api.workslog.domain.model.Entrega;
import com.api.workslog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega criar(@RequestBody Entrega entrega) {
        return solicitacaoEntregaService.solicitar(entrega);
    }

}
