package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.service.ItemDoPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ItensDoPedido")
public class ItemDoPedidoController {

    private final ItemDoPedidoService itemDoPedidoService;

    public ItemDoPedidoController(ItemDoPedidoService service) {
        itemDoPedidoService = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemDoPedido>> listarItens() {
        List<ItemDoPedido> itens = itemDoPedidoService.listarTodos();

        return ResponseEntity.ok(itens);
    }

    @PostMapping
    public ResponseEntity<ItemDoPedido> cadastrarItem(
            @RequestBody ItemDoPedido itemDoPedido
    ){
        itemDoPedidoService.cadastrarItem(itemDoPedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemDoPedido);
    }
}
