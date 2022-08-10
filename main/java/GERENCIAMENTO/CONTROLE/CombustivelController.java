package gerenciamentodefrota.controller;

import gerenciamentodefrota.model.Combustivel;

@Resource
public class CombustivelController {

	private Combustivel combustivel;
	private Validator validator;
	private Result result;
	private Notice notice;

	public CombustivelController(Combustivel combustivel, Validator validator, Result result, Notice notice) {
		this.combustivel = combustivel;
		this.validator = validator;
		this.result = result;
		this.notice = notice;
	}

	@Get
	@Path(value = "/combustivel/novo", priority = Path.HIGHEST)
	public void novo() {
	}
	
	@Transacional
	@Post("/combustivel/salvar")
	public void salva(final Combustivel combustivel) {
		validator.validate(combustivel);
		validator.onErrorRedirectTo(this).novo();
		
		combustivelDAO.adiciona(combustivel);
		notice.success("Combustível cadastrado com sucesso.");
		result.redirectTo(this).lista(1);
	}

	@Get
	@Path(value = "/combustivel/{id}")
	public void editar(Long id) {
		try {
			Combustivel combustivel = combustivel.busca(id);
			result.include("combustivel", combustivel);
		} catch (Exception e) {
			result.notFound();
		}
	}
	
	@Transacional
	@Put
	@Path(value = "/combustivel/{combustivel.id}")
	public void alterar(final Combustivel combustivel) {
		validator.validate(combustivel);
		validator.onErrorUsePageOf(this).editar(combustivel.getId());
		
		combustivelDAO.atualiza(combustivel);
		notice.success("Combustível alterado com sucesso.");
		result.redirectTo(this).lista(1);
	}
	
	@Get("/combustivel")
	public void lista(Integer pagina) {
		result.include("combustiveis", combustivel.lista(pagina));
	}

}
