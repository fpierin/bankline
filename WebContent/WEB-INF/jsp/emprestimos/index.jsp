<%@ include file="/WEB-INF/jspf/header.jspf"%>
<c:if test="${sessao.logada}">
	<fieldset>
		<legend>Emprestimos</legend>
		<br />		
		<label for="realizarEmprestimo">
			<span class="titulo_topico">
				<a href="<c:url value="/bankline/emprestimos/novo"/>"> Novo empréstimo</a>			
			</span><br />
		</label>
		<br><br>
		<label for="verificarEmprestimo">
			<span class="titulo_topico">
				<a href="<c:url value="/bankline/emprestimos/situacao"/>"> Verificar situação de empréstimo</a>			
			</span><br />
		</label>			
	</fieldset>			
</c:if>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>
