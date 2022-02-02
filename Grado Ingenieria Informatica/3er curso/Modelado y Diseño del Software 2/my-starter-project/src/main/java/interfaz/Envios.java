package interfaz;

import java.util.ArrayList;
import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iRepartidor;
import vistas.VistaListaenvios;


public class Envios extends VistaListaenvios{
	public ArrayList<Envio> enviosVista = new ArrayList<Envio>();
	private VerticalLayout lista;
	private iRepartidor repartidor = new BDPrincipal();
	
	public Envios() {
		inicializar();
	}
	
	private void inicializar() {
		lista = this.getLista_envios().as(VerticalLayout.class);
		
		cargar();
		combobox_estado();
	}
	
	public void cargar() {
		lista.removeAll();
		enviosVista.clear();
		
		this.getElegir_estado().setItems("Todos", "No entregados", "Entregados");
		this.getElegir_estado().setValue("Todos");
		basedatos.Repartidor r = Repartidor.usuario;
		basedatos.Pedido[] pedidos = r.pedidos.toArray();
		
		for(int i = 0; i < pedidos.length; i++) {
			basedatos.Pedido pBD = pedidos[i];
			Envio eInt = new Envio();
			eInt.p = pBD;
			
			eInt.getId_envio().setText("ID: " + Integer.toString(pBD.getIdPedido()));
			
			if(pBD.getFechaEnvio() != null && pBD.getFechaRecepcion() == null) {
				eInt.getEstado().setText("No entregado");
			} else if(pBD.getFechaEnvio() != null && pBD.getFechaRecepcion() != null) {
				eInt.getEstado().setText("Entregado");
			} else {
				continue;
			}
			
			lista.add(eInt);
			enviosVista.add(eInt);			
		}
	}
	
	private void combobox_estado() {
		this.getElegir_estado().addValueChangeListener(event -> {
			//elegir_estado_envio();
		});
	}
	
	private void elegir_estado_envio() {
		basedatos.Repartidor r = Repartidor.usuario;
		basedatos.Pedido[] pedidos = r.pedidos.toArray();
		int[] idPedidos = new int[pedidos.length];
		
		for(int i = 0; i < idPedidos.length; i++) {
			idPedidos[i] = pedidos[i].getIdPedido();
		}
		
		basedatos.Pedido[] pedidosSeleccionados = null;
		if(this.getElegir_estado().getValue().equals("No entregados")) {
			pedidosSeleccionados = repartidor.elegir_estado_envio("No entregados", idPedidos);
		} else if(this.getElegir_estado().getValue().equals("Entregados")){
			pedidosSeleccionados = repartidor.elegir_estado_envio("Entregados", idPedidos);
		}
		
		if(pedidosSeleccionados != null) {
			cargarClasificado(pedidosSeleccionados);
		}
	}
	
	private void cargarClasificado(basedatos.Pedido[] pedidos) {
		lista.removeAll();
		
		this.getElegir_estado().setItems("No entregados", "Entregados");
		
		for(int i = 0; i < enviosVista.size(); i++) {
			Envio eInt = enviosVista.get(i);
			for(int j = 0; j < pedidos.length; j++) {
				if(eInt.p.getIdPedido() == pedidos[j].getIdPedido()) {
					lista.add(eInt);
				}
			}			
		}
	}
}