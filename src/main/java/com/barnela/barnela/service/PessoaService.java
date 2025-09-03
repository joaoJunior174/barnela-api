package com.barnela.barnela.service;


import com.barnela.barnela.dto.PessoaRequest;
import com.barnela.barnela.model.Pessoa;
import com.barnela.barnela.model.Presente;
import com.barnela.barnela.repository.PessoaRepository;
import com.barnela.barnela.repository.PresenteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PresenteRepository presenteRepository;

    public PessoaService(PessoaRepository pessoaRepository, PresenteRepository presenteRepository) {
        this.pessoaRepository = pessoaRepository;
        this.presenteRepository = presenteRepository;
    }

    public void salvar(PessoaRequest request) {

        request.getPresentes().forEach(presente -> {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(request.getNome());
            pessoa.setPresente(presente);
            pessoa.setTelefone(request.getTelefone());
            pessoaRepository.save(pessoa);
            Presente presenteSalva = presenteRepository.findByNome(presente).get();
            presenteSalva.setPessoaId(request.getNome());
            presenteSalva.setEscolhido(1);
            presenteRepository.save(presenteSalva);
        });
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public List<String> buscarPresentes() {
        List<Presente> presentes = presenteRepository.findAll();

        List<String> presentesFiltrado = new ArrayList<>();

        presentes.forEach(presente -> {
            if (Objects.isNull(presente.getEscolhido())) {
                presentesFiltrado.add("<li><div class=\"form-check\"><input class=\"form-check-input\" type=\"checkbox\" value=\"" + transform(presente.getNome()) + "\" id=\"" + transform(presente.getNome()) + "\"><label class=\"form-check-label\" for=\"" + transform(presente.getNome()) + "\">" + presente.getNome() + "</label></div></li>");
            }
        });

        return presentesFiltrado;

    }

    public String transform(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }
}

