<%@ include file="/WEB-INF/jspf/header_admin.jspf" %>
	<fieldset>
		<legend>Contas cadastradas</legend>
		<br>
		<c:if test="${contaList eq null or empty contaList}">
			<span>Não há contas cadastradas.</span>
		</c:if>
		<c:if test="${contaList != null && not empty contaList}">		
			<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Agência</th>
					<th>Conta</th>
					<th>Senha</th>
					<th>Tipo da conta</th>					
					<th>Cliente</th>
					<th>Limite</th>					
					<th>Status</th>													
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contaList}" var="conta">
					<c:if test="${conta.ativa}">
						<tr>
							<td>${conta.id}</td>
							<td>${conta.codigoDaAgencia}</td>				
							<td>${conta.codigoDaConta}</td>
							<td>${conta.senha}</td>
							<td>${conta.tipoDeConta}</td>					
							<td>${conta.cliente.nome}</td>	
							<c:if test="${not conta.poupanca}">							
								<td><fmt:formatNumber type="currency" value="${conta.limite}"/></td>
							</c:if>														
							<c:if test="${conta.poupanca}">							
								<td> - </td>
							</c:if>				
							<td>Ativa</td>					
							<td><a href="editarConta?id=${conta.id}">Alterar</a></td>									
							<td><a href="encerrarConta?id=${conta.id}">Encerrar conta</a></td>					
							<td><a href="excluirConta?id=${conta.id}">Excluir conta</a></td>										
						</tr>
					</c:if>
					<c:if test="${not conta.ativa}">
						<tr>
							<td><s><i>${conta.id}</i></s></td>
							<td><s><i>${conta.codigoDaAgencia}</i></s></td>				
							<td><s><i>${conta.codigoDaConta}</i></s></td>
							<td><s><i>${conta.senha}</i></s></td>
							<td><s><i>${conta.tipoDeConta}</i></s></td>					
							<td><s><i>${conta.cliente.nome}</i></s></td>
							<c:if test="${not conta.poupanca}">							
								<td><fmt:formatNumber type="currency" value="${conta.limite}"/></td>
							</c:if>														
							<c:if test="${conta.poupanca}">							
								<td> - </td>
							</c:if>								
							<td><s><i>Encerrada</i></s></td>
							<td><a href="editarConta?id=${conta.id}">Alterar</a></td>												
							<td><a href="reabrirConta?id=${conta.id}">Reabrir conta</a></td>					
							<td><a href="excluirConta?id=${conta.id}">Excluir conta</a></td>										
						</tr>					
					</c:if>														
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</fieldset>	
<%@ include file="/WEB-INF/jspf/footer.jspf" %> 