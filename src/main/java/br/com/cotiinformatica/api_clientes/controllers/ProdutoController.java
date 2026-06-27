package br.com.cotiinformatica.api_clientes.controllers;

import br.com.cotiinformatica.api_clientes.entities.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @GetMapping("consultar")
    public String consultar() {
       return "Consulta realizada com sucesso!";
    }
}
