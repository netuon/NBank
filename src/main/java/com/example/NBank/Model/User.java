package com.example.NBank.Model;

import com.example.NBank.Model.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private int cpf;
    private String nome;
    private LocalDate dataDeNascimento;
    private String email;
    private String senha;
    @OneToOne(mappedBy = "user")
    private Account conta;
}
