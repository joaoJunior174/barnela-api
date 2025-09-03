package com.barnela.barnela.controller;

import com.barnela.barnela.dto.PessoaRequest;
import com.barnela.barnela.model.Pessoa;
import com.barnela.barnela.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody PessoaRequest request) {
        pessoaService.salvar(request);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        return ResponseEntity.ok(pessoaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.buscarPorId(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/presentes")
    public List<String> buscarPresentes() {
        return pessoaService.buscarPresentes();
    }
}

