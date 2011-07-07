<%@ include file="/WEB-INF/jspf/header_admin.jspf" %> 

<form id="formularioDeInclusaoDeNovaConta" action="<c:url value="/admin/editaCliente"/>"
	method="POST">
	<fieldset>
		<legend>Alteração de cadastro de cliente</legend>
		<input id="id" type="hidden" name="cliente.id" value="${cliente.id}" />
		<label for="nome">Nome:</label> 
			<input id="nome" type="text" class="required" name="cliente.nome" value="${cliente.nome}" />
		<label for="tipoDePessoa">Tipo:</label> 
			<c:if test="${not cliente.pessoaJuridica}">
				<select id="tipoDePessoa" name="cliente.tipoDePessoa">				
					<option value="Fisica" SELECTED>Pessoa física</option>
					<option value="Juridica">Pessoa jurídica</option>
				</select>
			</c:if>
			<c:if test="${cliente.pessoaJuridica}">
				<select id="tipoDePessoa" name="cliente.tipoDePessoa">				
					<option value="Fisica">Pessoa física</option>
					<option value="Juridica" SELECTED>Pessoa jurídica</option>
				</select>
			</c:if>				
			<br>						
		<label for="cpf">CPF/CNPJ:</label> 
			<input id="cpf" type="text" class="required" name="cliente.cpf" value="${cliente.cpf}" />
		<label for="rg">RG:</label> 
			<input id="rg" type="text" class="required" name="cliente.rg" value="${cliente.rg}" />
		<label for="endereco">Endereço:</label> 
			<input id="endereco" type="text" class="required" name="cliente.endereco" value="${cliente.endereco}" />
		<label for="cidade">Cidade:</label> 
			<input id="cidade" type="text" class="required" name="cliente.cidade" value="${cliente.cidade}" />
		<label for="estado">Estado:</label> 
			<input id="estado" type="text" class="required" name="cliente.estado" value="${cliente.estado}" />
		<label for="pais">Pais:</label> 
			<input id="pais" type="text" class="required" name="cliente.pais" value="${cliente.pais}" />			
		<br>
		<button type="submit">Alterar</button>
	</fieldset>
</form>

<script type="text/javascript">
	$('#formularioDeInclusaoDeAdministrador').validate();
</script>