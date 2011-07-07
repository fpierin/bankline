<%@ include file="/WEB-INF/jspf/header.jspf" %>
<c:if test="${sessao.logada}">
	<fieldset>
		<legend>Pagamentos agendados</legend>
		<br>
		<c:if test="${lancamentoList eq null or empty lancamentoList}">
			<span>Não há pagamentos agendados.</span>
		</c:if>
		<c:if test="${lancamentoList != null && not empty lancamentoList}">
			<table class="extrato">
				<thead>
					<tr>
						<th>Data</th>
						<th>Descrição</th>
						<th>Valor</th>
					</tr>
				</thead>		
				<tbody>
					<c:forEach items="${lancamentoList}" var="lancamento">
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
								<td><a href="cancelar?id=${lancamento.id}">Cancelar</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</c:if>		
	</fieldset>	
</c:if>	
<%@ include file="/WEB-INF/jspf/footer.jspf" %> 