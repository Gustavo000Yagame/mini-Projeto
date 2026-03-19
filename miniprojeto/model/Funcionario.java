package org.example.miniprojeto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBFuncionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha o nome Valido!! (O nome não pode ficar vazio)!")
    private String nome;

    @NotBlank(message = "O cargo não pode ficar vazio!!")
    private String cargo;

    @Email(message = "Digite um Email valido!!")
    @Column (nullable = false, unique = true)
    private String email;

    @Positive(message = "Digite um salario positivo!!")
    private double salario;

    public Funcionario(){}
}
