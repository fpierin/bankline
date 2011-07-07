<%@ include file="/WEB-INF/jspf/header.jspf"%>

<c:if test="${sessao.logada}">
	<fieldset>
		<legend>Extrato</legend>
	<c:if test="${empty conta or conta.totalDeLancamentos eq 0 }">
		<span>Não há lançamentos.</span>
	</c:if>
	<c:if test="${conta.totalDeLancamentos > 0 }">
		<span class="subtopico">Lançamentos realizados até <fmt:formatDate value="${now}" pattern="dd/MM/yyyy HH:mm"/></span>
		<br />
	 	<table class="extrato">
			<thead>
				<tr>
					<th>Data</th>
					<th>Descrição</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${conta.lancamentos}" var="lancamento">
					<c:if test="${not lancamento.futuro}"> 
						<tr>
							<td>
								<fmt:formatDate value="${lancamento.data}" pattern="dd/MM/yyyy HH:mm"/>
							</td>
							<td>${lancamento.descricao}</td>
							<td>
								<c:if test="${lancamento.valor < 0}"> <font color="red"> </c:if>
								<c:if test="${lancamento.valor >= 0}"> <font color="navy"> </c:if>								 
									<fmt:formatNumber type="currency" value="${lancamento.valor}"/>
								<c:if test="${lancamento.valor < 0}"> </font> </c:if>					
							</td>				
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="1"></td>
					<th colspan="1">Saldo parcial:</th>
					<th><fmt:formatNumber type="currency" value="${conta.saldoAtual}"/></th>
				</tr>
			</tfoot>				
		</table>
		<c:if test="${conta.saldoFuturo < 0}">
		<br />
		<span class="subtopico">Lançamentos futuros</span>		
		<br />
		<table class="extrato">
			<thead>
				<tr>
					<th>Data</th>
					<th>Descrição</th>
					<th>Valor</th>
				</tr>
			</thead>		
			<tbody>
				<c:forEach items="${conta.lancamentos}" var="lancamento">
					<c:if test="${lancamento.futuro}"> 
						<tr>
							<td>
								<fmt:formatDate value="${lancamento.data}" pattern="dd/MM/yyyy HH:mm" timeZone="GMT"/>
							</td>
							<td>${lancamento.descricao}</td>
							<td>
								<c:if test="${lancamento.valor < 0}"> <font color="red"> </c:if> 
									<fmt:formatNumber type="currency" value="${lancamento.valor}"/>
								<c:if test="${lancamento.valor < 0}"> </font> </c:if>					
							</td>				
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="1"></td>
					<th colspan="1">Saldo final:</th>
					<th><fmt:formatNumber type="currency" value="${conta.saldoTotal}"/></th>
				</tr>
			</tfoot>				
		</table>			
		</c:if>
	</c:if>
	</fieldset>
</c:if>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>
