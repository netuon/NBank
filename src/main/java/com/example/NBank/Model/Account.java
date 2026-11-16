package com.example.NBank.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Contas")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numeroDaConta;
    @OneToOne
    @JoinColumn(name = "user_cpf", unique = true)
    private User user;
    private String nomeTitular;
    private Float saldo;
}
