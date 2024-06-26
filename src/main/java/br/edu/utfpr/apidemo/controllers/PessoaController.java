package br.edu.utfpr.apidemo.controllers;


import java.util.List;

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
import br.edu.utfpr.apidemo.exceptions.NotFoundException;
import br.edu.utfpr.apidemo.model.Pessoa;
import br.edu.utfpr.apidemo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PessoaDTO dto) {
        try {
            var res = pessoaService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Pessoa> getAll() {
        return pessoaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") long id) {
        var person = pessoaService.getById(id);
        return person.isPresent()
            ? ResponseEntity.ok().body(person.get())
            : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") long id, @RequestBody PessoaDTO dto) {
        try {
            return ResponseEntity.ok().body(pessoaService.update(id, dto));
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        try {
            pessoaService.delete(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
