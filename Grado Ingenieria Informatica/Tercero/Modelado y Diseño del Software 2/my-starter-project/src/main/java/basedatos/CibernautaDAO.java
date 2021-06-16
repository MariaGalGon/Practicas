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

public class CibernautaDAO {
	public static Cibernauta loadCibernautaByORMID(int idUsuario) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadCibernautaByORMID(session, idUsuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta getCibernautaByORMID(int idUsuario) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getCibernautaByORMID(session, idUsuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta loadCibernautaByORMID(int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadCibernautaByORMID(session, idUsuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta getCibernautaByORMID(int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getCibernautaByORMID(session, idUsuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta loadCibernautaByORMID(PersistentSession session, int idUsuario) throws PersistentException {
		try {
			return (Cibernauta) session.load(basedatos.Cibernauta.class, new Integer(idUsuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta getCibernautaByORMID(PersistentSession session, int idUsuario) throws PersistentException {
		try {
			return (Cibernauta) session.get(basedatos.Cibernauta.class, new Integer(idUsuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta loadCibernautaByORMID(PersistentSession session, int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Cibernauta) session.load(basedatos.Cibernauta.class, new Integer(idUsuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta getCibernautaByORMID(PersistentSession session, int idUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Cibernauta) session.get(basedatos.Cibernauta.class, new Integer(idUsuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCibernauta(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryCibernauta(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCibernauta(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryCibernauta(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta[] listCibernautaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listCibernautaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta[] listCibernautaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listCibernautaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCibernauta(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Cibernauta as Cibernauta");
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
	
	public static List queryCibernauta(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Cibernauta as Cibernauta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Cibernauta", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta[] listCibernautaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCibernauta(session, condition, orderBy);
			return (Cibernauta[]) list.toArray(new Cibernauta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta[] listCibernautaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCibernauta(session, condition, orderBy, lockMode);
			return (Cibernauta[]) list.toArray(new Cibernauta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta loadCibernautaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadCibernautaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta loadCibernautaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadCibernautaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta loadCibernautaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Cibernauta[] cibernautas = listCibernautaByQuery(session, condition, orderBy);
		if (cibernautas != null && cibernautas.length > 0)
			return cibernautas[0];
		else
			return null;
	}
	
	public static Cibernauta loadCibernautaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Cibernauta[] cibernautas = listCibernautaByQuery(session, condition, orderBy, lockMode);
		if (cibernautas != null && cibernautas.length > 0)
			return cibernautas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCibernautaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateCibernautaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCibernautaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateCibernautaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCibernautaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Cibernauta as Cibernauta");
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
	
	public static java.util.Iterator iterateCibernautaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Cibernauta as Cibernauta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Cibernauta", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta createCibernauta() {
		return new basedatos.Cibernauta();
	}
	
	public static boolean save(basedatos.Cibernauta cibernauta) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().saveObject(cibernauta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basedatos.Cibernauta cibernauta) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().deleteObject(cibernauta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Cibernauta cibernauta)throws PersistentException {
		try {
			basedatos.Comentario[] lComentarioss = cibernauta.comentarios.toArray();
			for(int i = 0; i < lComentarioss.length; i++) {
				lComentarioss[i].setCibernauta(null);
			}
			basedatos.Pedido[] lComprados = cibernauta.comprado.toArray();
			for(int i = 0; i < lComprados.length; i++) {
				lComprados[i].setComprado_por(null);
			}
			basedatos.Mensaje[] lMensaje_recibidos = cibernauta.mensaje_recibido.toArray();
			for(int i = 0; i < lMensaje_recibidos.length; i++) {
				lMensaje_recibidos[i].setDestinatario(null);
			}
			basedatos.Mensaje[] lMensaje_enviados = cibernauta.mensaje_enviado.toArray();
			for(int i = 0; i < lMensaje_enviados.length; i++) {
				lMensaje_enviados[i].setRemitente(null);
			}
			return delete(cibernauta);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Cibernauta cibernauta, org.orm.PersistentSession session)throws PersistentException {
		try {
			basedatos.Comentario[] lComentarioss = cibernauta.comentarios.toArray();
			for(int i = 0; i < lComentarioss.length; i++) {
				lComentarioss[i].setCibernauta(null);
			}
			basedatos.Pedido[] lComprados = cibernauta.comprado.toArray();
			for(int i = 0; i < lComprados.length; i++) {
				lComprados[i].setComprado_por(null);
			}
			basedatos.Mensaje[] lMensaje_recibidos = cibernauta.mensaje_recibido.toArray();
			for(int i = 0; i < lMensaje_recibidos.length; i++) {
				lMensaje_recibidos[i].setDestinatario(null);
			}
			basedatos.Mensaje[] lMensaje_enviados = cibernauta.mensaje_enviado.toArray();
			for(int i = 0; i < lMensaje_enviados.length; i++) {
				lMensaje_enviados[i].setRemitente(null);
			}
			try {
				session.delete(cibernauta);
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
	
	public static boolean refresh(basedatos.Cibernauta cibernauta) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().refresh(cibernauta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basedatos.Cibernauta cibernauta) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().evict(cibernauta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cibernauta loadCibernautaByCriteria(CibernautaCriteria cibernautaCriteria) {
		Cibernauta[] cibernautas = listCibernautaByCriteria(cibernautaCriteria);
		if(cibernautas == null || cibernautas.length == 0) {
			return null;
		}
		return cibernautas[0];
	}
	
	public static Cibernauta[] listCibernautaByCriteria(CibernautaCriteria cibernautaCriteria) {
		return cibernautaCriteria.listCibernauta();
	}
}
