package gerenciamentodefrota.controller;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDateTime;

import gerenciamentodefrota.ARQUIVO.Hodometro;
import gerenciamentodefrota.ARQUIVO.Veiculo;
import gerenciamentodefrota.model.Hodometro;

@Resource
public class HodometroController {

	private Result result;
	private Validator validator;
	private Veiculo veiculo;
	private Hodometro hodometro;
	private UsuarioSession usuarioSession;

	public HodometroController(Result result, Validator validator, Veiculo veiculo, Hodometro hodometro, UsuarioSession usuarioSession) {
		this.result = result;
		this.validator = validator;
		this.veiculo = veiculo;
		this.hodometro = hodometro;
		this.usuarioSession = usuarioSession;
	}
	
	@Permission({Perfil.ADMINISTRADOR, Perfil.USUARIO})
	@Get("/veiculo/registrarquilometragem")
	public void novoRegistro() {

	}

	@Permission({Perfil.ADMINISTRADOR,Perfil.USUARIO})
	@Transacional
	@Post("/veiculo/registrarquilometragem")
	public void novoRegistro(Hodometro hodometro) {
		validaNovoHodometro(hodometro);
		
		hodometro.setUsuario(usuarioSession.getUsuario());
		hodometro.adiciona(hodometro);
		result.redirectTo(this).lista();		
	}
	
	private void validaNovoHodometro(Hodometro hodometro) {
		hodometro.setVeiculo(veiculo.buscaPorPlaca(hodometro.getVeiculo().getPlaca()));
		
		if (hodometro.getVeiculo() == null)
			validator.add(new ValidationMessage("Não existe veículo com esta placa nos registros.","veiculo.placa"));
		
		validator.onErrorUsePageOf(this).novoRegistro();
		
		Hodometro registroAnterior = hodometro.ultimoRegistroDoVeiculo(hodometro.getVeiculo());
		BigDecimal quilometragemAnterior = registroAnterior == null ? BigDecimal.ZERO : registroAnterior.getQuilometragem();
		LocalDateTime dataAnterior = registroAnterior == null ? LocalDateTime.now().minusYears(1) : registroAnterior.getDataLeitura();
		
		if (!hodometro.getDataLeitura().isAfter(dataAnterior))
			validator.add(new ValidationMessage("A data da leitura deve ser maior que o registro anterior.","hodometro.dataLeitura"));
		
		if (hodometro.getQuilometragem().compareTo(quilometragemAnterior) != 1)
			validator.add(new ValidationMessage("A quilometragem deve ser maior que o registro anterior.","hodometro.quilometragem"));
		
		validator.onErrorUsePageOf(this).novoRegistro();
	}
	
	@Get("/hodometro")
	public List<Hodometro> lista() {
		return hodometro.ultimoRegistroCadaVeiculo();
	}
	
}
