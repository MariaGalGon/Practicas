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

public class Pedido_PendienteDAO {
	public static Pedido_Pendiente loadPedido_PendienteByORMID(int idPedido) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_PendienteByORMID(session, idPedido);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente getPedido_PendienteByORMID(int idPedido) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getPedido_PendienteByORMID(session, idPedido);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente loadPedido_PendienteByORMID(int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_PendienteByORMID(session, idPedido, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente getPedido_PendienteByORMID(int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getPedido_PendienteByORMID(session, idPedido, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente loadPedido_PendienteByORMID(PersistentSession session, int idPedido) throws PersistentException {
		try {
			return (Pedido_Pendiente) session.load(basedatos.Pedido_Pendiente.class, new Integer(idPedido));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente getPedido_PendienteByORMID(PersistentSession session, int idPedido) throws PersistentException {
		try {
			return (Pedido_Pendiente) session.get(basedatos.Pedido_Pendiente.class, new Integer(idPedido));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente loadPedido_PendienteByORMID(PersistentSession session, int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pedido_Pendiente) session.load(basedatos.Pedido_Pendiente.class, new Integer(idPedido), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente getPedido_PendienteByORMID(PersistentSession session, int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pedido_Pendiente) session.get(basedatos.Pedido_Pendiente.class, new Integer(idPedido), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Pendiente(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryPedido_Pendiente(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Pendiente(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryPedido_Pendiente(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente[] listPedido_PendienteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listPedido_PendienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente[] listPedido_PendienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listPedido_PendienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Pendiente(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Pendiente as Pedido_Pendiente");
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
	
	public static List queryPedido_Pendiente(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Pendiente as Pedido_Pendiente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pedido_Pendiente", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente[] listPedido_PendienteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPedido_Pendiente(session, condition, orderBy);
			return (Pedido_Pendiente[]) list.toArray(new Pedido_Pendiente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente[] listPedido_PendienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPedido_Pendiente(session, condition, orderBy, lockMode);
			return (Pedido_Pendiente[]) list.toArray(new Pedido_Pendiente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente loadPedido_PendienteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_PendienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente loadPedido_PendienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_PendienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente loadPedido_PendienteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Pedido_Pendiente[] pedido_Pendientes = listPedido_PendienteByQuery(session, condition, orderBy);
		if (pedido_Pendientes != null && pedido_Pendientes.length > 0)
			return pedido_Pendientes[0];
		else
			return null;
	}
	
	public static Pedido_Pendiente loadPedido_PendienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Pedido_Pendiente[] pedido_Pendientes = listPedido_PendienteByQuery(session, condition, orderBy, lockMode);
		if (pedido_Pendientes != null && pedido_Pendientes.length > 0)
			return pedido_Pendientes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePedido_PendienteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iteratePedido_PendienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePedido_PendienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iteratePedido_PendienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePedido_PendienteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Pendiente as Pedido_Pendiente");
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
	
	public static java.util.Iterator iteratePedido_PendienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Pendiente as Pedido_Pendiente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pedido_Pendiente", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente createPedido_Pendiente() {
		return new basedatos.Pedido_Pendiente();
	}
	
	public static boolean save(basedatos.Pedido_Pendiente pedido_Pendiente) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().saveObject(pedido_Pendiente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basedatos.Pedido_Pendiente pedido_Pendiente) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().deleteObject(pedido_Pendiente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Pedido_Pendiente pedido_Pendiente)throws PersistentException {
		try {
			if (pedido_Pendiente.getEncargado_compras() != null) {
				pedido_Pendiente.getEncargado_compras().pedidos.remove(pedido_Pendiente);
			}
			
			if (pedido_Pendiente.getRepartidor() != null) {
				pedido_Pendiente.getRepartidor().pedidos.remove(pedido_Pendiente);
			}
			
			if (pedido_Pendiente.getComprado_por() != null) {
				pedido_Pendiente.getComprado_por().comprado.remove(pedido_Pendiente);
			}
			
			basedatos.Item[] lCantidads = pedido_Pendiente.cantidad.toArray();
			for(int i = 0; i < lCantidads.length; i++) {
				lCantidads[i].setPedido(null);
			}
			return delete(pedido_Pendiente);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Pedido_Pendiente pedido_Pendiente, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (pedido_Pendiente.getEncargado_compras() != null) {
				pedido_Pendiente.getEncargado_compras().pedidos.remove(pedido_Pendiente);
			}
			
			if (pedido_Pendiente.getRepartidor() != null) {
				pedido_Pendiente.getRepartidor().pedidos.remove(pedido_Pendiente);
			}
			
			if (pedido_Pendiente.getComprado_por() != null) {
				pedido_Pendiente.getComprado_por().comprado.remove(pedido_Pendiente);
			}
			
			basedatos.Item[] lCantidads = pedido_Pendiente.cantidad.toArray();
			for(int i = 0; i < lCantidads.length; i++) {
				lCantidads[i].setPedido(null);
			}
			try {
				session.delete(pedido_Pendiente);
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
	
	public static boolean refresh(basedatos.Pedido_Pendiente pedido_Pendiente) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().refresh(pedido_Pendiente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basedatos.Pedido_Pendiente pedido_Pendiente) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().evict(pedido_Pendiente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Pendiente loadPedido_PendienteByCriteria(Pedido_PendienteCriteria pedido_PendienteCriteria) {
		Pedido_Pendiente[] pedido_Pendientes = listPedido_PendienteByCriteria(pedido_PendienteCriteria);
		if(pedido_Pendientes == null || pedido_Pendientes.length == 0) {
			return null;
		}
		return pedido_Pendientes[0];
	}
	
	public static Pedido_Pendiente[] listPedido_PendienteByCriteria(Pedido_PendienteCriteria pedido_PendienteCriteria) {
		return pedido_PendienteCriteria.listPedido_Pendiente();
	}
}
