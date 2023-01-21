package br.com.sicredi.assembleia.application.usecase;

import br.com.sicredi.assembleia.application.assembler.PautaAssembler;
import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.validator.PautaValidator;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.repository.PautaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PautaUseCase {
    private PautaRepository pautaRepository;
    private PautaAssembler pautaAssembler;
    private PautaValidator pautaValidator;

    public List<PautaDTO> buscarTodasPautas() {
        List<PautaDTO> pautasDTO = new ArrayList<>();
        List<Pauta> pautas = pautaRepository.findAll();
        for (Pauta pauta : pautas) {
            pautasDTO.add(pautaAssembler.toPautaDTO(pauta));
        }
        return pautaValidator.verificaSeListaPautasEstaVazia(pautasDTO);
    }

    public PautaDTO buscarPorId(Long pautaId) {

        Optional<Pauta> pauta = (pautaRepository.findById(pautaId));
        return pautaAssembler.toPautaDTO(pautaValidator.verificaSePautaExiste(pauta));
    }

    public Pauta salvar(Pauta pauta){
//        return pautaAssembler.toPautaDTO(pautaRepository.saveAndFlush(pauta));
        return pautaRepository.save(pauta);
    }

    public PautaDTO atualizarPauta(Pauta pauta, Long pautaId) {

        Optional<Pauta> pautaOptional = (pautaRepository.findById(pautaId));
        pautaValidator.verificaSePautaExisteVoid(pautaOptional);

        pauta.setId(pautaId);
        return pautaAssembler.toPautaDTO(pautaRepository.save(pauta));
    }

    public PautaDTO aabrirPauta(Pauta pauta, Long pautaId) {

        Optional<Pauta> pautaOptional = (pautaRepository.findById(pautaId));
        pautaValidator.verificaSePautaExisteVoid(pautaOptional);

        pauta.setId(pautaId);
        return pautaAssembler.toPautaDTO(pautaRepository.save(pauta));
    }
}
