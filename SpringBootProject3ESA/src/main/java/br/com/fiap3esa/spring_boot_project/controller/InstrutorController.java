package br.com.fiap3esa.spring_boot_project.controller;

import br.com.fiap3esa.spring_boot_project.instrutor.DadosCadastroInstrutor;
import br.com.fiap3esa.spring_boot_project.instrutor.DadosListagemInstrutor;
import br.com.fiap3esa.spring_boot_project.instrutor.Instrutor;
import br.com.fiap3esa.spring_boot_project.instrutor.InstrutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    InstrutorRepository repository;

    @PostMapping()
    @Transactional
    public void cadastrarInstrutor(@RequestBody DadosCadastroInstrutor dados) {
        //System.out.println(dados);
        repository.save(new Instrutor(dados));
    }


    @GetMapping
    public List<DadosListagemInstrutor> listarInstrutor(){
        return repository.findAll().stream().map(DadosListagemInstrutor::new).toList();
    }
}