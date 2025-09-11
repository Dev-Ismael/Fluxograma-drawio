package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    // Injecao de dependencia
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository repo) {
        produtoRepository = repo;
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto cadastrarProduto(Produto prod){
        return produtoRepository.save(prod);
    }

    // Metodo de buscar por id
    public Produto buscarPorId(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }

    // Metodo para Deletar Por Id
    public Produto deleteProduto(Integer id){
        // 1 - Verifica se o cliente existe
        Produto produto = buscarPorId(id);

        // 2 - Se náo existir, retorno nullo
        if(produto == null){
            return null;
        }

        // 3 - Se existir, excluo
        produtoRepository.delete(produto);
        return produto;
    }


}
