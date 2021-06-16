package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;

public class Buscar_producto__Adminitrador_ extends Buscar_producto {
	
	public VerticalLayout layout;
	basedatos.Producto[] bdProductos;
	public iAdministrador adm = new BDPrincipal();

	
	public Buscar_producto__Adminitrador_() {
		super();
		inicializar();
	}
	
	public void inicializar() {
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		this.getLogo_admin().setSrc("/img/logo.png");
		this.getLogo_admin().setHeight("2.5em");
		this.getCabecera_cibernauta_buscar_producto().setVisible(false);
	}	
	
	public void buscar_producto() {
		bdProductos = adm.buscar_producto(this.getBarra_busqueda_producto().getValue());
	}
	
}