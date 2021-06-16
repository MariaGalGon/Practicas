package interfaz;

import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaVerproductosasociados;

public class Ver_productos_asociados extends VistaVerproductosasociados{
	Productos_asociados_a_oferta productos = new Productos_asociados_a_oferta();
	Aniadir_producto_asociado aniadirProductosAsociados = new Aniadir_producto_asociado(false);
	basedatos.Producto[] asociados;
	iAdministrador adm = new BDPrincipal();
	int idOferta;
	Producto_asociado[] pa;
	VerticalLayout vertical;


	public Ver_productos_asociados(int id) {
		inicializar(id);
	}

	public void inicializar(int id) {
		idOferta = id;
		
		vertical = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		vertical.removeAll();
		vertical.add(productos);
		

		if(idOferta > 0)
			cargar_productos_asociados_oferta();
	}
	

	private void cargar_productos_asociados_oferta() {
		
		asociados = adm.cargar_productos_asociados_oferta(idOferta);
		
		ListBox<Producto_asociado> lista =  productos.getLista_productos_asociados().as(ListBox.class);
		lista.removeAll();

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
		productos.pa = pa;
		productos.asociados = asociados;
		productos.idOferta = idOferta;
		
		
	}
	
}