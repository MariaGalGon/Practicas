package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaListabuzones;



public class Lista_Buzones extends VistaListabuzones{

	
	Buzon entrada;
	Buzon enviados;
	VerticalLayout layout;
	
	public Lista_Buzones() {
		inicializar();
	}
	
	public void inicializar() {
		entrada = new Buzon();
		enviados = new Buzon();
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		entrada.getNombre_buzon().setText("Entrada");
		enviados.getNombre_buzon().setText("Enviados");
		layout.add(entrada);
		layout.add(enviados);
	}
	

}