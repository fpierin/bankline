<%@ include file="/WEB-INF/jspf/header.jspf"%>
<c:if test="${sessao.logada}">
	<form id="formularioDeEmprestimo" action="<c:url value="/bankline/emprestimos/confirma"/>" method="POST">
		<fieldset>
			<legend>Solicitação de novo empréstimo</legend>
			<label for="valor">Valor:</label> 
				<input id="valor" min="1" class="required" type="text" name="emprestimo.valor" value="${emprestimo.valor}" /><br />
			<label for="descricao">Descrição:</label>
				<textarea id="descricao" maxlength="100" name="emprestimo.descricao">${emprestimo.descricao}</textarea><br />				
			<label for="modalidade">Modalidade:</label> 
			<select id="modalidade" name="emprestimo.modalidade">				
				<option value="Em12" SELECTED>12 vezes</option>
				<option value="Em24" >24 vezes</option>
				<option value="Em36" >36 vezes</option>
				<option value="Em48" >48 vezes</option>																									
			</select>
			<br><br>					
			<button type="submit">Solicitar</button>
		</fieldset>
	</form>
</c:if>

<script type="text/javascript">	$('#formularioDePagamento').validate();</script>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>