package interfaz;

import java.sql.Date;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import basedatos.BDPrincipal;
import basedatos.iEncargado_compras;
import vistas.VistaPedido;

public class Pedido extends VistaPedido {
	
	private Lista_productos_comprados lista;
	private HorizontalLayout lista_layout;
	public basedatos.Pedido p;
	private iEncargado_compras encargado = new BDPrincipal();
	
	public Pedido() {
		inicializar();
	}
	
	private void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		
		lista_layout = this.getVaadinHorizontalLayout();
		lista = new Lista_productos_comprados();
		lista_layout.add(lista);
	}
	
	public void cargar_pedido() {		
		lista.productos.clear();
		
		this.getId_compra().setText("ID de Compra: " + Integer.toString(p.getIdPedido()));
		this.getId_cliente().setText("ID Cliente: " + Integer.toString(p.getComprado_por().getIdUsuario()));		
		this.getCombobox_estado().setItems("Pendiente", "Enviado");
		
		basedatos.Item[] productos = p.cantidad.toArray();
		for(int i = 0; i < productos.length; i++) {
			Producto_compra pInt = new Producto_compra();
			
			pInt.getNombre().setText(productos[i].getProductos_pedido().getNombre());
			pInt.getNumero_cantidad().setText(Integer.toString(productos[i].getCantidadProducto()));
			pInt.getFoto().setSrc(productos[i].getProductos_pedido().getImagen());
			pInt.getFoto().setHeight("8em");
			
			lista.productos.add(pInt);
		}
		
		if(p.getFechaEnvio() == null) {
			this.getCombobox_estado().setValue("Pendiente");
		} else {
			this.getCombobox_estado().setValue("Enviado");
		}
		
		lista.cargar();
		cambiar_estado_pedido();
	}
	
	private void cambiar_estado_pedido() {
		this.getCombobox_estado().addValueChangeListener(event -> {
			if(event.getValue().equals("Pendiente")) {
				encargado.cambiar_estado_pedido("Pendiente", p.getIdPedido(), null);
			} else if(event.getValue().equals("Enviado")) {
				Date f = new java.sql.Date(System.currentTimeMillis());
				encargado.cambiar_estado_pedido("Enviado", p.getIdPedido(), f);
			}			
		});
	}
}