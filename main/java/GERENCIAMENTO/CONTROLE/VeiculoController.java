package gerenciamentodefrota.controller;

import java.util.ArrayList;
import java.util.List;

import gerenciamentodefrota.ARQUIVO.VeiculoDAO;
import gerenciamentodefrota.model.Veiculo;

@Resource
public class VeiculoController {

	private Result result;
	private Veiculo veiculo;
	private Validator validator;
	private Combustivel combustivel;

	public VeiculoController(Result result, Veiculo veiculo,
			Validator validator, Combustivel combustivel) {
		this.result = result;
		this.veiculo = veiculo;
		this.validator = validator;
		this.combustivel = combustivel;
	}

	@Get(value = "/veiculo/novo")
	public void novo() {
		result.include("combustiveis", combustivel.lista());
	}

	@Transacional
	@Post("/veiculo/salvar")
	public void salva(final Veiculo veiculo) {
		validaNovoVeiculo(veiculo);

		veiculo.adiciona(veiculo);
		result.redirectTo(this).lista();
	}
	
	private void validaNovoVeiculo(final Veiculo veiculo) {
		validator.validate(veiculo);
		
		if(veiculo.buscaPorPlaca(veiculo.getPlaca()) != null)
			validator.add(new ValidationMessage("Já existe um veiculo cadastrado com esta placa.", "veiculo.placa"));
		
		validator.onErrorRedirectTo(this).novo();
	}

	@Get(value = "/veiculo/{id}")
	public void editar(Long id) {
		try {
			Veiculo veiculo = veiculo.busca(id);
			
			result.include("veiculo", veiculo);
			result.include("combustiveis", combustivel.lista());
		} catch (Exception e) {
			result.notFound();
		}
	}

	@Transacional
	@Put(value = "/veiculo/{veiculo.id}")
	public void alterar(final Veiculo veiculo) {
		validaEditarVeiculo(veiculo);
		
		veiculo.atualiza(veiculo);
		result.redirectTo(this).lista();
	}

	private void validaEditarVeiculo(final Veiculo veiculo) {
		validator.validate(veiculo);
		
		Veiculo veiculoValida = veiculo.buscaPorPlaca(veiculo.getPlaca());
		
		if (!veiculoValida.equals(veiculo)) {
			if(veiculo.buscaPorPlaca(veiculo.getPlaca()) == null)
				validator.add(new ValidationMessage("Já existe um veiculo cadastrado com esta placa.", "veiculo.placa"));
		}
		
		result.include("combustiveis", combustivel.lista());
		validator.onErrorUsePageOf(this).editar(veiculo.getId());
	}

	@Get("/veiculo")
	public List<Veiculo> lista() {
		try {
			return veiculoDAO.lista();
		} catch (Exception e) {
			return new ArrayList<Veiculo>();
		}
	}

}