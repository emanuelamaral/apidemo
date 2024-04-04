package br.edu.utfpr.apidemo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.apidemo.dto.PessoaDTO;
import br.edu.utfpr.apidemo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id) {
        return "Devolvendo pessoa " + id;
    }
    @GetMapping
    public String getAll() {
        return "todas as pessoas";
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PessoaDTO dto) {
        try {
            var res = pessoaService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable("id") String id) {
        return "Atualizar pessoa" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        return "deletar pessoa" + id;
    }
}
