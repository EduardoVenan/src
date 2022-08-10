<div class="box">
	<div class="box-head">
		<h2 class="left">Cadastrar novo veículo</h2>
	</div>

<form action="${linkTo[VeiculoController].salva}" method="post" name="form_veiculo" id="form_veiculo">
	<c:import url="_form.jsp" />
	
	<br />
	<input type="submit" value="Salvar" />
</form>

</div>

<content tag="scripts">

	<script type="text/javascript">
	$(document).ready(function(){
		$.validator.addMethod("placa", function(value, element) {
            return this.optional(element) || /^[a-zA-Z]{3}\-\d{4}$/i.test(value);
		}, "Número da placa é inválido: Digite um número de placa válido.");
		
		$('#form_veiculo').validate({
		    rules: {
		    	"veiculo.descricao": {
	                required: true
	            },
	            "veiculo.placa": {
	            	placa: true,
	                required: true
	            },
	            "veiculo.marca": {
	                required: true
	            },
	            "veiculo.modelo": {
	                required: true
	            },
	            "veiculo.anoModelo": {
	                required: true,
	                digits: true
	            },
				"veiculo.anoFabricacao": {
	                required: true,
	                digits: true
	            },
	            "veiculo.cor": {
	                required: true
	            },
	            "veiculo.chassi": {
	                required: true
	            },
	            "veiculo.renavam": {
	                required: true
	            },
	            "veiculo.capacidadeTanque": {
	                required: true
	            }
	        },
			messages: {
				"veiculo.descricao": {
					required: "O campo descrição é obrigatorio."
	           },
	           "veiculo.placa": {
					required: "O campo placa é obrigatorio."
	           },
	           "veiculo.marca": {
	                required: "O campo marca é obrigatorio."
	           },
	           "veiculo.modelo": {
	                required: "O campo modelo é obrigatorio."
	           },
	           "veiculo.anoModelo": {
	                required: "O campo ano do modelo é obrigatorio.",
	                digits: "Número inválido"
	           },
	           "veiculo.anoFabricacao": {
	                required: "O campo ano de fabricação é obrigatorio.",
	                digits: "Número inválido"
	           },
	            "veiculo.cor": {
	                required: "O campo cor é obrigatorio."
	            },
	            "veiculo.chassi": {
	                required: "O campo chassi é obrigatorio."
	            },
	            "veiculo.renavam": {
	                required: "O campo renavam é obrigatorio."
	            },
	            "veiculo.capacidadeTanque": {
	                required: "O campo capacidade do tanque é obrigatorio."
	            }
	       }
		});
		
		$("select, input").uniform();
		
	}); 
	</script>
	
</content>