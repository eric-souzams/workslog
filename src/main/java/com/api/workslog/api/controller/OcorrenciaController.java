package com.api.workslog.api.controller;

import com.api.workslog.api.assembler.OcorrenciaAssemble;
import com.api.workslog.api.model.OcorrenciaModel;
import com.api.workslog.api.model.input.OcorrenciaInput;
import com.api.workslog.domain.model.Entrega;
import com.api.workslog.domain.model.Ocorrencia;
import com.api.workslog.domain.service.BuscaEntregaService;
import com.api.workslog.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssemble ocorrenciaAssemble;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
        Ocorrencia ocorrenciaRegitrada = registroOcorrenciaService
                                            .resgistrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssemble.toModel(ocorrenciaRegitrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssemble.toCollectionModel(entrega.getOcorrencias());
    }

}
