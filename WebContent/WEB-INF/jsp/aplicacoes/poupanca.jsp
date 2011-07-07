<%@ include file="/WEB-INF/jspf/header.jspf"%>

<c:if test="${sessao.logada}">
	<form id="formularioDeAplicacaoEmPoupanca" action="<c:url value="/bankline/aplicacoes/poupanca/novo"/>" method="POST">
		<fieldset>
			<legend>Aplicação em poupança</legend>
			<label for="codigoDaAgencia">Código de agência:</label> 
				<input id="codigoDaAgencia" class="required" minlength="4" maxlength="4" 
					type="text" name="transferencia.codigoDaAgencia" value="${transferencia.codigoDaAgencia}"/>
			<label for="codigoDaConta">Código de conta:</label> 					
				<input id="codigoDaConta" class="required" minlength="5" maxlength="5" 
					type="text" name="transferencia.codigoDaConta" value="${transferencia.codigoDaConta}"/>
			<label for="descricao">Descrição:</label>
					<textarea id="descricao" maxlength="20" name="transferencia.descricao">${transferencia.descricao}</textarea>
			<label for="valor">Valor:</label> 
				<input id="valor" min="0" class="required" type="text" name="transferencia.valor" value="${transferencia.valor}" />
			<br>	
			<button type="submit">Realizar aplicação</button>
		</fieldset>
	</form>
</c:if>
<script type="text/javascript">	$('#formularioDeAplicacaoEmPoupanca').validate();</script>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>