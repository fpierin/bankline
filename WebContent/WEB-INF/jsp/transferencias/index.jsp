<%@ include file="/WEB-INF/jspf/header.jspf"%>
<c:if test="${sessao.logada}">
	<fieldset>
		<legend>Investimentos</legend>
		<br />
		<label for="Realizar transferência">
			<span class="titulo_topico">
				<a href="<c:url value="/bankline/transferencias/realizar"/>"> Realizar nova transferência entre contas</a>			
			</span><br />
		</label>
		<br><br>
		<label for="Agendar transferência">
			<span class="titulo_topico">
				<a href="<c:url value="/bankline/transferencias/agendar"/>"> Agendar nova transferência entre contas</a>			
			</span><br />
		</label>
		<br><br>
		<label for="Listar transferências">
			<span class="titulo_topico">
				<a href="<c:url value="/bankline/transferencias/listar"/>"> Listar transferências</a>			
			</span><br />
		</label>					
	</fieldset>			
</c:if>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>
