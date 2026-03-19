package org.example.miniprojeto.service;


import org.example.miniprojeto.model.Funcionario;
import org.example.miniprojeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@Service
public class FuncionarioService {

    @Autowired
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado!"));
    }

    public List<Funcionario> listar() {
        return repository.findAll();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Funcionario> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }


    public List<Funcionario> buscarPorSalario (Double salario){
        return repository.findBySalario(salario);
    }
    public List<Funcionario> buscarSalarioMaiorQue (Double salario){
        return repository.findBySalarioGreaterThan(salario);
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {

        if (repository.existsByEmail(funcionario.getEmail())) {
            throw new RuntimeException("Email já cadastrado!!");
        }
        repository.save(funcionario);
        return funcionario;
    }
}