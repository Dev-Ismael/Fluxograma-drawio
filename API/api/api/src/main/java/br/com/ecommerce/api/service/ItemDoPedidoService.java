package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.repository.ItemDoPedidoRepository;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDoPedidoService {
    // Injecao de dependencia
    private final ItemDoPedidoRepository itemDoPedidoRepository;
    private final PagamentoRepository pagamentoRepository;

    public ItemDoPedidoService(ItemDoPedidoRepository repo, PagamentoRepository pagamentoRepository) {
        itemDoPedidoRepository = repo;
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<ItemDoPedido> listarTodos(){
        return itemDoPedidoRepository.findAll();
    }

    public ItemDoPedido cadastrarItem(ItemDoPedido item){
        return itemDoPedidoRepository.save(item);
    }

    // Metodo para buscar por id
    public ItemDoPedido buscarPorId(Integer id){
        return itemDoPedidoRepository.findById(id).orElse(null);
    }

    // Metodo para deletar por id
    public ItemDoPedido deletarItem(Integer id){
        // 1 - Verifica se o Item existe
        ItemDoPedido itemDoPedido = buscarPorId(id);
        // 2 - Se náo existir, retorno nullo
        if (itemDoPedido == null){
            return null;
        }
        // 3 - Se existir, excluo
        itemDoPedidoRepository.delete(itemDoPedido);
        return itemDoPedido;
    }
}
