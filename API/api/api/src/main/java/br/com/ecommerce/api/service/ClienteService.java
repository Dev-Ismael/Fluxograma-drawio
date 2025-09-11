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

    // Metodo cadastrar cliente
    public Cliente cadastrarCliente(Cliente cl){
        return clienteRepository.save(cl);
    }

    // Metodo buscar cliente por ID
    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente deletarCliente(Integer id){
        // 1 - Verifico se o cliente existe
        Cliente cliente = buscarPorId(id);

        // 2 - Se náo existir, retorno nullo
        if (cliente == null){
            return null;
        }

        // 3 - Se existir, excluo
        clienteRepository.delete(cliente);
        return cliente;
    }

    public Cliente atualizarCliente(Integer id, Cliente clienteNovo) {
        // 1. Procurar quem eu quero atualizar
        Cliente clienteAntigo = buscarPorId(id);

        // 2. Se eu não achar, retorno nulo
        if (clienteAntigo == null) {
            return null;
        }

        // 3. Se eu achar eu atualizo
        clienteAntigo.setSenha(clienteNovo.getSenha());
        clienteAntigo.setNomeCompleto(clienteNovo.getNomeCompleto());
        clienteAntigo.setDataCadastro(clienteNovo.getDataCadastro());
        clienteAntigo.setTelefone(clienteNovo.getTelefone());
        return clienteRepository.save(clienteAntigo);
    }
}
