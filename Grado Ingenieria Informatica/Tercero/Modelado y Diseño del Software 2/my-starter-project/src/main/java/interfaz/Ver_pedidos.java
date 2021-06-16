package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaVerpedidos;

public class Ver_pedidos extends VistaVerpedidos {

	Lista_pedidos__Cibernauta_ listaPedidos = new Lista_pedidos__Cibernauta_();
	VerticalLayout vertical;
	basedatos.Pedido[] pedidos;
	Pedido__Cibernauta_[] pedidoInterfaz;
	Ver_mas_de_pedido verMas;
	
	public Ver_pedidos() {
		inicializar();
	}
	
	public void inicializar() {
		vertical = this.getVertical().as(VerticalLayout.class);
		verMas = new Ver_mas_de_pedido();

		vertical.removeAll();
		vertical.add(listaPedidos);
		cargar_pedidos();
		 cancelar_listener();
	}
	
	public void cargar_pedidos() {
		pedidos = Cibernauta_identificado.usuario.comprado.toArray();
		listaPedidos.getLista_pedidos().removeAll();
		pedidoInterfaz = new Pedido__Cibernauta_[pedidos.length];
		for(int i = 0; i< pedidos.length; i++) {
			pedidoInterfaz[i] = new Pedido__Cibernauta_();
			
			String estado;
			if(pedidos[i].getFechaEnvio() == null) {
				estado = "Pendiente";
				pedidoInterfaz[i].getTitulo_pedido().setText("Pedido " + pedidos[i].getIdPedido());
			}else if (pedidos[i].getFechaRecepcion() == null){
				estado = "Enviado";
				pedidoInterfaz[i].getTitulo_pedido().setText("Pedido " + pedidos[i].getFechaEnvio());
			}else {
				estado = "Entregado";
				pedidoInterfaz[i].getTitulo_pedido().setText("Pedido " + pedidos[i].getFechaEnvio());
			}
			
			pedidoInterfaz[i].getEstado().setText(estado);
			pedidoInterfaz[i].getPrecio().setText(Double.toString(pedidos[i].getPrecioTotal()));
			pedidoInterfaz[i].getNum_productod().setText(Integer.toString(pedidos[i].getTotalProductos()));
			basedatos.Pedido p =  pedidos[i];

			pedidoInterfaz[i].getBoton_mas_detalles().addClickListener(new ComponentEventListener() {
				@Override
				public void onComponentEvent(ComponentEvent event) {
					verMas.pedido = p;
					verMas.estado = estado;
					listaPedidos.getLista_pedidos().removeAll();
					verMas.cargar_pedido();
					vertical.add(verMas);
				}
			});
			
			listaPedidos.getLista_pedidos().add(pedidoInterfaz[i]);
		}
	}
	
	public void cancelar_listener() {
		
		verMas.getBoton_cancelar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				verMas.cancelar_pedido();
				vertical.add(verMas);
				Notification.show("Pedido cancelado.");

			}
		});
	}
	
}