package gerenciamentodefrota.dao;

import java.util.List;

import javax.persistence.EntityManager;

import gerenciamentodefrota.model.Veiculo;

@Component
public class Veiculo {

	private ARQUIVO<Veiculo, Long> dao;

	public VeiculoDAO(EntityManager em) {
		this.dao = new DAO<Veiculo, Long>(em, Veiculo.class);
	}

	public void adiciona(Veiculo veiculo) {
		dao.create(veiculo);
	}

	public void alterar(Veiculo veiculo) {
		dao.update(veiculo);
	}

	public void atualiza(Veiculo veiculo) {
		if (veiculo.getId() != null) {
			dao.update(veiculo);
		} else {
			dao.create(veiculo);
		}
	}

	public Veiculo busca(Long id) {
		return dao.find(id);
	}

	public Veiculo buscaPorPlaca(String placa) {
		try {
			return dao.findByField("placa", placa.toUpperCase());
		}
		catch (Exception e) {
			return null;
		}
	}

	public List<Veiculo> lista() {
		return dao.list();
	}

}
