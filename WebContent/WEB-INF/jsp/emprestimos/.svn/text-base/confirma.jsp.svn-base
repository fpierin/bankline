<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<fieldset>
		<legend>Confirmação de empréstimo</legend>
		<br>
		<label for="confirmacaoDeEmprestimo">
				<span class="subtopico"><b>Valor do empréstimo:</b> ${emprestimo.valor} <br> </span>
				<span class="subtopico"><b>Descrição:</b> ${emprestimo.descricao} </span> <br><br>
			 
		</label>
		<c:if test="${emprestimo.parcelas != null && not empty emprestimo.parcelas}">
			<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Valor</th>
					<th>Data de vencimento</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emprestimo.parcelas}" varStatus=" " var="parcela">
				<tr>
					<td>${parcela.numero}</td>
					<td>
						<fmt:formatNumber type="currency" value="${parcela.valor}"/>
					</td>					
					<td>
						<fmt:formatDate value="${parcela.data}" pattern="dd/MM/yyyy HH:mm"/>
					</td>				
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<br />		
		<form id="formularioDeConfirmacaoDeEmprestimo" action="<c:url value="/bankline/emprestimos/realiza"/>"	method="POST">		
			<input id="id" type="hidden" name="emprestimo.id" value="${emprestimo.id}" />
			<input id="valor" type="hidden" name="emprestimo.valor" value="${emprestimo.valor}" />			
			<input id="descricao" type="hidden" name="emprestimo.descricao" value="${emprestimo.descricao}" />
			<input id="modalidade" type="hidden" name="emprestimo.modalidade" value="${emprestimo.modalidade}" />
			<button type="submit">Confirmar solicitação</button>			
		</form>
	</c:if>		
	</fieldset>	
<%@ include file="/WEB-INF/jspf/footer.jspf" %> 