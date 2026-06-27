package br.com.cotiinformatica.api_clientes.controllers;

import br.com.cotiinformatica.api_clientes.dtos.ClienteDto;
import br.com.cotiinformatica.api_clientes.entities.Cliente;
import br.com.cotiinformatica.api_clientes.enums.StatusCliente;
import br.com.cotiinformatica.api_clientes.enums.TipoCliente;
import br.com.cotiinformatica.api_clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("criar")
    public String criar(@RequestBody ClienteDto dto) {
        try {

            var cliente = new Cliente();

            cliente.setNome(dto.getNome());
            cliente.setEmail(dto.getEmail());
            cliente.setTelefone(dto.getTelefone());
            cliente.setTipo(TipoCliente.valueOf(dto.getTipo()));
            cliente.setStatus(StatusCliente.ATIVO);

            clienteRepository.create(cliente);

            return "Cliente '" + cliente.getNome() + "' cadastrado com sucesso.";
        }
        catch(Exception e) {
            return "Falha ao cadastrar o cliente: " + e.getMessage();
        }
    }

    @GetMapping("consultar")
    public List<Cliente> consultar() {
        try {
            return clienteRepository.findAll();
        }
        catch(Exception e) {
            e.printStackTrace(); //imprimir o erro no log do servidor
            return null;
        }
    }

    @PutMapping("atualizar/{id}")
    public String atualizar(@PathVariable Integer id, @RequestBody ClienteDto dto) {
        try {

            var cliente = new Cliente();

            cliente.setId(id);
            cliente.setNome(dto.getNome());
            cliente.setEmail(dto.getEmail());
            cliente.setTelefone(dto.getTelefone());
            cliente.setTipo(TipoCliente.valueOf(dto.getTipo()));

            if(clienteRepository.update(cliente)) {
                return "Cliente atualizado com sucesso.";
            }
            else {
                return "Nenhum cliente foi encontrado para edição. Verifique o ID informado.";
            }
        }
        catch(Exception e) {
            return "Falha ao atualizar cliente: " + e.getMessage();
        }
    }

    @DeleteMapping("excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        try {
            if(clienteRepository.delete(id)) {
                return "Cliente excluído com sucesso.";
            }
            else {
                return "Nenhum cliente foi encontrado para exclusão. Verifique o ID informado.";
            }
        }
        catch(Exception e) {
            return "Falha ao excluir o cliente: " + e.getMessage();
        }
    }

    @GetMapping("obter/{id}")
    public Cliente obter(@PathVariable Integer id) {
        try {
            return clienteRepository.findById(id);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
