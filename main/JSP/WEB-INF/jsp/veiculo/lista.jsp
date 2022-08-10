<div class="box">
	<div class="box-head">
		<h2 class="left">Lista de veículos</h2>
	</div>
	
	<div class="table">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>Descrição</th>
				<th>Placa</th>
				<th>Ano de fab.</th>
				<th>Ano do mod.</th>
				<th>Propriedade</th>
				<th>Opções</th>
			</tr>
			<c:forEach items="${veiculoList}" var="veiculo">
				<tr>
					<td>${veiculo.descricao}</td>
					<td>${veiculo.placa}</td>
					<td>${veiculo.anoFabricacao}</td>
					<td>${veiculo.anoModelo}</td>
					<td><c:out value="${veiculo.propriedade}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/veiculo/${veiculo.id}">editar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</div>

<content tag="breadcrumb">
<div class="small-nav">
	<tag:linkpermission perfis="USUARIO,ADMINISTRADOR"
		link="${pageContext.request.contextPath}/veiculo/novo" exibir="true"
		titulo="Cadastrar veículo" />
</div>
</content>
