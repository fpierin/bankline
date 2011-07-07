<%@ include file="/WEB-INF/jspf/header.jspf"%>
<c:if test="${sessao.logada}">
	<form id="formularioDeTransferencias" action="<c:url value="/bankline/transferencias/realizarTransferencia"/>" method="POST">
		<fieldset>
			<legend>Realizar transferência</legend>
			<label for="codigoDaAgencia">Agência:</label> 
				<input id="codigoDaAgencia" class="required" minlength="4" maxlength="4" 
					type="text" name="transferencia.codigoDaAgencia" value="${transferencia.codigoDaAgencia}"/>
			<label for="codigoDaConta">Conta:</label> 					
				<input id="codigoDaConta" class="required" minlength="5" maxlength="5" 
					type="text" name="transferencia.codigoDaConta" value="${transferencia.codigoDaConta}"/>
			<label for="valor">Valor:</label> 
				<input id="valor" min="0" class="required" type="text" name="transferencia.valor" value="${transferencia.valor}" />
			<label for="data">Data:</label>
				<apptag:campoData id="data" name="transferencia.data" value="${transferencia.data}" classe="required" />
			<label for="descricao">Descrição:</label>
					<textarea id="descricao" maxlength="20" name="transferencia.descricao">${transferencia.descricao}</textarea>				 							
			<br>	
			<button type="submit">Transferir</button>
		</fieldset>
	</form>
</c:if>
<script type="text/javascript">	$('#formularioDeTransferencias').validate();</script>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>
