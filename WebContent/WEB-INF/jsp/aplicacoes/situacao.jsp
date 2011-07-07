<%@ include file="/WEB-INF/jspf/header.jspf" %>
<c:if test="${sessao.logada}">
	<fieldset>
		<legend>Aplicações em CDB</legend>
		<br>
		<c:if test="${aplicacaoList eq null or empty aplicacaoList}">
			<span>Não há aplicações em CDB.</span>
		</c:if>
		<c:if test="${aplicacaoList != null && not empty aplicacaoList}">
			<table class="extrato">
				<thead>
					<tr>
						<th>Data de apliacação</th>					
						<th>Data de retirada</th>
						<th>Valor da aplicação</th>
						<th>Valor atual</th>						
					</tr>
				</thead>		
				<tbody>
					<c:forEach items="${aplicacaoList}" var="aplicacao">
						<tr>
							<td>
								<fmt:formatDate value="${aplicacao.dataDeAplicacao}" pattern="dd/MM/yyyy HH:mm" timeZone="GMT"/>
							</td>						
							<td>
								<fmt:formatDate value="${aplicacao.dataDeVencimento}" pattern="dd/MM/yyyy HH:mm" timeZone="GMT"/>
							</td>
							<td>
								<fmt:formatNumber type="currency" value="${aplicacao.valorInicial}"/>
							</td>
							<td>
								<fmt:formatNumber type="currency" value="${aplicacao.valorAtual}"/>
							</td>								
							<c:if test="${aplicacao.resgatavel}">
								<td><a href="resgatar?id=${aplicacao.id}">Resgatar</a></td>							
							</c:if>
							<c:if test="${not aplicacao.resgatavel}">
								<td><a href="resgatar?id=${aplicacao.id}">Resgate antecipado</a></td>							
							</c:if>																			
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>		
	</fieldset>	
</c:if>	
<%@ include file="/WEB-INF/jspf/footer.jspf" %> 