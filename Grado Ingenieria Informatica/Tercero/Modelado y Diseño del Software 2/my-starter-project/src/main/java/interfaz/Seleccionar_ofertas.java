package interfaz;

import java.util.ArrayList;

import com.vaadin.flow.component.listbox.ListBox;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;

public class Seleccionar_ofertas extends Elementos {

	public iAdministrador adm;
	Elemento[] elementoInterfaz;
	ListBox<Elemento> lista;
	basedatos.Oferta[] ofertasBD;

	
	public Seleccionar_ofertas() {
		inicializar();
	}
	
	public void inicializar() {
		adm = new BDPrincipal();
		cargar_lista_seleccionar_ofertas();
	}

	public void cargar_lista_seleccionar_ofertas() {
		// TODO Auto-generated method stub
		lista = this.getVaadinListBox().as(ListBox.class);
		lista.clear();
		ofertasBD = adm.cargar_lista_seleccionar_ofertas();
		
		elementoInterfaz = new Elemento[ofertasBD.length];
	
		for(int i = 0; i < ofertasBD.length; i++) {
			Elemento e = new Elemento();
			e.getCheckbox_elemento().setLabel(ofertasBD[i].getNombre());
			e.getDetalles_elemento().setText("");
			
			
			elementoInterfaz[i] = e;			
			lista.add(e);
		}
	}
	
	public void eliminar_ofertas() {

		ArrayList<Integer> idsSeleccionados = new ArrayList<Integer>();
		ArrayList<Integer> idsAsociados = new ArrayList<Integer>();
		for(int i = 0; i < elementoInterfaz.length; i++) {
			if(elementoInterfaz[i].getCheckbox_elemento().getValue()) {
				idsSeleccionados.add(ofertasBD[i].getIdOferta());
				for(Object idAsociado: ofertasBD[i].producto_asociado.getCollection()) {
					idsAsociados.add(((basedatos.Producto)idAsociado).getIdProducto());
				}
			}
		}
		
	
		int[] idsProductos = new int[ idsAsociados.size()];

		for(int i = 0; i< idsAsociados.size(); i++) {
			idsProductos[i] = idsAsociados.get(i);
		}
		
		int[] idsEliminar = new int[idsSeleccionados.size()];
		
		for(int i = 0; i< idsSeleccionados.size(); i++) {
			idsEliminar[i] = idsSeleccionados.get(i);
			adm.eliminar_producto_asociado(idsProductos, idsEliminar[i]);
			
		}
		
		adm.eliminar_ofertas(idsEliminar);
	}
}