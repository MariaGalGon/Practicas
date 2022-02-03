/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Maria(University of Almeria)
 * License Type: Academic
 */
package basedatos;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Pedido_EntregadoDAO {
	public static Pedido_Entregado loadPedido_EntregadoByORMID(int idPedido) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_EntregadoByORMID(session, idPedido);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado getPedido_EntregadoByORMID(int idPedido) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getPedido_EntregadoByORMID(session, idPedido);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado loadPedido_EntregadoByORMID(int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_EntregadoByORMID(session, idPedido, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado getPedido_EntregadoByORMID(int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getPedido_EntregadoByORMID(session, idPedido, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado loadPedido_EntregadoByORMID(PersistentSession session, int idPedido) throws PersistentException {
		try {
			return (Pedido_Entregado) session.load(basedatos.Pedido_Entregado.class, new Integer(idPedido));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado getPedido_EntregadoByORMID(PersistentSession session, int idPedido) throws PersistentException {
		try {
			return (Pedido_Entregado) session.get(basedatos.Pedido_Entregado.class, new Integer(idPedido));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado loadPedido_EntregadoByORMID(PersistentSession session, int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pedido_Entregado) session.load(basedatos.Pedido_Entregado.class, new Integer(idPedido), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado getPedido_EntregadoByORMID(PersistentSession session, int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pedido_Entregado) session.get(basedatos.Pedido_Entregado.class, new Integer(idPedido), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Entregado(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryPedido_Entregado(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Entregado(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryPedido_Entregado(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado[] listPedido_EntregadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listPedido_EntregadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado[] listPedido_EntregadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listPedido_EntregadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Entregado(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Entregado as Pedido_Entregado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Entregado(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Entregado as Pedido_Entregado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pedido_Entregado", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado[] listPedido_EntregadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPedido_Entregado(session, condition, orderBy);
			return (Pedido_Entregado[]) list.toArray(new Pedido_Entregado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado[] listPedido_EntregadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPedido_Entregado(session, condition, orderBy, lockMode);
			return (Pedido_Entregado[]) list.toArray(new Pedido_Entregado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado loadPedido_EntregadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_EntregadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado loadPedido_EntregadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_EntregadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado loadPedido_EntregadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Pedido_Entregado[] pedido_Entregados = listPedido_EntregadoByQuery(session, condition, orderBy);
		if (pedido_Entregados != null && pedido_Entregados.length > 0)
			return pedido_Entregados[0];
		else
			return null;
	}
	
	public static Pedido_Entregado loadPedido_EntregadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Pedido_Entregado[] pedido_Entregados = listPedido_EntregadoByQuery(session, condition, orderBy, lockMode);
		if (pedido_Entregados != null && pedido_Entregados.length > 0)
			return pedido_Entregados[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePedido_EntregadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iteratePedido_EntregadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePedido_EntregadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iteratePedido_EntregadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePedido_EntregadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Entregado as Pedido_Entregado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePedido_EntregadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Entregado as Pedido_Entregado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pedido_Entregado", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado createPedido_Entregado() {
		return new basedatos.Pedido_Entregado();
	}
	
	public static boolean save(basedatos.Pedido_Entregado pedido_Entregado) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().saveObject(pedido_Entregado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basedatos.Pedido_Entregado pedido_Entregado) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().deleteObject(pedido_Entregado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Pedido_Entregado pedido_Entregado)throws PersistentException {
		try {
			if (pedido_Entregado.getEncargado_compras() != null) {
				pedido_Entregado.getEncargado_compras().pedidos.remove(pedido_Entregado);
			}
			
			if (pedido_Entregado.getRepartidor() != null) {
				pedido_Entregado.getRepartidor().pedidos.remove(pedido_Entregado);
			}
			
			if (pedido_Entregado.getComprado_por() != null) {
				pedido_Entregado.getComprado_por().comprado.remove(pedido_Entregado);
			}
			
			basedatos.Item[] lCantidads = pedido_Entregado.cantidad.toArray();
			for(int i = 0; i < lCantidads.length; i++) {
				lCantidads[i].setPedido(null);
			}
			return delete(pedido_Entregado);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Pedido_Entregado pedido_Entregado, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (pedido_Entregado.getEncargado_compras() != null) {
				pedido_Entregado.getEncargado_compras().pedidos.remove(pedido_Entregado);
			}
			
			if (pedido_Entregado.getRepartidor() != null) {
				pedido_Entregado.getRepartidor().pedidos.remove(pedido_Entregado);
			}
			
			if (pedido_Entregado.getComprado_por() != null) {
				pedido_Entregado.getComprado_por().comprado.remove(pedido_Entregado);
			}
			
			basedatos.Item[] lCantidads = pedido_Entregado.cantidad.toArray();
			for(int i = 0; i < lCantidads.length; i++) {
				lCantidads[i].setPedido(null);
			}
			try {
				session.delete(pedido_Entregado);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(basedatos.Pedido_Entregado pedido_Entregado) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().refresh(pedido_Entregado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basedatos.Pedido_Entregado pedido_Entregado) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().evict(pedido_Entregado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Entregado loadPedido_EntregadoByCriteria(Pedido_EntregadoCriteria pedido_EntregadoCriteria) {
		Pedido_Entregado[] pedido_Entregados = listPedido_EntregadoByCriteria(pedido_EntregadoCriteria);
		if(pedido_Entregados == null || pedido_Entregados.length == 0) {
			return null;
		}
		return pedido_Entregados[0];
	}
	
	public static Pedido_Entregado[] listPedido_EntregadoByCriteria(Pedido_EntregadoCriteria pedido_EntregadoCriteria) {
		return pedido_EntregadoCriteria.listPedido_Entregado();
	}
}
