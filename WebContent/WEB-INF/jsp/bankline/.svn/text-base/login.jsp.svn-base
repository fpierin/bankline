<%@ include file="/WEB-INF/jspf/header.jspf"%>
<form action="<c:url value="/bankline/login"/>" method="POST">
	<legend>Acesse sua conta ou abra uma com os nossos gerentes!</legend>
	<fieldset>		
		<label for="codigoDaAgencia">Agência:</label>
			<input id="codigoDaAgencia" type="text" minlength="4" maxlength="4" class="required" name="conta.codigoDaAgencia" />			
		<label for="codigoDaConta">Conta:</label>
			<input id="codigoDaConta" type="text" minlength="5" maxlength="9" class="required" name="conta.codigoDaConta" />			
		<label for="senha">Senha:</label>
			<input id="senha" type="password" minlength="6" maxlength="6" class="required" name="conta.senha" />			
		<br>
		<button type="submit">Acessar</button>
	</fieldset>			
	
<script type="text/javascript">
	$('#formularioDeInclusaoDeAdministrador').validate();
</script>
	
<%@ include file="/WEB-INF/jspf/footer.jspf"%>