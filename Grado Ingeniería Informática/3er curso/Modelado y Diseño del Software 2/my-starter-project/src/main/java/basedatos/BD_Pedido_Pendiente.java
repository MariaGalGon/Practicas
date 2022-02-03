package basedatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Pedido_Pendiente;

public class BD_Pedido_Pendiente {
	public BDPrincipal _bD_Principal_pendiente;
	public Vector<Pedido_Pendiente> _pendiente = new Vector<Pedido_Pendiente>();

	public void realizar_compra(Cibernauta aUsuario, Item[] aCarrito) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Pedido_Pendiente p = null;

			p = Pedido_PendienteDAO.createPedido_Pendiente();

			p.setComprado_por(aUsuario);

			int totalProductos = 0;
			double precioTotal = 0;
			for(int i = 0; i < aCarrito.length; i++) {
				p.cantidad.add(aCarrito[i]);

				totalProductos += aCarrito[i].getCantidadProducto();
				precioTotal += aCarrito[i].getProductos_pedido().getPrecio() * aCarrito[i].getCantidadProducto();
			}

			p.setTotalProductos(totalProductos);
			p.setPrecioTotal(precioTotal);

			//Asignar encargado al pedido
			//List<Encargado_compras> encargados = Encargado_comprasDAO.queryEncargado_compras(null, null);
			//int aleatorio = (int) (Math.random() * encargados.size());
			//p.setEncargado_compras(encargados.get(aleatorio));
			//Asignar repartidor al pedido
			/*List<Repartidor> repartidores = RepartidorDAO.queryRepartidor(null, null);
			aleatorio = (int) (Math.random() * repartidores.size());
			p.setRepartidor(repartidores.get(0));*/
			p.setEncargado_compras(Encargado_comprasDAO.getEncargado_comprasByORMID(2));
			p.setRepartidor(RepartidorDAO.getRepartidorByORMID(3));

			Pedido_PendienteDAO.save(p);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void cancelar_pedido(int aIdPedido) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			Pedido_Pendiente p = Pedido_PendienteDAO.getPedido_PendienteByORMID(aIdPedido);
			Item[] items = p.cantidad.toArray();
			for(int i =0; i< p.cantidad.size(); i++) {
				ItemDAO.delete(items[i]);
			}
			Pedido_PendienteDAO.deleteAndDissociate(p);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Pedido_Pendiente[] elegir_estado_pedido(int[] aIdPedidos) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Pendiente[] pedidos = null;

		try {
			List<Pedido_Pendiente> pedidosTotal = Pedido_PendienteDAO.queryPedido_Pendiente(null, null);
			ArrayList<Pedido_Pendiente> aux = new ArrayList<Pedido_Pendiente>();

			for(int i = 0; i < pedidosTotal.size(); i++) {
				for(int j = 0; j < aIdPedidos.length; j++) {
					if(pedidosTotal.get(i).getIdPedido() == aIdPedidos[j]) {
						aux.add(pedidosTotal.get(i));
						break;
					}
				}
			}

			pedidos = (Pedido_Pendiente[]) aux.toArray();

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return pedidos;
	}

	public Pedido_Pendiente quitar_pedido(int aIdPedido) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Pendiente pedido = new Pedido_Pendiente();

		try {
			pedido = Pedido_PendienteDAO.getPedido_PendienteByORMID(aIdPedido);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return pedido;
	}

	public void aniadir_pedido(Pedido_Enviado aPedido) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Pendiente pedido = new Pedido_Pendiente();

		try {

			pedido = Pedido_PendienteDAO.createPedido_Pendiente();

			pedido.setComprado_por(aPedido.getComprado_por());
			pedido.setEncargado_compras(aPedido.getEncargado_compras());
			pedido.setFechaEnvio(null);
			pedido.setRepartidor(aPedido.getRepartidor());
			pedido.setPrecioTotal(aPedido.getPrecioTotal());
			pedido.setTotalProductos(aPedido.getTotalProductos());

			Item[] items = aPedido.cantidad.toArray();
			for(int i = 0; i < items.length; i++) {
				items[i].setPedido(pedido);
			}

			Pedido_PendienteDAO.save(pedido);
			Pedido_EnviadoDAO.deleteAndDissociate(aPedido);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Pedido[] cargar_lista_compras() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Pendiente[] pedidos = null;

		try {
			List<Pedido_Pendiente> pedidosTotal = Pedido_PendienteDAO.queryPedido_Pendiente(null, null);

			pedidos = new Pedido_Pendiente[ pedidosTotal.size()];
			for(int i = 0; i < pedidosTotal.size(); i++) {
				pedidos[i] = pedidosTotal.get(i);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return pedidos;
	}
}