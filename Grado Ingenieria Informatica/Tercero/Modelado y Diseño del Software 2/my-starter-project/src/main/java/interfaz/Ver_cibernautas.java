package interfaz;

import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import basedatos.iComun;
import vistas.VistaVercibernautas;

public class Ver_cibernautas extends VistaVercibernautas {

	
	public VerticalLayout layout;
	public Cibernautas lista;
	iAdministrador adm = new BDPrincipal();

	
	public Ver_cibernautas() {
		inicializar();
		cargar_cibernautas();
	}
	
	public void inicializar() {
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		lista = new Cibernautas();
		
		layout.add(lista);
		
	}
	
	public void cargar_cibernautas() {
		basedatos.Cibernauta[] bdCibernautas = adm.cargar_cibernautas();
		Cibernauta[] cibernautasInterfaz = new Cibernauta[bdCibernautas.length];

		ListBox<Cibernauta> listaInterfaz = lista.getLista_cibernautas().as(ListBox.class);
		listaInterfaz.removeAll();
		for(int i = 0; i<bdCibernautas.length; i++) {
			cibernautasInterfaz[i] = new Cibernauta();
			cibernautasInterfaz[i].getId_cibernauta().setText(bdCibernautas[i].getNombre()+" "+bdCibernautas[i].getApellidos());
			if(bdCibernautas[i].getEstado())
				cibernautasInterfaz[i].getEstado_cibernauta().setText("Activa");
			else
				cibernautasInterfaz[i].getEstado_cibernauta().setText("No Activa");

			listaInterfaz.add(cibernautasInterfaz[i]);
		}
		
	}
}