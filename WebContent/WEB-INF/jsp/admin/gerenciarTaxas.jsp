<%@ include file="/WEB-INF/jspf/header_admin.jspf" %> 

<form id="formularioDeGerencimentoDeTaxas" action="<c:url value="/admin/taxas/altera"/>" method="POST">
	<fieldset>
		<legend>Taxas e rendimentos</legend>
		<input id="id" type="hidden" name="taxas.id" value="${taxas.id}" />

		<label for="manutencaoDeConta">Taxa de manutenção de conta (R$):</label> 
			<input id="manutencaoDeConta" min="0" class="required" type="text" name="taxas.manutencaoDeConta" value="${taxas.manutencaoDeConta}" /><br />
			
		<label for="jurosPoupanca">Rendimento mensal da poupança (%):</label> 
			<input id="jurosPoupanca" min="0" max="100" class="required" type="text" name="taxas.jurosPoupanca" value="${taxas.jurosPoupanca}" /><br />
			
		<label for="jurosPenalidadeCDB">Juros de penalidade sobre resgate de CDB antecipado (%):</label> 
			<input id="jurosPenalidadeCDB" min="0" max = "100" class="required" type="text" name="taxas.jurosPenalidadeCDB" value="${taxas.jurosPenalidadeCDB}" /><br />
			
		<label for="jurosCDB">Rendimento mensal do CDB (%):</label> 
			<input id="jurosCDB" min="0" max="100" class="required" type="text" name="taxas.jurosCDB" value="${taxas.jurosCDB}" /><br />
			
			
		<button type="submit">Alterar</button>
	</fieldset>
</form>

<script type="text/javascript">
	$('#formularioDeGerencimentoDeTaxas').validate();
</script>