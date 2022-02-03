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

public class RepartidorDAO {
	public static Repartidor loadRepartidorByORMID(int idUsuario) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadRepartidorByORMID(session, idUsuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor getRepartidorByORMID(int idUsuario) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getRepartidorByORMID(session, idUsuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor loadRepartidorByORMID(int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadRepartidorByORMID(session, idUsuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor getRepartidorByORMID(int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getRepartidorByORMID(session, idUsuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor loadRepartidorByORMID(PersistentSession session, int idUsuario) throws PersistentException {
		try {
			return (Repartidor) session.load(basedatos.Repartidor.class, new Integer(idUsuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor getRepartidorByORMID(PersistentSession session, int idUsuario) throws PersistentException {
		try {
			return (Repartidor) session.get(basedatos.Repartidor.class, new Integer(idUsuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor loadRepartidorByORMID(PersistentSession session, int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Repartidor) session.load(basedatos.Repartidor.class, new Integer(idUsuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor getRepartidorByORMID(PersistentSession session, int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Repartidor) session.get(basedatos.Repartidor.class, new Integer(idUsuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRepartidor(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryRepartidor(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRepartidor(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryRepartidor(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor[] listRepartidorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listRepartidorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor[] listRepartidorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listRepartidorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRepartidor(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Repartidor as Repartidor");
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
	
	public static List queryRepartidor(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Repartidor as Repartidor");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Repartidor", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor[] listRepartidorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRepartidor(session, condition, orderBy);
			return (Repartidor[]) list.toArray(new Repartidor[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor[] listRepartidorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRepartidor(session, condition, orderBy, lockMode);
			return (Repartidor[]) list.toArray(new Repartidor[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor loadRepartidorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadRepartidorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor loadRepartidorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadRepartidorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor loadRepartidorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Repartidor[] repartidors = listRepartidorByQuery(session, condition, orderBy);
		if (repartidors != null && repartidors.length > 0)
			return repartidors[0];
		else
			return null;
	}
	
	public static Repartidor loadRepartidorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Repartidor[] repartidors = listRepartidorByQuery(session, condition, orderBy, lockMode);
		if (repartidors != null && repartidors.length > 0)
			return repartidors[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRepartidorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateRepartidorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRepartidorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateRepartidorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRepartidorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Repartidor as Repartidor");
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
	
	public static java.util.Iterator iterateRepartidorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Repartidor as Repartidor");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Repartidor", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor createRepartidor() {
		return new basedatos.Repartidor();
	}
	
	public static boolean save(basedatos.Repartidor repartidor) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().saveObject(repartidor);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basedatos.Repartidor repartidor) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().deleteObject(repartidor);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Repartidor repartidor)throws PersistentException {
		try {
			basedatos.Pedido[] lPedidoss = repartidor.pedidos.toArray();
			for(int i = 0; i < lPedidoss.length; i++) {
				lPedidoss[i].setRepartidor(null);
			}
			basedatos.Mensaje[] lMensaje_recibidos = repartidor.mensaje_recibido.toArray();
			for(int i = 0; i < lMensaje_recibidos.length; i++) {
				lMensaje_recibidos[i].setDestinatario(null);
			}
			basedatos.Mensaje[] lMensaje_enviados = repartidor.mensaje_enviado.toArray();
			for(int i = 0; i < lMensaje_enviados.length; i++) {
				lMensaje_enviados[i].setRemitente(null);
			}
			return delete(repartidor);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Repartidor repartidor, org.orm.PersistentSession session)throws PersistentException {
		try {
			basedatos.Pedido[] lPedidoss = repartidor.pedidos.toArray();
			for(int i = 0; i < lPedidoss.length; i++) {
				lPedidoss[i].setRepartidor(null);
			}
			basedatos.Mensaje[] lMensaje_recibidos = repartidor.mensaje_recibido.toArray();
			for(int i = 0; i < lMensaje_recibidos.length; i++) {
				lMensaje_recibidos[i].setDestinatario(null);
			}
			basedatos.Mensaje[] lMensaje_enviados = repartidor.mensaje_enviado.toArray();
			for(int i = 0; i < lMensaje_enviados.length; i++) {
				lMensaje_enviados[i].setRemitente(null);
			}
			try {
				session.delete(repartidor);
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
	
	public static boolean refresh(basedatos.Repartidor repartidor) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().refresh(repartidor);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basedatos.Repartidor repartidor) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().evict(repartidor);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Repartidor loadRepartidorByCriteria(RepartidorCriteria repartidorCriteria) {
		Repartidor[] repartidors = listRepartidorByCriteria(repartidorCriteria);
		if(repartidors == null || repartidors.length == 0) {
			return null;
		}
		return repartidors[0];
	}
	
	public static Repartidor[] listRepartidorByCriteria(RepartidorCriteria repartidorCriteria) {
		return repartidorCriteria.listRepartidor();
	}
}
