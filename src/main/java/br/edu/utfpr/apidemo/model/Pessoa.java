package br.edu.utfpr.apidemo.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    
    private UUID id;
    private String nome;
    private String email;
    private String senha;

    
}