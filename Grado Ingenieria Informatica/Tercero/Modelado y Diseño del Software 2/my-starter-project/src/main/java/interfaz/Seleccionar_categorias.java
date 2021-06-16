package interfaz;

import java.util.ArrayList;

import com.vaadin.flow.component.listbox.ListBox;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;

public class Seleccionar_categorias extends Elementos {

	public iAdministrador adm;
	Elemento[] elementoInterfaz;
	ListBox<Elemento> lista;
	basedatos.Categoria[] categoriasBD;

	
	public Seleccionar_categorias() {
		inicializar();
	}
	
	public void inicializar() {
		adm = new BDPrincipal();
		cargar_lista_seleccionar_categorias();
	}

	public void cargar_lista_seleccionar_categorias() {
		// TODO Auto-generated method stub
		lista = this.getVaadinListBox().as(ListBox.class);
		lista.clear();
		categoriasBD = adm.cargar_lista_seleccionar_categorias();
		
		elementoInterfaz = new Elemento[categoriasBD.length];
	
		for(int i = 0; i < categoriasBD.length; i++) {
			Elemento e = new Elemento();
			e.getCheckbox_elemento().setLabel(categoriasBD[i].getNombe());
			e.getDetalles_elemento().setText("");
			
			
			elementoInterfaz[i] = e;			
			lista.add(e);
		}
	}
	
	public void eliminar_categorias() {

		ArrayList<Integer> idsSeleccionados = new ArrayList<Integer>();
		
		for(int i = 0; i < elementoInterfaz.length; i++) {
			if(elementoInterfaz[i].getCheckbox_elemento().getValue())
				idsSeleccionados.add(categoriasBD[i].getIdCategoria());
		}
		
		int[] idsEliminar = new int[idsSeleccionados.size()];
		
		for(int i = 0; i< idsSeleccionados.size(); i++) {
			idsEliminar[i] = idsSeleccionados.get(i);
		}
		
		adm.eliminar_categorias(idsEliminar);
	}
}