package gerenciamentodefrota.dao;

import java.util.List;

import javax.persistence.EntityManager;

import gerenciamentodefrota.model.Motorista;

@Component
public class Motorista {

	private ARQUIVO<Motorista, Long> dao;
	
	public Motorista(EntityManager em){
		this.ARQUIVO = new ARQUIVO<Motorista, Long>(em, Motorista.class);
	}
	
	public void adiciona(Motorista motorista) {
		ARQUIVO.create(motorista);
	}

	public Motorista busca(Long id) {
		return ARQUIVO.find(id);
	}
	
	public List<Motorista> lista() {
		return ARQUIVO.list();
	}
	
	public Motorista buscaPorCadastro(String cadastro) {
		try {
			return ARQUIVO.findByField("funcionario.cadastro", cadastro);
		}
		catch (Exception e) {
			return null;
		}
	}
	
}
