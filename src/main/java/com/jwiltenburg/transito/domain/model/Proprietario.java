package com.jwiltenburg.transito.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_proprietario")
public class Proprietario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proprietario", nullable = false)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nome_proprietario", nullable = false)
    private String nome;

    @NotBlank
    @Size(max = 255)
    @Email
    @Column(name = "email_proprietario", nullable = false)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "telefone_proprietario", nullable = false)
    private String telefone;
}
