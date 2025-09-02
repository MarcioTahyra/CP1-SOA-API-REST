package br.com.fiap3esa.spring_boot_project.controller;

import br.com.fiap3esa.spring_boot_project.aluno.AlunoRepository;
import br.com.fiap3esa.spring_boot_project.aluno.DadosCadastroAluno;
import br.com.fiap3esa.spring_boot_project.aluno.DadosListagemAluno;
import br.com.fiap3esa.spring_boot_project.aluno.Aluno;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @PostMapping()
    @Transactional
    public void cadastrarAluno(@RequestBody DadosCadastroAluno dados) {
        //System.out.println(dados);
        repository.save(new Aluno(dados));
    }


    @GetMapping
    public List<DadosListagemAluno> listarAluno(){
        return repository.findAll().stream().map(DadosListagemAluno::new).toList();
    }
}