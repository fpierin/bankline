<%@ include file="/WEB-INF/jspf/header_admin.jspf" %>
	<fieldset>
		<legend>Clientes cadastrados</legend>
		<br>
		<c:if test="${clienteList eq null or empty clienteList}">
			<span>Não há clientes cadastrados.</span>
		</c:if>
		<c:if test="${clienteList != null && not empty clienteList}">
			<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Tipo</th>					
					<th>CPF/CNPJ</th>
					<th>RG</th>
					<th>Data de cadastro</th>
					<th>Último acesso</th>				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clienteList}" var="cliente">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.tipoDePessoa}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.rg}</td>								
					<td>
						<fmt:formatDate value="${cliente.dataDeCadastro}" pattern="dd/MM/yyyy HH:mm"/>
					</td>				
					<td>
						<fmt:formatDate value="${cliente.dataDoUltimoAcesso}" pattern="dd/MM/yyyy HH:mm"/>
					</td>			
					<td><a href="abrirConta?id=${cliente.id}">Abrir conta</a></td>
					<td><a href="editarCliente?id=${cliente.id}">Alterar</a></td>					
					<td><a href="excluirCliente?id=${cliente.id}">Excluir</a></td>					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>		
	</fieldset>	
<%@ include file="/WEB-INF/jspf/footer.jspf" %> 