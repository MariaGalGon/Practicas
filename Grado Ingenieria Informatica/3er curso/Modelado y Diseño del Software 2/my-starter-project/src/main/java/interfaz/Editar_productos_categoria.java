package interfaz;

import java.util.ArrayList;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaEditarproductoscategoria;

public class Editar_productos_categoria extends VistaEditarproductoscategoria{

	int id;
	public iAdministrador adm;
	Productos_asociados_a_categoria productosAsociados;
	VerticalLayout vertical = this.getVaadinVerticalLayout().as(VerticalLayout.class);
	Aniadir_producto_asociado aniadirProductosAsociados;
	basedatos.Categoria c;
	basedatos.Producto[] asociados;
	Producto_asociado[] pa;

	
	public Editar_productos_categoria() {
		inicializar();
	}
	
	private void inicializar() {
		adm = new BDPrincipal();
		this.getNombre_categoria().clear();

		
		aniadirProductosAsociados = new Aniadir_producto_asociado(true);
		productosAsociados = new Productos_asociados_a_categoria();
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
	}
	
	public void guardar_categoria() {
		adm.guardar_categoria(this.getNombre_categoria().getValue(), id);
		//cargar_categoria();
	}
	
	public void cargar_categoria() {
		c = new basedatos.Categoria();
		c = adm.cargar_categoria(id);
		
		this.getNombre_categoria().setValue(c.getNombe());
		vertical.add(productosAsociados);
		cargar_productos_asociados_categoria();
		
	}
	
	private void cargar_productos_asociados_categoria() {
		asociados = c.producto_asociado.toArray();
		
		ListBox<Producto_asociado> lista = productosAsociados.getLista_productos_asociados().as(ListBox.class);

		pa = new Producto_asociado[asociados.length];
		for(int i = 0; i<  asociados.length; i++) {
			pa[i] = new Producto_asociado ();
			pa[i].getCheckbox().setLabel(asociados[i].getNombre());
			if(asociados[i].getDescripcion().length() > 20) {
				pa[i].getDescripcion_producto().setText(asociados[i].getDescripcion().substring(0, 20)+"...");

			}else {
				pa[i].getDescripcion_producto().setText(asociados[i].getDescripcion());

			}
			
			lista.add(pa[i]);
		}
		
		
	}
	
	
	public void eliminar_productos_asociados_categoria() {
		

		
		ArrayList<Integer> idsSeleccionados = new ArrayList<Integer>();
		
		for(int i = 0; i < pa.length; i++) {
			if(pa[i].getCheckbox().getValue())
				idsSeleccionados.add(asociados[i].getIdProducto());
		}
		
		int[] idsAsociados = new int[idsSeleccionados.size()];
		
		for(int i = 0; i< idsSeleccionados.size(); i++) {
			idsAsociados[i] = idsSeleccionados.get(i);
		}
		
		adm.eliminar_productos_asociados_categoria(idsAsociados, id);
		
		
		
	}
	
}