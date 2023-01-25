package br.com.sicredi.assembleia.external;

import br.com.sicredi.assembleia.userinterface.exception.ApiException;
import br.com.sicredi.assembleia.userinterface.exception.NaoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@AllArgsConstructor
@Component
public class ServiceCpf {


    /**
     * <p>
     * Metodo responsável pela chamada externa para validar um CPF recebido por parametro se é válido ou inválido e se está apto ou não para o voto
     * Essa chamada foi implementada mas não foi executada no código por não estar funcionando, para simular foi gerado um metodo random
     *
     * </p>
     *
     * @param cpf
     */
    public String validaCpf(String cpf) {
        try {
            RestTemplate template = new RestTemplate();

            UriComponents uri = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("user-info.herokuapp.com")
                    .path("users/" + cpf)
                    .build();

            ResponseEntity<Cpf> entity = (template.getForEntity(uri.toUriString(), Cpf.class));

            return entity.getBody().getStatus();
        } catch (HttpStatusCodeException ex) {
            if (ex.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new NaoEncontradoException("CPF inválido, digite um CPF válido para prosseguir com o voto");
            } else
                throw new ApiException("Ocorreu um erro durante o processamento da API");
        }

    }

}