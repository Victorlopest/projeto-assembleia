package br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "VOTACAO_PAUTA")
public class Votacao implements Serializable {

    @Id
    @ApiModelProperty(value = "Id da Votação", name = "votacaoId", example = "1")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long votacaoId;

    @ApiModelProperty(value = "CPF do Usário que vai votar na pauta", name = "usuarioCpf", example = "12345678910")
    @Column(name = "USUARIO_CPF", nullable = false, updatable = false)
    private String usuarioCpf;

    @ApiModelProperty(value = "Pauta relacionada a votação", name = "pauta")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_PAUTA", referencedColumnName = "CODIGO_PAUTA")
    private Pauta pauta;

    @ApiModelProperty(value = "Voto na pauta", name = "voto", example = "1 para sim, 2 para não")
    @Column(name = "VOTO", nullable = false, updatable = false)
    private Integer voto;

}
