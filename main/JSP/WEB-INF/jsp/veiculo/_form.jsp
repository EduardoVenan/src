<%@page import="gerenciamentodefrota.model.enums.SituacaoVeiculo"%>
<input type="hidden" name="veiculo.id" value="${veiculo.id}" />

<div class="coluna">
	<label for="veiculo.descricao">Descrição:</label> 
	<input type="text" name="veiculo.descricao" value="${veiculo.descricao}" />
</div>

<div class="coluna">
	<label for="veiculo.placa">Placa:</label>
	<input type="text" name="veiculo.placa" value="${veiculo.placa}" />
</div>

<div class="separator">&nbsp;</div>

<div class="coluna">
	<label for="veiculo.marca">Marca:</label>
	<input type="text" id="veiculo.marca" name="veiculo.marca" value="${veiculo.marca}" />
</div>

<div class="coluna">
	<label for="veiculo.modelo">Modelo:</label>
	<input type="text" name="veiculo.modelo" value="${veiculo.modelo}" />
</div>

<div class="separator">&nbsp;</div>

<div class="coluna">
	<label for="veiculo.anoModelo">Ano do modelo:</label> 
	<input type="text" name="veiculo.anoModelo" value="${veiculo.anoModelo}" />
</div>

<div class="coluna">
	<label for="veiculo.anoFabricacao">Ano de fabricação:</label>
	<input type="text" name="veiculo.anoFabricacao" value="${veiculo.anoFabricacao}" />
</div>

<div class="separator">&nbsp;</div>

<div class="coluna">
	<label for="veiculo.cor">Cor:</label>
	<input type="text" name="veiculo.cor" value="${veiculo.cor}" />
</div>

<div class="coluna">
	<label for="veiculo.chassi">Chassi:</label>
	<input type="text" name="veiculo.chassi" value="${veiculo.chassi}" />
</div>

<div class="separator">&nbsp;</div>

<div class="coluna">
	<label for="veiculo.renavam">Renavam:</label>
	<input type="text" name="veiculo.renavam" value="${veiculo.renavam}" />
</div>

<div class="coluna">
	<label for="veiculo.capacidadeTanque">Capacidade do tanque:</label>
	<input type="text" name="veiculo.capacidadeTanque" value="${veiculo.capacidadeTanque}" />
</div>

<div class="separator">&nbsp;</div>

<div class="coluna">
	<label for="veiculo.propriedade">Propriedade:</label>
	<select name="veiculo.propriedade">
		<option value="" ${veiculo.propriedade == null ? 'selected' : ''}>Selecione ...</option>
		<option value="PROPRIO" ${veiculo.propriedade == 'PROPRIO' ? 'selected' : ''}>próprio</option>
		<option value="ARRENDADO" ${veiculo.propriedade == 'ARRENDADO' ? 'selected' : ''}>arrendado</option>
	</select>
</div>

<div class="coluna">
	<label for="veiculo.situacao">Situação:</label>
<!-- 	<select name="veiculo.situacao"> -->
<%-- 		<option value="" ${veiculo.situacao == null ? 'selected' : ''}>Selecione ...</option> --%>
<%-- 		<option value="EM_USO" ${veiculo.situacao == 'EM_USO' ? 'selected' : ''}>em uso</option> --%>
<%-- 		<option value="VENDIDO" ${veiculo.situacao == 'VENDIDO' ? 'selected' : ''}>vendido</option> --%>
<%-- 		<option value="LEILOADO" ${veiculo.situacao == 'LEILOADO' ? 'selected' : ''}>leiloado</option> --%>
<%-- 		<option value="DOADO" ${veiculo.situacao == 'DOADO' ? 'selected' : ''}>doado</option> --%>
<!-- 	</select> -->
	
	<tag:enumtocombobox name="veiculo.situacao" valor="${veiculo.situacao}" classe="<%= SituacaoVeiculo.class %>" selecione="Selecione ..." />
	
</div>

<div class="separator">&nbsp;</div>

<div class="coluna">
	<label for="veiculo.combustivel">Combustível:</label>
	<select name="veiculo.combustivel.id">
		<c:forEach items="${combustiveis}" var="comb">
			<option value="${comb.id}" ${veiculo.combustivel.id == comb.id ? 'selected' : ''}>${comb.descricao}</option>
		</c:forEach>
	</select>
</div>

<div class="separator">&nbsp;</div>

<div class="coluna">
	<label for="veiculo.observacao">Observação:</label>
	<textarea name="veiculo.observacao" rows="10" cols="40">${veiculo.observacao}</textarea>
</div>

<div class="separator">&nbsp;</div>