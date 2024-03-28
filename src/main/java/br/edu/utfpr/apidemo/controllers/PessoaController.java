package br.edu.utfpr.apidemo.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.apidemo.model.Pessoa;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id) {
        return "Devolvendo pessoa " + id;
    }
    @GetMapping
    public String getAll() {
        return "todas as pessoas";
    }
    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        System.out.println(pessoa);
        pessoa.setId(UUID.randomUUID());
        return pessoa;
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
