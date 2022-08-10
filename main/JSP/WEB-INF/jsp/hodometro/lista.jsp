<div class="box">
	<div class="box-head">
		<h2 class="left">Hodometro</h2>
	</div>
	
	<div class="table">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>Veículo</th>
				<th>Data da leitura</th>
				<th>Km</th>
				<th>Opções</th>
			</tr>
			<c:forEach items="${hodometroList}" var="hodometro">
			<tr>
				<td>${hodometro.veiculo.descricao}</td>
				<td>
					<joda:format value="${hodometro.dataLeitura}" pattern="dd/MM/yyyy HH:mm" />
				</td>
				<td><fmt:formatNumber>${hodometro.quilometragem}</fmt:formatNumber></td>
				<td>&nbsp;</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</div>

<content tag="breadcrumb">
	<div class="small-nav">
		<a href="${pageContext.request.contextPath}/veiculo/registrarquilometragem">Registrar quilometragem</a>
	</div>
</content>
