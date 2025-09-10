package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;

import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    // Controller > Services
    private final ClienteService clienteService;

   public ClienteController(ClienteService service) {
       clienteService = service;

   }

    // Listar todos

    @GetMapping
    public ResponseEntity<List<Cliente>> ListarClientes(){
        // 1. Pegar a lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(
            // Recebe dados pelo corpo
           @RequestBody Cliente cliente
    ) {
       // 1 - Tentar cadastrar o cliente
        clienteService.cadastrarCliente(cliente);

        // Codigo 200 - OK
        // return ResponseEntity.ok(cliente);
        // OU
        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    // Buscar cliente po ID
    //GET
    @GetMapping("/{id}")
    // @PathVariable -> Recebe um valor no link
    // @RequestBody -> Recebe dado pelo corpo
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id){
        // 1 - Proucurar o cliente
        Cliente cliente = clienteService.buscarPorId(id);
        // 2 - Se náo encontrar, retorno um erro
        if(cliente == null){
            // Mais simples
            //return ResponseEntity.notFound().build();
            // OU
            // Mais detalhado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " nao encontrado!");
        }
        // 3 - Se náo encontrar, retorno o Cliente
        return ResponseEntity.ok(cliente);


    }

        // DELETE
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {
            // 1. Verifico se o cliente existe
            Cliente cliente = clienteService.deletarCliente(id);

            // 2. Se não existir retorno erro
            if (cliente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Cliente " + id + " não encontrado!");
            }

            // 3. Se existir, retorno ok
            return ResponseEntity.ok(cliente);
        }


}
