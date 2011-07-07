<%@ include file="/WEB-INF/jspf/header_admin.jspf" %> 

<form id="formularioDeInclusaoDeNovaConta" action="<c:url value="/admin/adicionarConta"/>"	method="POST">
	<fieldset>
		<legend>Cadastrar nova conta</legend>
		<br>
			Cadastrar nova conta para o cliente 
			<font color="navy">
				<b>
					<i>${cliente.nome}</i>
				</b>
			</font>
		<br>
		<br>	
		<input id="id" type="hidden" name="conta.cliente.id" value="${cliente.id}" />
		Tipo de conta:<br>
		<select name="conta.tipoDeConta">
			<option value="Corrente">Conta corrente</option>
			<option value="Poupanca">Conta poupança</option>
		</select><br><br>			
		<label for="codigoDaAgencia">Código da agência:</label>
			<input id="codigoDaAgencia" minlength="4" maxlength="4" type="text" class="required" name="conta.codigoDaAgencia" value="${conta.codigoDaAgencia}" />
		<label for="codigoDaConta">Código da conta:</label> 
			<input id="codigoDaConta" minlength="5" maxlength="9" type="text" class="required" name="conta.codigoDaConta" value="${conta.codigoDaConta}" />						
		<label for="senha">Senha:</label> 
			<input id="senha" class="required" minlength="6" maxlength="6" type="password" name="conta.senha" value="${conta.senha}"/> 
		<label for="confirmacao">Confirme a senha:</label> <input id="confirmacao" equalTo="#senha" type="password" />
		<br>		 			
		<button type="submit">Abrir conta</button>	
	</fieldset>
</form>

<script type="text/javascript">
	$('#formularioDeInclusaoDeNovaConta').validate();
</script>

<%@ include file="/WEB-INF/jspf/footer.jspf" %> 