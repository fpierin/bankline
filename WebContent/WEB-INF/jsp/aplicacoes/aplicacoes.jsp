<%@ include file="/WEB-INF/jspf/header.jspf"%>
<c:if test="${sessao.logada}">
	<fieldset>
		<legend>Investimentos</legend>
		<label for="aplicacaoEmPoupanca">
			<span class="titulo_topico">
				<a href="<c:url value="/bankline/aplicacoes/poupanca"/>"> Aplicação em poupança</a>			
			</span><br /><br />
		</label>
		<span class="topico">
		A Poupança é uma das aplicações financeiras mais tradicionais do mercado. 
		Os recursos guardados na poupança são remunerados a uma taxa de juros de 0,5% ao mês, aplicada sobre os valores atualizados pela Taxa Referencial (TR). 
		Os rendimentos são creditados mensalmente a cada dia-limite estipulado no momento da abertura da conta-poupança. Na data marcada é realizada a transferência da sua conta-corrente para a poupança. 
		</span>
		<br><br>
		<label for="aplicacaoEmCDB">
			<span class="titulo_topico">
				<a href="<c:url value="/bankline/aplicacoes/cdb"/>"> Investimento em CDB</a>			
			</span><br /><br />
		</label>			
		<span class="topico">
			CDB significa Certificado de Depósito Bancário. Estes certificados de depósitos bancários são títulos nominativos emitidos pelos bancos e vendidos ao público como forma de captação de recursos. Os CDBs são negociados a partir de uma taxa bruta de juros anual, e não levam em consideração a tributação ou a inflação. Além disso, podem ser negociados a qualquer momento dentro do prazo contratado mas, quando negociadas a um prazo menor do que aquele mínimo previsto (30,60 ou 90 dias para os títulos pré-fixados), estas aplicações sofrem incidência de Imposto sobre Operações Financeiras (IOF) além do Imposto de Renda na Fonte (IRF).	
		</span>
	</fieldset>			
</c:if>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>
