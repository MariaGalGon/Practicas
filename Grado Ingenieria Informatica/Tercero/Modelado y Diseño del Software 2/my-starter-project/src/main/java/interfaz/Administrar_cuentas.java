package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import vistas.VistaAdministrarcuentas;

public class Administrar_cuentas extends VistaAdministrarcuentas{	
	VerticalLayout contenido_tabs = this.getContenido_tabs().as(VerticalLayout.class);
	Ver_trabajadores trabajadores = new Ver_trabajadores();
	Ver_cibernautas cibernautas = new Ver_cibernautas();

	public Administrar_cuentas() {
		super();
		inicializar();
	}

	public void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");

		contenido_tabs.add(trabajadores);

		tabs(); 
	}

	private void tabs() {
		VerticalLayout layout_tabs = this.getLayout_tabs().as(VerticalLayout.class);
		layout_tabs.removeAll();

		Tab tab1 = new Tab("Trabajadores");		
		tab1.setSelected(true);

		Tab tab2 = new Tab("Cibernautas");


		Tabs tabs = new Tabs(true, tab1, tab2);

		tabs.addSelectedChangeListener(event -> {
			String seleccion = event.getSelectedTab().getLabel();

			if(seleccion.equals("Trabajadores")) {
				contenido_tabs.add(trabajadores); 
				contenido_tabs.remove(cibernautas);
			}else if(seleccion.equals("Cibernautas")) {
				contenido_tabs.remove(trabajadores);
				contenido_tabs.add(cibernautas);
			}


		});


		layout_tabs.add(tabs);	
	}
}