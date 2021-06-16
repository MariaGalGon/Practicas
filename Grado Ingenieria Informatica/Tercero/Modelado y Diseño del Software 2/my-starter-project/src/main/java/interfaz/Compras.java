package interfaz;

import java.util.ArrayList;
import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaListacompras;


public class Compras extends VistaListacompras{
	iAdministrador adm = new BDPrincipal();
	VerticalLayout lista;

	public Compras() {
		inicializar();
	}

	public void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		lista = this.getLista_compras().as(VerticalLayout.class);

		cargar_lista_compras();
	}

	public void cargar_lista_compras() {
		ArrayList<basedatos.Pedido> pedidos = adm.cargar_lista_compras();
		lista.removeAll();
		for(int i = 0; i <pedidos.size(); i++) {
			Compra c = new Compra();
			c.getNombre_compra().setText(Integer.toString(pedidos.get(i).getIdPedido()));
			String estado;
			if(pedidos.get(i).getFechaEnvio() == null) {
				estado = "Pendiente";
			}else if (pedidos.get(i).getFechaRecepcion() == null){
				estado = "Enviado";

			}else {
				estado = "Entregado";
			}
			c.getEstado_compra().setText(estado);
			lista.add(c);
		}
	}
}