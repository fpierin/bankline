<%@ include file="/WEB-INF/jspf/header_admin.jspf" %> 

<form id="formularioDeInclusaoDeNovaConta" action="<c:url value="/admin/editaConta"/>"
	method="POST">
	<fieldset>
		<legend>Alteração de cadastro de Conta ${conta.tipoDeConta}</legend>
		<input id="id" type="hidden" name="conta.id" value="${conta.id}" />
		
		<c:if test="${not conta.poupanca}">
			<label for="limite">Limite</label> 
				<input id="limite" min="0" class="required" type="text" name="conta.limite" value="${conta.limite}" /><br />				
		</c:if>
		
		<label for="senha">Senha:</label> 
			<input id="senha" class="required" minlength="6" maxlength="6" type="password" name="conta.senha" value="${conta.senha}"/> 
		<label for="confirmacao">Confirme a senha:</label> 
			<input id="confirmacao" equalTo="#senha" type="password" value="${conta.senha}" />			
			
		<br>
		<button type="submit">Alterar</button>
	</fieldset>
</form>

<script type="text/javascript">
	$('#formularioDeInclusaoDeAdministrador').validate();
</script>