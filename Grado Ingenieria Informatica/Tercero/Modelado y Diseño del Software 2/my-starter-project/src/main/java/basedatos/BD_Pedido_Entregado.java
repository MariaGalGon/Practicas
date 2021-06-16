package basedatos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Pedido_Entregado;

public class BD_Pedido_Entregado {
	public BDPrincipal _bD_Principal_entregado;
	public Vector<Pedido_Entregado> _entregado = new Vector<Pedido_Entregado>();

	public void aniadir_pedido(Date aFechaRecepcion, Pedido_Enviado aPedido) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Entregado pedido = new Pedido_Entregado();

		try {

			pedido = Pedido_EntregadoDAO.createPedido_Entregado();

			pedido.setComprado_por(aPedido.getComprado_por());
			pedido.setEncargado_compras(aPedido.getEncargado_compras());
			pedido.setFechaRecepcion(aFechaRecepcion);
			pedido.setRepartidor(aPedido.getRepartidor());
			pedido.setPrecioTotal(aPedido.getPrecioTotal());
			pedido.setTotalProductos(aPedido.getTotalProductos());

			Item[] items = aPedido.cantidad.toArray();
			for(int i = 0; i < items.length; i++) {
				items[i].setPedido(pedido);
			}

			Pedido_EntregadoDAO.save(pedido);
			Pedido_EnviadoDAO.deleteAndDissociate(aPedido);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Pedido_Entregado[] elegir_estado_envio(int[] aIdPedidos) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Entregado[] pedidos = null;

		try {
			List<Pedido_Entregado> pedidosTotal = Pedido_EntregadoDAO.queryPedido_Entregado(null, null);
			ArrayList<Pedido_Entregado> aux = new ArrayList<Pedido_Entregado>();

			for(int i = 0; i < pedidosTotal.size(); i++) {
				for(int j = 0; j < aIdPedidos.length; j++) {
					if(pedidosTotal.get(i).getIdPedido() == aIdPedidos[j]) {
						aux.add(pedidosTotal.get(i));
						break;
					}
				}
			}

			pedidos = (Pedido_Entregado[]) aux.toArray();

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return pedidos;
	}

	public Pedido_Entregado quitar_pedido(int aIdPedido) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Pedido_Entregado pedido = new Pedido_Entregado();

		try {
			pedido = Pedido_EntregadoDAO.getPedido_EntregadoByORMID(aIdPedido);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return pedido;
	}

	public Pedido[] cargar_lista_compras() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		Pedido_Entregado[] pedidos = null;


		try {

			List<Pedido_Entregado> pedidosTotal = Pedido_EntregadoDAO.queryPedido_Entregado(null, null);
			pedidos = new Pedido_Entregado[ pedidosTotal.size()];
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