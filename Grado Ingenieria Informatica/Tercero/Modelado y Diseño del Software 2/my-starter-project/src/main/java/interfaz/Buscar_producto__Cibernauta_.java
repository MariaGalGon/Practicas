package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iComun;

public class Buscar_producto__Cibernauta_ extends Buscar_producto {	
	public VerticalLayout layout;
	basedatos.Producto[] bdProductos;
	public iComun comun = new BDPrincipal();
	Resultados_busqueda listaResultados;
	Producto[] productosInterfaz;
	int[] ids;

	public Buscar_producto__Cibernauta_() {
		super();
		inicializar();
	}


	public void inicializar() {
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		this.getLogo_user().setSrc("/img/logo.png");
		this.getLogo_user().setHeight("2.5em");

		listaResultados = new Resultados_busqueda();
		this.getResultados().add(listaResultados);


	}	

	public void buscar_producto() {
		bdProductos = comun.buscar_producto(this.getBarra_busqueda().getValue());
		mostrar();
	}

	public void mostrar() {
		listaResultados.getLista_buscar_productos().removeAll();

		productosInterfaz = new Producto[bdProductos.length];
		ids = new int[bdProductos.length];

		for(int i = 0; i < bdProductos.length; i++) {
			Producto p = new Producto();

			p.getNombre_producto().setText(bdProductos[i].getNombre());

			p.getPrecio_producto().setText(Double.toString(bdProductos[i].getPrecio()) + " €");		
			p.getImagen_producto().setSrc(bdProductos[i].getImagen());
			p.getImagen_producto().setHeight("8em");
			p.getFecha_oferta_producto().setVisible(false);
			p.getLabel_oferta_producto().setVisible(false);

			p.setId(Integer.toString(bdProductos[i].getIdProducto()));
			productosInterfaz[i] = p;
			ids[i] = bdProductos[i].getIdProducto();

			listaResultados.getLista_buscar_productos().add(p);
		}
	}

}