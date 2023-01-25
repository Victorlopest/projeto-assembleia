package br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "PAUTA")
@NoArgsConstructor
public class Pauta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO_PAUTA", nullable = false, columnDefinition = "decimal(3,0)", unique = true)
    @ApiModelProperty(value = "Id da Pauta", name = "pautaId", example = "1")
    private Long pautaId;

    @ApiModelProperty(value = "Titulo da Pauta", name = "pautaId", example = "Titulo 1")
    @Column(name = "TITULO", length = 50, nullable = false)
    private String titulo;

    @ApiModelProperty(value = "Status da Pauta", name = "status", example = "FECHADA")
    @Column(name = "STATUS", nullable = false)
    private String status = "FECHADA";

    @ApiModelProperty(value = "Descrição da Pauta", name = "descricao", example = "Descrição 1")
    @Column(name = "DESCRICAO", length = 10000, nullable = false)
    private String descricao;

    @ApiModelProperty(value = "Hora de Abertura da Pauta", name = "horaAbertura")
    @Column(name = "HORA_ABERTURA", nullable = false)
    private LocalDateTime horaAbertura = LocalDateTime.now();

    @ApiModelProperty(value = "Hora de fechamento da Pauta", name = "horaFechamento")
    @Column(name = "HORA_FECHAMENTO", nullable = false)
    private LocalDateTime horaFechamento = LocalDateTime.now();


    @ApiModelProperty(value = "Quantidade de votos Sim da Pauta", name = "quantidadeVotosSim", example = "20")
    @Column(name = "QTD_SIM", nullable = false)
    private int quantidadeVotosSim;

    @ApiModelProperty(value = "Quantidade de votos Não da Pauta", name = "quantidadeVotosNao", example = "10")
    @Column(name = "QTD_NAO", nullable = false)
    private int quantidadeVotosNao;
}
