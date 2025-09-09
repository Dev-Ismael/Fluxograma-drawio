package br.com.ecommerce.api.controller;

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

}
