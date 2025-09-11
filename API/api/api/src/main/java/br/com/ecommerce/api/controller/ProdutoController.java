package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService services) {
        produtoService = services;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> ListarProdutos(){
        List<Produto> produtos = produtoService.listarTodos();

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(
            @RequestBody Produto produto
    ){
       // 1 - Tentar cadastrar o produto
       produtoService.cadastrarProduto(produto);

        // Codigo 200 - OK
        // return ResponseEntity.ok(produto);
        // OU
        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    // Buscar Produto por ID
    @GetMapping("/{id}")

    public ResponseEntity<?> buscarProduto(@PathVariable Integer id){
        // 1 - Proucura o produto
        Produto produto = produtoService.buscarPorId(id);
        // 2 - Se náo encontrar o cliente, retorno o erro
        if(produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto " + id + " nao encontrado!");
        }
        // 3 - Se existir, retorno ok
        return ResponseEntity.ok(produto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Integer id){
        // 1 - Verifico se o cliente existe
        Produto produto = produtoService.deleteProduto(id);
        // 2 - Se náo existir retorno erro
        if(produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto " + id + " nao encontrado!");
        }
        // 3 - Se existir, retorno ok
        return ResponseEntity.ok(produto);
    }

}
