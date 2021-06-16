package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;

import basedatos.BDPrincipal;
import basedatos.iRepartidor;
import vistas.VistaVermasenvio;

public class Ver_mas_envio extends VistaVermasenvio {
	public basedatos.Pedido p;
	private iRepartidor repartidor = new BDPrincipal();
	private boolean entregado;

	public Ver_mas_envio() {
		inicializar();
	}
	
	private void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		entregado = false;
	}
	
	public void cargar_pedido() {
		this.getId_nombre().setText("ID: " + Integer.toString(p.getIdPedido()));
		this.getCliente().setText(p.getComprado_por().getNombre() + " " + p.getComprado_por().getApellidos());
		this.getDireccion().setText(p.getComprado_por().getDireccion());
		if(p.getFechaRecepcion() == null) {
			entregado = false;
			this.getBoton_entregado().setText("No entregado");
		} else {
			entregado = true;
			this.getBoton_entregado().setText("Entregado");
		}
		
		boton_cambiar();
	}
	
	private void boton_cambiar() {
		this.getBoton_entregado().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {							
				cambiar_estado_envio();				
			}
		});
	}
	
	private void cambiar_estado_envio() {
		if(!entregado) {
			repartidor.cambiar_estado_envio(true, p.getIdPedido());
			this.getBoton_entregado().setText("Entregado");
			entregado = true;
		} else if(entregado) {
			repartidor.cambiar_estado_envio(false, p.getIdPedido());
			this.getBoton_entregado().setText("No entregado");
			entregado = false;
		}
	}
}