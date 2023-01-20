package br.com.sicredi.assembleia.infrastructure.database.presentation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private int status;
    private int quantidadeSim;
    private int quantidadeNao;
    private String descricao;

    private LocalDateTime horaInicio;
    private LocalDateTime horafim;
}
