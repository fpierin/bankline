package br.each.usp.bankusp.interceptadores;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.each.usp.bankusp.autorizacao.Restrito;
import br.each.usp.bankusp.recursos.AdminController;
import br.each.usp.bankusp.representacoes.AdministradorWeb;

@Intercepts
public class AutorizacaoInterceptor implements Interceptor {
	private final AdministradorWeb administrador;
	private final Result result;

	public AutorizacaoInterceptor(final AdministradorWeb administrador, final Result result) {
		this.administrador = administrador;
		this.result = result;
	}

	public boolean accepts(final ResourceMethod method) {
		return !administrador.isLogado() && method.containsAnnotation(Restrito.class);
		}


	public void intercept(final InterceptorStack stack, final ResourceMethod method, final Object resourceInstance) throws InterceptionException {
		result.redirectTo(AdminController.class).login();
	}
}
