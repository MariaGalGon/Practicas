package interfaz;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.Item;
import basedatos.iCibernauta_identificado;
import basedatos.iComun;
import vistas.VistaComprarcibernautaidentificado;

public class Comprar__Cibernauta_identificado_ extends VistaComprarcibernautaidentificado {	
	basedatos.Producto[] bdProductos;
	public iComun comun = new BDPrincipal();
	private iCibernauta_identificado cibernauta = new BDPrincipal();
	private basedatos.Cibernauta cib = Cibernauta_identificado.usuario;

	public Comprar__Cibernauta_identificado_() {
		inicializar();
	}

	public void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");

		this.getEnvio_nombre().setValue(cib.getNombre());
		this.getEnvio_apellidos().setValue(cib.getApellidos());
		this.getEnvio_direccion().setValue(cib.getDireccion());
		this.getEnvio_num_cuenta().setValue(Integer.toString(cib.getTarjeta()));

		ArrayList<Producto_aniadido> carrito = Cibernauta_identificado.carro;
		double subtotal = 0.0;
		for(int i = 0; i < carrito.size(); i++) {
			Producto_aniadido p = carrito.get(i);

			subtotal += p.producto.getPrecio() * p.cantidad;
		}

		DecimalFormat formato = new DecimalFormat("#.00");
		
		double total = subtotal + 2.00;
		this.getSubtotal().setText(formato.format(subtotal) + " €");
		this.getEnvio().setText("2.00 €");
		this.getTotal().setText(formato.format(total) + " €");
	}

	public void buscar_producto() {
		bdProductos = comun.buscar_producto(this.getBarra_busqueda().getValue());
	}

	public void realizar_compra() {		
		ArrayList<Producto_aniadido> productosInt = Cibernauta_identificado.carro;
		Item[] items = new Item[Cibernauta_identificado.carro.size()];
		int cont = 0;
		for(Producto_aniadido x : productosInt) {
			Item it = new Item();
			it.setProductos_pedido(x.producto);
			it.setCantidadProducto(x.cantidad);

			items[cont] = it;

			cont++;
		}

		cibernauta.realizar_compra(cib, items);
	}

}