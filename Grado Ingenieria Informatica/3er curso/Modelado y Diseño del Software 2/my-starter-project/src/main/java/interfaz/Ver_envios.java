package interfaz;

import java.util.ArrayList;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaVerenvios;


public class Ver_envios extends VistaVerenvios {
	
	private VerticalLayout layout;	
	public Envios lista;
	
	public Ver_envios() {
		inicializar();
	}
	
	public void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		
		lista = new Envios();
		layout = this.getLayout_envios().as(VerticalLayout.class);
		
		layout.add(lista);
	}
}