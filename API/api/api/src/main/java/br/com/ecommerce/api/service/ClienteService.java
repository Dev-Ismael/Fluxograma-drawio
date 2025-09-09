package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Avisa o SPRING que e um servico
public class ClienteService {
    // Injecao de dependencia
    // Falar que services depende de alguem
    // fianl - constante
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo) {
        clienteRepository = repo;
    }

    // Metodo de Listar todos os cliente
    // List e melhor que array pq nao tem limite
    // Vetor nao e uma lista, pois possui limite
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(Cliente cl){
        return clienteRepository.save(cl);
    }
}
