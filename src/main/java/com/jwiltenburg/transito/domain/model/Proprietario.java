package com.jwiltenburg.transito.domain.model;

import com.jwiltenburg.transito.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_proprietario")
public class Proprietario {

    @NotNull(groups = ValidationGroups.ProprietarioId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proprietario", nullable = false)
    private Long id;

    @Column(name = "nome_proprietario", nullable = false)
    private String nome;

    @Column(name = "email_proprietario", nullable = false)
    private String email;

    @Column(name = "telefone_proprietario", nullable = false)
    private String telefone;
}
