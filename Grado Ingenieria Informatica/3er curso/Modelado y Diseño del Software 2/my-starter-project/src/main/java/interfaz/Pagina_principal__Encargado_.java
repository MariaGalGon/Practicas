package interfaz;

import vistas.VistaPaginaprincipalencargado;



public class Pagina_principal__Encargado_ extends VistaPaginaprincipalencargado {

	
	public Pagina_principal__Encargado_() {
		inicializar();
	}

	public void inicializar() {
		this.getLogo1().setSrc("/img/logo.png");
		
		this.getBoton_logo().setSrc("/img/logo.png");
		this.getBoton_logo().setHeight("2.5em");
		
		this.getVer_pedidos().setSrc("/img/listado_compras.png");
		this.getVer_pedidos().setHeight("2.5em");
		
		this.getPerfil().setSrc("/img/cuentas.jpg");
		this.getPerfil().setHeight("2.5em");
		
		
	}
}