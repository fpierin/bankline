<%@ include file="/WEB-INF/jspf/header.jspf"%>

<fieldset>
	<legend>Meu cadastro</legend>
	<label for="cadastro">
		<table>	
			<tr>
				<td><b>Nome:</b></td>
				<td>${cliente.nome}</td>
			</tr>
			<tr>
				<td><b>Tipo:</b></td>
				<td>${cliente.tipoDePessoa}</td>
			</tr>	
			<tr>
				<td><b>CPF:</b></td>
				<td>${cliente.cpf}</td>
			</tr>				
			<tr>
				<td><b>RG:</b></td>
				<td>${cliente.rg}</td>
			</tr>
			<tr>
				<td><b>Endereço:</b></td>
				<td>${cliente.endereco}</td>
			</tr>
			<tr>
				<td><b>Cidade:</b></td>
				<td>${cliente.cidade}</td>
			</tr>			
			<tr>
				<td><b>Estado:</b></td>
				<td>${cliente.estado}</td>
			</tr>			
			<tr>
				<td><b>Pais:</b></td>
				<td>${cliente.pais}</td>
			</tr>			
			<tr>
				<td><b>Data de cadastro:</b></td>
				<td><fmt:formatDate value="${cliente.dataDeCadastro}" pattern="dd/MM/yyyy HH:mm"/></td>
			</tr>							
		</table>		
	</label>
	<br>
	<br>	
</fieldset>	

<%@ include file="/WEB-INF/jspf/footer.jspf"%>
