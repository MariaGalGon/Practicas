package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaListaofertas;



public class Ofertas extends VistaListaofertas {

	
	public Editar_oferta editOferta;
	public iAdministrador adm = new BDPrincipal();
	ListBox<Oferta> lista;
	Oferta[] ofertasInterfaz;
	basedatos.Oferta[] ofertasBD;
	Seleccionar_ofertas seleccionarOfertas;
	VerticalLayout vertical;


	
	public Ofertas() {
		inicializar();

	}
	
	public void inicializar() {
		this.getBoton_logo().setSrc("/img/logo.png");
		this.getBoton_logo().setHeight("2.5em");
		this.getLista_seleccionar().setVisible(false);
		lista = this.getLista_ofertas().as(ListBox.class);
		seleccionarOfertas = new Seleccionar_ofertas();
		vertical = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		editOferta = new Editar_oferta();
		cargar_lista_ofertas();
		seleccionar();
	}
	
	private void seleccionar() {
		//Acceder a lista seleccionar
		this.getVaadinButton1().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				getLista_ofertas().setVisible(false);
				getCuadro_botones().setVisible(false);
				vertical.add(seleccionarOfertas);
			}
		});
		
		//Salir lista seleccionar
		seleccionarOfertas.getBoton_cancelar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				vertical.remove(seleccionarOfertas);

				getLista_ofertas().setVisible(true);
				getCuadro_botones().setVisible(true);
			}
		});
		
	}
	
	private void cargar_lista_ofertas() {
		lista.clear();
		ofertasBD = adm.cargar_lista_ofertas();
		ofertasInterfaz = new Oferta[ofertasBD.length];
	
		for(int i = 0; i < ofertasBD.length; i++) {
			Oferta o = new Oferta();
			o.getNombre_oferta().setText(ofertasBD[i].getNombre());
			o.getDetalles_oferta().setText(ofertasBD[i].getDetalles());

			
			ofertasInterfaz[i] = o;			
		
			lista.add(o);
		}
	}
	
}