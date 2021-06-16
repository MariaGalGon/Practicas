package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Abrir_menu_lateral__Administrador_ extends Abrir_menu_lateral {
	public Administrador _administrador; 
	public VerticalLayout lista;
	public Enlace perfil;
	public Enlace catalogo;
	public Enlace ofertas;
	public Enlace categorias;
	public Enlace compras;
	public Enlace cuentas;
	public Enlace anuncios;

	
	public Abrir_menu_lateral__Administrador_() {
		lista = this.getListaVertical().as(VerticalLayout.class);
		
		catalogo = new Enlace();
		catalogo.getNombre_seccion().setText("Catalogo");
		ofertas = new Enlace();
		ofertas.getNombre_seccion().setText("Ofertas");
		categorias = new Enlace();
		categorias.getNombre_seccion().setText("Categorias");
		compras = new Enlace();
		compras.getNombre_seccion().setText("Compras");
		cuentas = new Enlace();
		cuentas.getNombre_seccion().setText("Cuentas");
		anuncios = new Enlace();
		anuncios.getNombre_seccion().setText("Anuncios");
		perfil = new Enlace();
		perfil.getNombre_seccion().setText("Perfil");
	
		lista.add(catalogo);
		lista.add(ofertas);
		lista.add(categorias);
		lista.add(compras);
		lista.add(cuentas);
		lista.add(anuncios);
		lista.add(perfil);
	}
}