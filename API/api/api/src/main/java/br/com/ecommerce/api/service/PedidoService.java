package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository repo) {
        pedidoRepository = repo;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido cadastrarPedido(Pedido p){
        return pedidoRepository.save(p);
    }

    // Metodo para bucar por id
    public Pedido buscarPorId(int id){
        return pedidoRepository.findById(id).orElse(null);
    }

    //metodo deletar por ID
    public Pedido deletePedido(int id){
        // 1 - Verifico se o pedido existe
        Pedido pedido = buscarPorId(id);
        // 2 - Se náo existir, retorno nullo
        if (pedido == null){
            return null;
        }
        // 3 - Se existir, excluo
        pedidoRepository.delete(pedido);
        return pedido;
    }
}
