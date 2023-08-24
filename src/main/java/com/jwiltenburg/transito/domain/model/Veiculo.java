package com.jwiltenburg.transito.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    @Column(name = "marca_veiculo", nullable = false)
    private String marca;

    @Column(name = "modelo_veiculo", nullable = false)
    private String modelo;

    @Column(name = "placa_veiculo", nullable = false)
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_veiculo", nullable = false)
    private StatusVeiculo status;

    @Column(name = "data_cadastro_veiculo", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "data_apreensao_veiculo")
    private LocalDateTime dataApreensao;
}
