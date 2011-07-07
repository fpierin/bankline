<%@ attribute name="id" required="true"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="value" required="false"%>
<%@ attribute name="classe" required="false"%>

<script> 
$(function() {
	$("#${id}").datepicker({
		showOtherMonths: true,
		selectOtherMonths: true,
		dateFormat: 'dd/mm/yy'
	});
});
</script> 

<input type="text" class="${classe}" id="${id}" name="${name}" value="${value}"/>

