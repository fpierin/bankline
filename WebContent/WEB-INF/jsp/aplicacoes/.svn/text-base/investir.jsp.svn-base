<%@ include file="/WEB-INF/jspf/header.jspf"%>

<c:if test="${sessao.logada}">
	<form id="formularioDeAplicacaoEmCDB" action="<c:url value="/bankline/aplicacoes/cdb/aplicar"/>" method="POST">
		<fieldset>
			<legend>Aplicação em CDB</legend>
			<label for="dataDeVencimento">Data para retirada:</label>
				<apptag:campoData id="data" name="aplicacao.dataDeVencimento" value="${aplicacao.dataDeVencimento}" classe="required" />
			<label for="valorInicial">Valor:</label> 
				<input id="valorInicial" min="0" class="required" type="text" name="aplicacao.valorInicial" value="${aplicacao.valorInicial}" />
			<br>	
			<button type="submit">Realizar aplicação</button>
		</fieldset>
	</form>
</c:if>
<script type="text/javascript">	$('#formularioDeAplicacaoEmCDB').validate();</script>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>