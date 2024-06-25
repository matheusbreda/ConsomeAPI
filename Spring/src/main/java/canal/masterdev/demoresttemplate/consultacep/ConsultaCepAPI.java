package canal.masterdev.demoresttemplate.consultacep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class ConsultaCepAPI {
	
	@Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public Endereco consultaCep (String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepResultDTO> resp =
            restTemplate
                .getForEntity(
                    String.format("https://viacep.com.br/ws/87030020/json", cep),
                    CepResultDTO.class);
        CepResultDTO cepResult = resp.getBody();
        
        if (cepResult != null) {
            Endereco endereco = new Endereco();
            endereco.setCep(cepResult.getCep());
            endereco.setLogradouro(cepResult.getLogradouro());
            endereco.setComplemento(cepResult.getComplemento());
            endereco.setBairro(cepResult.getBairro());

            enderecoRepository.save(endereco);
        }

        return enderecoRepository.findByCep(cep);
    }
}
