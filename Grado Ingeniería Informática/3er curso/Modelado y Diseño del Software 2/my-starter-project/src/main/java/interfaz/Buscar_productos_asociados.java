package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Buscar_productos_asociados extends Buscar_producto {
	public Aniadir_producto_asociado _aniadir_producto_asociado;

	public VerticalLayout layout;


	public Buscar_productos_asociados() {
		inicializar();
	}

	public void inicializar() {
		buscador();
		this.getLogo_admin().setSrc("/img/logo.png");
		this.getLogo_admin().setHeight("2.5em");

		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		this.getCabecera_cibernauta_buscar_producto().setVisible(false);
	}

	private void buscador() {
		//Buscar
		getBoton_buscar1().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				Notification.show("Buscando...");
				getBarra_busqueda().clear();

			}
		});
	}
}