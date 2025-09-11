package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository repo) {
        pagamentoRepository = repo;
    }

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento cadastrarPagamento(Pagamento pag){
        return pagamentoRepository.save(pag);
    }

    // Metodo para buscar por ID
    public Pagamento buscarPorId(Integer id){
        return pagamentoRepository.findById(id).orElse(null);
    }

    // Metodo para deletar por Id
    public Pagamento deletarPorId(Integer id){
        // 1 - Verifica se o pagamento existe
        Pagamento pagamento = buscarPorId(id);
        // 2 - Se náo existir, retorno nullo
        if (pagamento == null){
            return null;
        }
        // 3 - Se existir, excluo
        pagamentoRepository.delete(pagamento);
        return pagamento;

    }
}
