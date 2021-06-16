package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaVertrabajadores;

public class Ver_trabajadores extends VistaVertrabajadores{

	
	public VerticalLayout layout;
	public Trabajadores lista;
	public Editar_trabajador trabajador;
	iAdministrador adm = new BDPrincipal();
	basedatos.Usuario[] bdTrabajadores;
	Trabajador[] trabajadoresInterfaz;
	int ids[];
	
	
	public Ver_trabajadores() {
		inicializar();
	}
	
	public void inicializar() {
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		lista = new Trabajadores();
		trabajador = new Editar_trabajador();
		cargar_trabajadores();
		layout.add(lista);
		
	}
	
	public void cargar_trabajadores() {
		bdTrabajadores = adm.cargar_trabajadores();
		trabajadoresInterfaz = new Trabajador[bdTrabajadores.length];
		ids = new int[bdTrabajadores.length];
		ListBox<Trabajador> listaInterfaz = lista.getLista_trabajadores().as(ListBox.class);
		listaInterfaz.removeAll();
		for(int i = 0; i<bdTrabajadores.length; i++) {
			trabajadoresInterfaz[i] = new Trabajador();
			trabajadoresInterfaz[i].getId_trabajador().setText(bdTrabajadores[i].getNombre() + " "+ bdTrabajadores[i].getApellidos());
			ids[i] = bdTrabajadores[i].getIdUsuario();
			listaInterfaz.add(trabajadoresInterfaz[i]);
		}
		
	}
	
}