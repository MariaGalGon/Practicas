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

public class Encargado_comprasDAO {
	public static Encargado_compras loadEncargado_comprasByORMID(int idUsuario) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadEncargado_comprasByORMID(session, idUsuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras getEncargado_comprasByORMID(int idUsuario) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getEncargado_comprasByORMID(session, idUsuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByORMID(int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadEncargado_comprasByORMID(session, idUsuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras getEncargado_comprasByORMID(int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getEncargado_comprasByORMID(session, idUsuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByORMID(PersistentSession session, int idUsuario) throws PersistentException {
		try {
			return (Encargado_compras) session.load(basedatos.Encargado_compras.class, new Integer(idUsuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras getEncargado_comprasByORMID(PersistentSession session, int idUsuario) throws PersistentException {
		try {
			return (Encargado_compras) session.get(basedatos.Encargado_compras.class, new Integer(idUsuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByORMID(PersistentSession session, int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Encargado_compras) session.load(basedatos.Encargado_compras.class, new Integer(idUsuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras getEncargado_comprasByORMID(PersistentSession session, int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Encargado_compras) session.get(basedatos.Encargado_compras.class, new Integer(idUsuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEncargado_compras(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryEncargado_compras(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEncargado_compras(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryEncargado_compras(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras[] listEncargado_comprasByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listEncargado_comprasByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras[] listEncargado_comprasByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listEncargado_comprasByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEncargado_compras(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Encargado_compras as Encargado_compras");
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
	
	public static List queryEncargado_compras(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Encargado_compras as Encargado_compras");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Encargado_compras", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras[] listEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryEncargado_compras(session, condition, orderBy);
			return (Encargado_compras[]) list.toArray(new Encargado_compras[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras[] listEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryEncargado_compras(session, condition, orderBy, lockMode);
			return (Encargado_compras[]) list.toArray(new Encargado_compras[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadEncargado_comprasByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadEncargado_comprasByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Encargado_compras[] encargado_comprases = listEncargado_comprasByQuery(session, condition, orderBy);
		if (encargado_comprases != null && encargado_comprases.length > 0)
			return encargado_comprases[0];
		else
			return null;
	}
	
	public static Encargado_compras loadEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Encargado_compras[] encargado_comprases = listEncargado_comprasByQuery(session, condition, orderBy, lockMode);
		if (encargado_comprases != null && encargado_comprases.length > 0)
			return encargado_comprases[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEncargado_comprasByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateEncargado_comprasByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEncargado_comprasByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateEncargado_comprasByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Encargado_compras as Encargado_compras");
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
	
	public static java.util.Iterator iterateEncargado_comprasByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Encargado_compras as Encargado_compras");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Encargado_compras", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras createEncargado_compras() {
		return new basedatos.Encargado_compras();
	}
	
	public static boolean save(basedatos.Encargado_compras encargado_compras) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().saveObject(encargado_compras);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basedatos.Encargado_compras encargado_compras) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().deleteObject(encargado_compras);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Encargado_compras encargado_compras)throws PersistentException {
		try {
			basedatos.Pedido[] lPedidoss = encargado_compras.pedidos.toArray();
			for(int i = 0; i < lPedidoss.length; i++) {
				lPedidoss[i].setEncargado_compras(null);
			}
			basedatos.Mensaje[] lMensaje_recibidos = encargado_compras.mensaje_recibido.toArray();
			for(int i = 0; i < lMensaje_recibidos.length; i++) {
				lMensaje_recibidos[i].setDestinatario(null);
			}
			basedatos.Mensaje[] lMensaje_enviados = encargado_compras.mensaje_enviado.toArray();
			for(int i = 0; i < lMensaje_enviados.length; i++) {
				lMensaje_enviados[i].setRemitente(null);
			}
			return delete(encargado_compras);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Encargado_compras encargado_compras, org.orm.PersistentSession session)throws PersistentException {
		try {
			basedatos.Pedido[] lPedidoss = encargado_compras.pedidos.toArray();
			for(int i = 0; i < lPedidoss.length; i++) {
				lPedidoss[i].setEncargado_compras(null);
			}
			basedatos.Mensaje[] lMensaje_recibidos = encargado_compras.mensaje_recibido.toArray();
			for(int i = 0; i < lMensaje_recibidos.length; i++) {
				lMensaje_recibidos[i].setDestinatario(null);
			}
			basedatos.Mensaje[] lMensaje_enviados = encargado_compras.mensaje_enviado.toArray();
			for(int i = 0; i < lMensaje_enviados.length; i++) {
				lMensaje_enviados[i].setRemitente(null);
			}
			try {
				session.delete(encargado_compras);
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
	
	public static boolean refresh(basedatos.Encargado_compras encargado_compras) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().refresh(encargado_compras);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basedatos.Encargado_compras encargado_compras) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().evict(encargado_compras);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Encargado_compras loadEncargado_comprasByCriteria(Encargado_comprasCriteria encargado_comprasCriteria) {
		Encargado_compras[] encargado_comprases = listEncargado_comprasByCriteria(encargado_comprasCriteria);
		if(encargado_comprases == null || encargado_comprases.length == 0) {
			return null;
		}
		return encargado_comprases[0];
	}
	
	public static Encargado_compras[] listEncargado_comprasByCriteria(Encargado_comprasCriteria encargado_comprasCriteria) {
		return encargado_comprasCriteria.listEncargado_compras();
	}
}
