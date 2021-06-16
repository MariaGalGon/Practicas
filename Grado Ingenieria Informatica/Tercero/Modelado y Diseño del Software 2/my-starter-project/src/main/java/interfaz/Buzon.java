package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaBuzon;

public class Buzon extends VistaBuzon{	
	Mensajes lista;
	VerticalLayout layout_mensajes;

	public Buzon() {
		inicializar();
	}

	public void inicializar() {
		lista = new Mensajes();
		layout_mensajes = this.getLista().as(VerticalLayout.class);

		layout_mensajes.add(lista);
	}
}