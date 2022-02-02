package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Abrir_menu_lateral__Encargado_ extends Abrir_menu_lateral {
	public Encargado_compras _encargado_compras;
	
	public Administrador _administrador; 
	public VerticalLayout lista;
	public Enlace perfil;
	public Enlace pedidos;

	public Abrir_menu_lateral__Encargado_() {
		lista = this.getListaVertical().as(VerticalLayout.class);
		
		pedidos = new Enlace();
		pedidos.getNombre_seccion().setText("Ver Pedidos");
		perfil = new Enlace();
		perfil.getNombre_seccion().setText("Perfil");
	
		
		lista.add(pedidos);
		lista.add(perfil);
	}
}