package interfaz;

import java.util.ArrayList;
import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iEncargado_compras;
import vistas.VistaListapedidos;

public class Pedidos extends VistaListapedidos {
	
	private VerticalLayout lista;
	public ArrayList<Producto_pedido> pedidosVista = new ArrayList<Producto_pedido>();
	private iEncargado_compras encargado = new BDPrincipal();
	
	public Pedidos() {
		inicializar();
	}
	
	public void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		
		lista = this.getLista_pedidos().as(VerticalLayout.class);
		
		cargar();
		combobox_estado();

	}
	
	private void cargar() {
		lista.removeAll();
		pedidosVista.clear();
		
		this.getElegir_estado().setItems("Todos" ,"Pendiente", "Enviado");
		this.getElegir_estado().setValue("Todos");
		basedatos.Encargado_compras enc = Encargado_compras.usuario;
		basedatos.Pedido[] pedidos = enc.pedidos.toArray();
		
		for(int i = 0; i < pedidos.length; i++) {
			basedatos.Pedido pBD = pedidos[i];
			Producto_pedido pInt = new Producto_pedido();
			pInt.p = pBD;
			
			pInt.getId_pedido().setText("ID: " + Integer.toString(pBD.getIdPedido()));
			
			if(pBD.getFechaEnvio() != null && pBD.getFechaRecepcion() == null) {
				pInt.getEstado_pedido().setText("Enviado");
			} else if(pBD.getFechaEnvio() == null) {
				pInt.getEstado_pedido().setText("Pendiente");
			} else {
				continue;
			}
			
			lista.add(pInt);
			pedidosVista.add(pInt);			
		}
		
	}
	
	private void combobox_estado() {
		this.getElegir_estado().addValueChangeListener(event -> {
			//elegir_estado_pedido();
		});
	}
	
	private void elegir_estado_pedido() {
		basedatos.Encargado_compras enc = Encargado_compras.usuario;
		basedatos.Pedido[] pedidos = enc.pedidos.toArray();
		int[] idPedidos = new int[pedidos.length];
		
		for(int i = 0; i < idPedidos.length; i++) {
			idPedidos[i] = pedidos[i].getIdPedido();
		}
		
		basedatos.Pedido[] pedidosSeleccionados = null;
		if(this.getElegir_estado().getValue().equals("Pendiente")) {
			pedidosSeleccionados = encargado.elegir_estado_pedido("Pendiente", idPedidos);
		} else if(this.getElegir_estado().getValue().equals("Enviado")){
			pedidosSeleccionados = encargado.elegir_estado_pedido("Enviado", idPedidos);
		}
		
		if(pedidosSeleccionados != null) {
			cargarClasificado(pedidosSeleccionados);
		}		
	}
	
	private void cargarClasificado(basedatos.Pedido[] pedidos) {
		lista.removeAll();
		pedidosVista.clear();
		
		this.getElegir_estado().setItems("Pendiente", "Enviado");
		
		for(int i = 0; i < pedidos.length; i++) {
			basedatos.Pedido pBD = pedidos[i];
			Producto_pedido pInt = new Producto_pedido();
			
			pInt.getId_pedido().setText(Integer.toString(pBD.getIdPedido()));
			
			if(pBD.getFechaEnvio() != null) {
				pInt.getEstado_pedido().setText("Enviado");
			} else {
				pInt.getEstado_pedido().setText("Pendiente");
			}
			
			lista.add(pInt);
			pedidosVista.add(pInt);			
		}
	}
	
}