package interfaz;

import java.text.DecimalFormat;

import org.springframework.boot.autoconfigure.condition.ConditionMessage.ItemsBuilder;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_identificado;
import basedatos.iCibernauta_no_identificado;
import vistas.VistaVermasdepedido;

public class Ver_mas_de_pedido extends VistaVermasdepedido {

	
	private iCibernauta_identificado cibernauta = new BDPrincipal();
	basedatos.Pedido pedido;
	String estado;
	Productos_comprados productosComprados;
	
	public Ver_mas_de_pedido() {
		inicializar();
	}
	
	public void inicializar() {
		productosComprados = new Productos_comprados();
		this.getHueco_lista().as(VerticalLayout.class).add(productosComprados);
	}
	
	public void cargar_pedido() {
		if(estado.equals("Pendiente")) {
			this.getNombre_pedido().setText("Pedido " + pedido.getIdPedido());
			this.getBoton_cancelar().setVisible(true);
			
		}else if (estado.equals("Enviado")){
			this.getNombre_pedido().setText("Pedido " + pedido.getFechaEnvio());
			this.getBoton_cancelar().setVisible(false);
		}else {
			estado = "Entregado";
			this.getNombre_pedido().setText("Pedido " + pedido.getFechaEnvio());
			this.getBoton_cancelar().setVisible(false);
		}
		DecimalFormat formato = new DecimalFormat("#.00");
		productosComprados.getLista_productos_compra().removeAll();
		double subtotal = 0;
		basedatos.Item[] items = pedido.cantidad.toArray();
		for(int i = 0; i< items.length; i++) {
			Producto_comprado pc = new Producto_comprado();
			
			double precio = items[i].getProductos_pedido().getPrecio();
			int cantidad = items[i].getCantidadProducto();
			if(items[i].getProductos_pedido().getOferta_aplicada() != null) {
				subtotal += (items[i].getProductos_pedido().getPrecio()- items[i].getProductos_pedido().getPrecio()*items[i].getProductos_pedido().getOferta_aplicada().getDescuento())*cantidad;
				pc.getPrecio().setText(formato.format(items[i].getProductos_pedido().getPrecio()- items[i].getProductos_pedido().getPrecio()*items[i].getProductos_pedido().getOferta_aplicada().getDescuento()) + " €");

			}else {
				pc.getPrecio().setText(Double.toString(precio));
				subtotal += precio*cantidad;
			}
			
			pc.getContador_cantidad().setText(Integer.toString(cantidad));
			pc.getNombre().setText(items[i].getProductos_pedido().getNombre());
			pc.getImg_producto().setSrc(items[i].getProductos_pedido().getImagen());
			pc.getImg_producto().setHeight("8em");
			productosComprados.getLista_productos_compra().add(pc);
		}
		
		this.getEnvio().setText("2,00 €");
		this.getSubtotal().setText(Double.toString(subtotal) + " €");
		this.getTotal().setText(Double.toString(subtotal+2)  + " €");
	}
	
	public void cancelar_pedido() {
		cibernauta.cancelar_pedido(pedido.getIdPedido());
		Cibernauta_identificado.usuario.comprado.remove(pedido);
	}
}