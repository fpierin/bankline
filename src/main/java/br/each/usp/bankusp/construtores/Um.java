package br.each.usp.bankusp.construtores;


public class Um {

	public static UmCliente Cliente() {
		return new UmCliente();
	}

	public static UmLancamento Lancamento() {
		return new UmLancamento();
	}

	public static UmAdministrador Administrador() {
		return new UmAdministrador();
	}

	public static UmPagamento Pagamento() {
		return new UmPagamento();
	}

}
