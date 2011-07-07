<%@ include file="/WEB-INF/jspf/header_admin.jspf" %> 

<form id="formularioDeInclusaoDeNovaConta" action="<c:url value="/admin/novoCliente"/>"
	method="POST">
	<fieldset>
		<legend>Cadastrar novo cliente</legend>
		<label for="tipoDeCliente">Tipo:</label> 
			<select name="cliente.tipoDePessoa">
				<option value="Fisica">Pessoa física</option>
				<option value="Juridica">Pessoa jurídica</option>
			</select><br>						
		<label for="nome">Nome:</label> 
			<input id="nome" type="text" class="required" name="cliente.nome" value="${cliente.nome}" />
		<label for="CPF">CPF ou CNPJ:</label> 
			<input id="CPF" type="text" class="required" name="cliente.cpf" value="${cliente.CPF}" />
		<label for="RG">RG ou Inscrição Estadual</label> 
			<input id="RG" type="text" class="required" name="cliente.rg" value="${cliente.RG}" />						
		<label for="endereco">Endereço:</label> 
			<input id="endereco" type="text" class="required" name="cliente.endereco" value="${cliente.endereco}" />
		<label for="cidade">Cidade:</label> 
			<input id="cidade" type="text" class="required" name="cliente.cidade" value="${cliente.cidade}" />
		<label for="estado">Estado:</label> 
			<input id="estado" type="text" class="required" name="cliente.estado" value="${cliente.estado}" />
		<label for="pais">Pais:</label> 
			<input id="pais" type="text" class="required" name="cliente.pais" value="${cliente.pais}" />									
		<br>
		<button type="submit">Cadastrar</button>
	</fieldset>
</form>

<script type="text/javascript">
	$('#formularioDeInclusaoDeAdministrador').validate();
</script>

<%@ include file="/WEB-INF/jspf/footer.jspf" %> 