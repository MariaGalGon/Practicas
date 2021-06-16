package interfaz;

import java.util.List;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaVercatalogoadministrador;

public class Ver_catalogo__Administrador_ extends VistaVercatalogoadministrador {
	
	public HorizontalLayout layout;
	public VerticalLayout verticalLayout;
	public Buscar_producto__Adminitrador_ barra;
	public Ver_producto__Administrador_ verProducto;
	public iAdministrador adm = new BDPrincipal();
	Resultados_busqueda__Administrador_ lista;
	Producto_resultado[] productosInterfaz;
	int[] ids;
	basedatos.Producto[] productos;
	
	public Ver_catalogo__Administrador_() {
		inicializar();
	}
	
	public void inicializar() {
		lista = new Resultados_busqueda__Administrador_();
		verticalLayout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		layout = this.getVaadinHorizontalLayout();
		barra = new Buscar_producto__Adminitrador_();
		verProducto = new Ver_producto__Administrador_();

		
		layout.add(barra);
		verticalLayout.add(lista);
		buscador();
		cargar_productos();
	}	
	
	private void buscador() {
			
	}
	
	private void cargar_productos() {
		 productos = adm.cargar_productos();
		productosInterfaz = new Producto_resultado[productos.length];
		ids = new int[productos.length];
				
		for(int i = 0; i < productos.length; i++) {
			Producto_resultado p = new Producto_resultado();
			
			//basedatos.Foto img = productos[i].getImagen();
			//p.setImagen_producto_resultado(productos[i].getImagen());			
			//p.getImagen_producto_resultado().setSrc(null);
			
			p.getNombre_producto_resultado().setText(productos[i].getNombre());
			
			p.getPrecio_producto_resultado().setText(Double.toString(productos[i].getPrecio()) + " €");		
			p.getImagen_producto_resultado().setSrc(productos[i].getImagen());
			p.getImagen_producto_resultado().setHeight("8em");
			
			productosInterfaz[i] = p;
			ids[i] = productos[i].getIdProducto();
			lista.getLista_elementos_producto_resultado().add(p);
		}
	}

	public void mostrar_busqueda() {
		 productos = barra.bdProductos;
		productosInterfaz = new Producto_resultado[productos.length];
		ids = new int[productos.length];
				
		lista.getLista_elementos_producto_resultado().removeAll();
		for(int i = 0; i < productos.length; i++) {
			Producto_resultado p = new Producto_resultado();
			
			p.getNombre_producto_resultado().setText(productos[i].getNombre());
			
			p.getPrecio_producto_resultado().setText(Double.toString(productos[i].getPrecio()) + " €");		
			p.getImagen_producto_resultado().setSrc(productos[i].getImagen());
			p.getImagen_producto_resultado().setHeight("8em");
			
			productosInterfaz[i] = p;
			ids[i] = productos[i].getIdProducto();
			lista.getLista_elementos_producto_resultado().add(p);
		}
	}
	


	
}