package interfaz;

import vistas.VistaPaginaprincipaladministrador;



public class Pagina_principal__Administrador_ extends VistaPaginaprincipaladministrador {

	
	public Pagina_principal__Administrador_() {
		inicializar();
	}
	
	public void inicializar() {
		//Poner logo y tamaño
				this.getBoton_logo().setSrc("/img/logo.png");
				this.getBoton_logo().setHeight("2.5em");
				
				this.getFoto_anuncios().setSrc("/img/publicidad.png");
				this.getFoto_anuncios().setHeight("2.5em");
				
				this.getFoto_cuentas().setSrc("/img/cuentas.jpg");
				this.getFoto_cuentas().setHeight("2.5em");
				
				this.getFoto_compras().setSrc("/img/listado_compras.png");
				this.getFoto_compras().setHeight("2.5em");
				
				this.getFoto_categorias().setSrc("/img/categoria.png");
				this.getFoto_categorias().setHeight("2.5em");
				
				this.getFoto_ofertas().setSrc("/img/oferta.png");
				this.getFoto_ofertas().setHeight("2.5em");
				
				this.getFoto_catalogo().setSrc("/img/catalogo.jpg");
				this.getFoto_catalogo().setHeight("2.5em");
				
				this.getLogo_grande().setSrc("/img/logo.png");
				//this.getLogo_grande().setHeight("2.5em");
	}
}