package br.edu.utfpr.apidemo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.apidemo.dto.PessoaDTO;
import br.edu.utfpr.apidemo.model.Pessoa;
import br.edu.utfpr.apidemo.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @SuppressWarnings("null")
    public Pessoa create(PessoaDTO dto) {
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(dto, pessoa);

        return pessoaRepository.save(pessoa);
    }
}
