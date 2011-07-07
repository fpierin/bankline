<%@ include file="/WEB-INF/jspf/header.jspf"%>
<c:if test="${sessao.logada}">
	<fieldset>
		<legend>Situação de empréstimos</legend>
		<c:if test="${empty emprestimoList}">
			<span>Não há empréstimos em andamento.</span>
		</c:if>

		<c:if test="${not empty emprestimoList}">
			<c:forEach items="${emprestimoList}" var="emprestimo">
				<c:if test="${not emprestimo.quitado}">
				<span class="subtopico"> 
					<font>Empréstimo em andamento</font> <br><br>
				</span>				
				<span class="subtopico"><b>Valor do empréstimo:</b> ${emprestimo.valor} <br> </span>
				<span class="subtopico"><b>Descrição:</b> ${emprestimo.descricao} </span>
					
					<br><br>
				 	<table class="extrato">
						<thead>
							<tr>
								<th>#</th>
								<th>Valor</th>
								<th>Data</th>
								<th>Status</th>																
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${emprestimo.parcelas}" var="parcela">
								<tr>
									<td>${parcela.numero}</td>
									<td><fmt:formatNumber type="currency" value="${parcela.valor}"/></td>
									<td>
										<fmt:formatDate value="${parcela.data}" pattern="dd/MM/yyyy HH:mm"/>
									</td>
									<c:if test="${parcela.quitada}">
										<td>
											<font color="navy">Quitado</font>
										</td>
									</c:if>
									<c:if test="${not parcela.quitada}">
										<td>
											<font color="red">A receber</font>
											<td><a href="quitarParcela?id=${parcela.id}">Quitar</a></td>
										</td>									
									</c:if>																										
								</tr>
							</c:forEach>
						</tbody>
					</table>						
				</c:if>
			</c:forEach>
			<br><br>
		</c:if>
		 	
	</fieldset>
</c:if>

<script type="text/javascript">	$('#formularioDePagamento').validate();</script>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>