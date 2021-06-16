package interfaz;

import java.util.ArrayList;
import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import vistas.VistaListaproductoscomprados;

public class Lista_productos_comprados extends VistaListaproductoscomprados{
	
	public ArrayList<Producto_compra> productos = new ArrayList<Producto_compra>();
	private HorizontalLayout layout;
	
	public Lista_productos_comprados() {
		layout = this.getLista_productos();
	}
	
	public void cargar() {
		layout.removeAll();
		for(int i = 0; i < productos.size(); i++) {
			layout.add(productos.get(i));
		}
	}
}