package basedatos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Pedido_Enviado;

public class BD_Pedido_Enviado {
	public BDPrincipal _bD_Principal_enviado;
	public Vector<Pedido_Enviado> _enviado = new Vector<Pedido_Enviado>();

	public Pedido_Enviado[] elegir_estado_pedido(int[] aIdPedidos) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Enviado[] pedidos = null;

		try {
			List<Pedido_Enviado> pedidosTotal = Pedido_EnviadoDAO.queryPedido_Enviado(null, null);
			ArrayList<Pedido_Enviado> aux = new ArrayList<Pedido_Enviado>();

			for(int i = 0; i < pedidosTotal.size(); i++) {
				for(int j = 0; j < aIdPedidos.length; j++) {
					if(pedidosTotal.get(i).getIdPedido() == aIdPedidos[j]) {
						aux.add(pedidosTotal.get(i));
						break;
					}
				}
			}

			pedidos = (Pedido_Enviado[]) aux.toArray();

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return pedidos;
	}

	public void aniadir_pedido(Pedido_Pendiente aPedido, Date aFecha) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Enviado pedido = new Pedido_Enviado();

		try {

			pedido = Pedido_EnviadoDAO.createPedido_Enviado();

			pedido.setComprado_por(aPedido.getComprado_por());
			pedido.setEncargado_compras(aPedido.getEncargado_compras());
			pedido.setFechaEnvio(aFecha);
			pedido.setRepartidor(aPedido.getRepartidor());
			pedido.setPrecioTotal(aPedido.getPrecioTotal());
			pedido.setTotalProductos(aPedido.getTotalProductos());

			Item[] items = aPedido.cantidad.toArray();
			for(int i = 0; i < items.length; i++) {
				items[i].setPedido(pedido);
			}

			Pedido_EnviadoDAO.save(pedido);
			Pedido_PendienteDAO.deleteAndDissociate(aPedido);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void aniadir_pedido(Pedido_Entregado aPedido) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Enviado pedido = new Pedido_Enviado();

		try {

			pedido = Pedido_EnviadoDAO.createPedido_Enviado();

			pedido.setComprado_por(aPedido.getComprado_por());
			pedido.setEncargado_compras(aPedido.getEncargado_compras());
			pedido.setFechaEnvio(aPedido.getFechaEnvio());
			pedido.setFechaRecepcion(null);
			pedido.setRepartidor(aPedido.getRepartidor());
			pedido.setPrecioTotal(aPedido.getPrecioTotal());
			pedido.setTotalProductos(aPedido.getTotalProductos());

			Item[] items = aPedido.cantidad.toArray();
			for(int i = 0; i < items.length; i++) {
				items[i].setPedido(pedido);
			}

			Pedido_EnviadoDAO.save(pedido);
			Pedido_EntregadoDAO.deleteAndDissociate(aPedido);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Pedido_Enviado quitar_pedido(int aIdPedido) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Enviado pedido = new Pedido_Enviado();

		try {
			pedido = Pedido_EnviadoDAO.getPedido_EnviadoByORMID(aIdPedido);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return pedido;
	}

	public Pedido_Enviado[] elegir_estado_envio(int[] aIdPedidos) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Enviado[] pedidos = null;

		try {
			List<Pedido_Enviado> pedidosTotal = Pedido_EnviadoDAO.queryPedido_Enviado(null, null);
			ArrayList<Pedido_Enviado> aux = new ArrayList<Pedido_Enviado>();

			for(int i = 0; i < pedidosTotal.size(); i++) {
				for(int j = 0; j < aIdPedidos.length; j++) {
					if(pedidosTotal.get(i).getIdPedido() == aIdPedidos[j]) {
						aux.add(pedidosTotal.get(i));
						break;
					}
				}
			}

			pedidos = (Pedido_Enviado[]) aux.toArray();

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return pedidos;
	}

	public Pedido[] cargar_lista_compras() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Enviado[] pedidos = null;

		try {
			List<Pedido_Enviado> pedidosTotal = Pedido_EnviadoDAO.queryPedido_Enviado(null, null);

			pedidos = new Pedido_Enviado[ pedidosTotal.size()];
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