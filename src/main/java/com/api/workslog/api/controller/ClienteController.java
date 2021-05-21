package com.api.workslog.api.controller;

import com.api.workslog.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> list() {

        var c1 = new Cliente();
        c1.setId(1L);
        c1.setEmail("junio1@gmail.com");
        c1.setNome("Junio Silva");
        c1.setTelefone("999999999");

        var c2 = new Cliente();
        c2.setId(2L);
        c2.setEmail("pedrin@gmail.com");
        c2.setNome("Pedro Souza");
        c2.setTelefone("8888999779");

        return Arrays.asList(c1, c2);
    }

}
