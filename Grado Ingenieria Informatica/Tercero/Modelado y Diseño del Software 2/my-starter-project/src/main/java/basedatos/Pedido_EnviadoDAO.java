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

public class Pedido_EnviadoDAO {
	public static Pedido_Enviado loadPedido_EnviadoByORMID(int idPedido) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_EnviadoByORMID(session, idPedido);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado getPedido_EnviadoByORMID(int idPedido) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getPedido_EnviadoByORMID(session, idPedido);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado loadPedido_EnviadoByORMID(int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_EnviadoByORMID(session, idPedido, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado getPedido_EnviadoByORMID(int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getPedido_EnviadoByORMID(session, idPedido, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado loadPedido_EnviadoByORMID(PersistentSession session, int idPedido) throws PersistentException {
		try {
			return (Pedido_Enviado) session.load(basedatos.Pedido_Enviado.class, new Integer(idPedido));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado getPedido_EnviadoByORMID(PersistentSession session, int idPedido) throws PersistentException {
		try {
			return (Pedido_Enviado) session.get(basedatos.Pedido_Enviado.class, new Integer(idPedido));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado loadPedido_EnviadoByORMID(PersistentSession session, int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pedido_Enviado) session.load(basedatos.Pedido_Enviado.class, new Integer(idPedido), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado getPedido_EnviadoByORMID(PersistentSession session, int idPedido, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pedido_Enviado) session.get(basedatos.Pedido_Enviado.class, new Integer(idPedido), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Enviado(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryPedido_Enviado(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Enviado(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryPedido_Enviado(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado[] listPedido_EnviadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listPedido_EnviadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado[] listPedido_EnviadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listPedido_EnviadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPedido_Enviado(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Enviado as Pedido_Enviado");
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
	
	public static List queryPedido_Enviado(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Enviado as Pedido_Enviado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pedido_Enviado", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado[] listPedido_EnviadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPedido_Enviado(session, condition, orderBy);
			return (Pedido_Enviado[]) list.toArray(new Pedido_Enviado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado[] listPedido_EnviadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPedido_Enviado(session, condition, orderBy, lockMode);
			return (Pedido_Enviado[]) list.toArray(new Pedido_Enviado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado loadPedido_EnviadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_EnviadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado loadPedido_EnviadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadPedido_EnviadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado loadPedido_EnviadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Pedido_Enviado[] pedido_Enviados = listPedido_EnviadoByQuery(session, condition, orderBy);
		if (pedido_Enviados != null && pedido_Enviados.length > 0)
			return pedido_Enviados[0];
		else
			return null;
	}
	
	public static Pedido_Enviado loadPedido_EnviadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Pedido_Enviado[] pedido_Enviados = listPedido_EnviadoByQuery(session, condition, orderBy, lockMode);
		if (pedido_Enviados != null && pedido_Enviados.length > 0)
			return pedido_Enviados[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePedido_EnviadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iteratePedido_EnviadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePedido_EnviadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iteratePedido_EnviadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePedido_EnviadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Enviado as Pedido_Enviado");
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
	
	public static java.util.Iterator iteratePedido_EnviadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Pedido_Enviado as Pedido_Enviado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pedido_Enviado", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado createPedido_Enviado() {
		return new basedatos.Pedido_Enviado();
	}
	
	public static boolean save(basedatos.Pedido_Enviado pedido_Enviado) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().saveObject(pedido_Enviado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basedatos.Pedido_Enviado pedido_Enviado) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().deleteObject(pedido_Enviado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Pedido_Enviado pedido_Enviado)throws PersistentException {
		try {
			if (pedido_Enviado.getEncargado_compras() != null) {
				pedido_Enviado.getEncargado_compras().pedidos.remove(pedido_Enviado);
			}
			
			if (pedido_Enviado.getRepartidor() != null) {
				pedido_Enviado.getRepartidor().pedidos.remove(pedido_Enviado);
			}
			
			if (pedido_Enviado.getComprado_por() != null) {
				pedido_Enviado.getComprado_por().comprado.remove(pedido_Enviado);
			}
			
			basedatos.Item[] lCantidads = pedido_Enviado.cantidad.toArray();
			for(int i = 0; i < lCantidads.length; i++) {
				lCantidads[i].setPedido(null);
			}
			return delete(pedido_Enviado);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Pedido_Enviado pedido_Enviado, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (pedido_Enviado.getEncargado_compras() != null) {
				pedido_Enviado.getEncargado_compras().pedidos.remove(pedido_Enviado);
			}
			
			if (pedido_Enviado.getRepartidor() != null) {
				pedido_Enviado.getRepartidor().pedidos.remove(pedido_Enviado);
			}
			
			if (pedido_Enviado.getComprado_por() != null) {
				pedido_Enviado.getComprado_por().comprado.remove(pedido_Enviado);
			}
			
			basedatos.Item[] lCantidads = pedido_Enviado.cantidad.toArray();
			for(int i = 0; i < lCantidads.length; i++) {
				lCantidads[i].setPedido(null);
			}
			try {
				session.delete(pedido_Enviado);
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
	
	public static boolean refresh(basedatos.Pedido_Enviado pedido_Enviado) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().refresh(pedido_Enviado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basedatos.Pedido_Enviado pedido_Enviado) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().evict(pedido_Enviado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pedido_Enviado loadPedido_EnviadoByCriteria(Pedido_EnviadoCriteria pedido_EnviadoCriteria) {
		Pedido_Enviado[] pedido_Enviados = listPedido_EnviadoByCriteria(pedido_EnviadoCriteria);
		if(pedido_Enviados == null || pedido_Enviados.length == 0) {
			return null;
		}
		return pedido_Enviados[0];
	}
	
	public static Pedido_Enviado[] listPedido_EnviadoByCriteria(Pedido_EnviadoCriteria pedido_EnviadoCriteria) {
		return pedido_EnviadoCriteria.listPedido_Enviado();
	}
}
