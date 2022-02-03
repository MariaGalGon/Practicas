package interfaz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iComun;

public class Carrito__Cibernauta_identificado_ extends Carrito {	
	basedatos.Producto[] bdProductos;
	public iComun comun = new BDPrincipal();
	public ArrayList<Producto_aniadido> carrito = new ArrayList<Producto_aniadido>();
	public HorizontalLayout layout;
	public Productos_aniadidos lista = new Productos_aniadidos();

	public Carrito__Cibernauta_identificado_() {
		inicializar();		
	}

	public void inicializar() {
		//Poner logo y tamaño
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");

		layout = this.getLista_productos();

		layout.add(lista);

		cargar_productos();
	}

	public void buscar_producto() {
		bdProductos = comun.buscar_producto(this.getBarra_busqueda().getValue());
	}

	public void cargar_productos() {
		lista.getLista_productos_aniadidos().removeAll();
		List<String> combobox = new ArrayList<String>();
		combobox.add("1");
		combobox.add("2");
		combobox.add("3");
		combobox.add("4");
		combobox.add("5");
		combobox.add("6");
		combobox.add("7");
		combobox.add("8");
		combobox.add("9");
		combobox.add("10");
		double subtotal = 0.0;

		for(int i = 0; i < carrito.size(); i++) {
			Producto_aniadido p = new Producto_aniadido();
			p = carrito.get(i);

			p.getCantidad_producto_aniadido().setItems(combobox);

			p.getNombre_producto_aniadido().setText(p.producto.getNombre());
			p.getPrecio_producto_aniadido().setText(Double.toString(p.producto.getPrecio()) + " €");
			p.getImagen_producto_aniadido().setSrc(p.producto.getImagen());
			p.getImagen_producto_aniadido().setHeight("8em");

			p.getCantidad_producto_aniadido().setValue(Integer.toString(p.cantidad));

			subtotal += p.producto.getPrecio() * p.cantidad;
			lista.getLista_productos_aniadidos().add(p);
		}

		DecimalFormat formato = new DecimalFormat("#.00");
		
		double total = subtotal + 2.00;
		this.getSubtotal().setText(formato.format(subtotal) + " €");
		this.getEnvio().setText("2.00 €");
		this.getTotal().setText(formato.format(total) + " €");
	}

}