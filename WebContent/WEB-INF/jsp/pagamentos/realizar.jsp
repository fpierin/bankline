<%@ include file="/WEB-INF/jspf/header.jspf"%>
<c:if test="${sessao.logada}">
	<form id="formularioDePagamento" action="<c:url value="/bankline/pagamentos/novo"/>" method="POST">
		<fieldset>
			<legend>Realizar pagamento</legend>
			<label for="codigoDeBarras">Código de barras:</label> 
				<input id="codigoDeBarras" class="required" minlength="10" type="text" name="pagamento.codigoDeBarras" value="${pagamento.codigoDeBarras}"/> 
			<label for="descricao">Descrição:</label>
				<textarea id="descricao" maxlength="20" name="pagamento.descricao">${pagamento.descricao}</textarea>
			<label for="valor">Valor:</label> 
				<input id="valor" min="0" class="required" type="text" name="pagamento.valor" value="${pagamento.valor}" />
			<br>	
			<button type="submit">Realizar pagamento</button>
		</fieldset>
	</form>
</c:if>

<script type="text/javascript">	$('#formularioDePagamento').validate();</script>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>