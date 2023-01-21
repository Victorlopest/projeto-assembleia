package br.com.sicredi.assembleia.infrastructure.database.presentation;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Votacao {

    @Id
    @Column(name = "ID", nullable = false, columnDefinition = "decimal(3,0)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long usuarioId;
    private Long pautaId;
    private int quantidadeSim;
    private int quantidadeNao;
//
//    private LocalDateTime horaInicio = LocalDateTime.now();
//    private LocalDateTime horafim = horaInicio.plusMinutes(1);
}
