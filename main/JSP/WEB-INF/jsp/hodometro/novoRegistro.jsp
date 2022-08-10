<div class="box">
	<div class="box-head">
		<h2 class="left">Registrar nova quilometragem</h2>
	</div>

<form action="${linkTo[HodometroController].novoRegistro}" method="post" name="form_quilometragem" id="form_quilometragem">

	<div class="coluna">
		<label for="hodometro.veiculo.placa">Placa:</label> 
		<input type="text" name="hodometro.veiculo.placa" value="${hodometro.veiculo.placa}" />
	</div>
	
	<div class="coluna">
		<label for="hodometro.dataLeitura">Data da leitura: </label>
		<joda:format value="${hodometro.dataLeitura}" pattern="dd/MM/yyyy HH:mm" var="dataLeitura" />
		<input type="text" class="datetimepicker" name="hodometro.dataLeitura" value="${dataLeitura}" />
	</div>
	
	<div class="separator">&nbsp;</div>
		
	<div class="coluna">
		<label for="hodometro.quilometragem">Quilometro: </label> 
		<input type="text" name="hodometro.quilometragem" value="" />
	</div>
	
	<div class="separator">&nbsp;</div>
	
	<br />
	<input type="submit" value="Salvar" />
	
</form>

</div>

<content tag="scripts">

	<script type="text/javascript">
	$(document).ready(function(){
		$("select, input").uniform();
	}); 
	</script>

	<tag:datetimepicker id=".datetimepicker" />

</content>