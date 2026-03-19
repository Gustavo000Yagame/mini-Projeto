package org.example.miniprojeto.controller;

import jakarta.validation.Valid;
import org.example.miniprojeto.model.Funcionario;
import org.example.miniprojeto.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")

public class FuncionarioController{
    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Funcionario> listar() {
        return service.listar();
    }


    @PostMapping
    public Funcionario criar(@RequestBody @Valid Funcionario funcionario) {
        return service.salvarFuncionario(funcionario);
    }


    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable Long id) {
        return service.buscar(id);
    }


    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
        funcionario.setId(id);
        return service.salvarFuncionario(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @GetMapping("/buscar")
    public List<Funcionario> buscarPorNome(@RequestParam String nome){
        return service.buscarPorNome(nome);
    }

    @GetMapping("/salario")
    public List<Funcionario> buscarPorSalario(@RequestParam Double valor) {
        return service.buscarPorSalario(valor);
    }

    @GetMapping("/salariomaior")
    public List<Funcionario> buscarMaior(@RequestParam Double salario) {
        return service.buscarSalarioMaiorQue(salario);
    }

}

