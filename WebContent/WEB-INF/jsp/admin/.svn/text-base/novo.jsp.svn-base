<%@ include file="/WEB-INF/jspf/header_admin.jspf" %> 

<form id="formularioDeInclusaoDeAdministrador" action="<c:url value="/admin/adicionaAdministrador"/>"
	method="POST">
	<fieldset>
		<legend>Criar novo usuário administrador</legend>
		<label for="nome">Nome:</label> 
			<input id="nome" class="required" type="text" name="administrador.nome" value="${administrador.nome}" /> 
		<label for="login">Login:</label> 
			<input id="login" class="required" type="text" name="administrador.login" value="${administrador.login}" /> 
		<label for="senha">Senha:</label> 
			<input id="senha" class="required" type="password" name="administrador.senha" value="${administrador.senha}"/> 
		<label for="confirmacao">Confirme a senha:</label> <input id="confirmacao" equalTo="#senha" type="password" />
		<button type="submit">Enviar</button>
	</fieldset>
</form>

<script type="text/javascript">
	$('#formularioDeInclusaoDeAdministrador').validate();
</script>

<%@ include file="/WEB-INF/jspf/footer.jspf" %> 