package br.com.sicredi.assembleia.infrastructure.database.presentation;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pauta {

    @Id
    @Column(name = "ID", nullable = false, columnDefinition = "decimal(3,0)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private int status;
    private String descricao;
    private LocalDateTime horaInicio = LocalDateTime.now();
    private LocalDateTime horaFim = LocalDateTime.now();
}
