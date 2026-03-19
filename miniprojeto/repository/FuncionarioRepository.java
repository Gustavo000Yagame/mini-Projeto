package org.example.miniprojeto.repository;

import org.example.miniprojeto.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByEmail(String email);
    List<Funcionario> findByNomeContainingIgnoreCase(String nome);
    List<Funcionario> findBySalario(Double valor);
    List<Funcionario> findBySalarioGreaterThan(Double valor);
}
