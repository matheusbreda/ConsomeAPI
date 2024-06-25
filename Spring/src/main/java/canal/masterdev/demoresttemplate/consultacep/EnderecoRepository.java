package canal.masterdev.demoresttemplate.consultacep;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	Endereco findByCep(String cep);
}
