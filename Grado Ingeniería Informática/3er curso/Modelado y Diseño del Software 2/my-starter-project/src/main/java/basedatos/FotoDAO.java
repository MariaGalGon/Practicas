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

public class FotoDAO {
	public static Foto loadFotoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadFotoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto getFotoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getFotoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto loadFotoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadFotoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto getFotoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getFotoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto loadFotoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Foto) session.load(basedatos.Foto.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto getFotoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Foto) session.get(basedatos.Foto.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto loadFotoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Foto) session.load(basedatos.Foto.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto getFotoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Foto) session.get(basedatos.Foto.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFoto(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryFoto(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFoto(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryFoto(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto[] listFotoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listFotoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto[] listFotoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listFotoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFoto(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Foto as Foto");
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
	
	public static List queryFoto(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Foto as Foto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Foto", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto[] listFotoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFoto(session, condition, orderBy);
			return (Foto[]) list.toArray(new Foto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto[] listFotoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFoto(session, condition, orderBy, lockMode);
			return (Foto[]) list.toArray(new Foto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto loadFotoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadFotoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto loadFotoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadFotoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto loadFotoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Foto[] fotos = listFotoByQuery(session, condition, orderBy);
		if (fotos != null && fotos.length > 0)
			return fotos[0];
		else
			return null;
	}
	
	public static Foto loadFotoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Foto[] fotos = listFotoByQuery(session, condition, orderBy, lockMode);
		if (fotos != null && fotos.length > 0)
			return fotos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFotoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateFotoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFotoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateFotoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFotoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Foto as Foto");
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
	
	public static java.util.Iterator iterateFotoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Foto as Foto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Foto", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto createFoto() {
		return new basedatos.Foto();
	}
	
	public static boolean save(basedatos.Foto foto) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().saveObject(foto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basedatos.Foto foto) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().deleteObject(foto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Foto foto)throws PersistentException {
		try {
			if (foto.getProducto() != null) {
				foto.getProducto().fotos.remove(foto);
			}
			
			return delete(foto);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Foto foto, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (foto.getProducto() != null) {
				foto.getProducto().fotos.remove(foto);
			}
			
			try {
				session.delete(foto);
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
	
	public static boolean refresh(basedatos.Foto foto) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().refresh(foto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basedatos.Foto foto) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().evict(foto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Foto loadFotoByCriteria(FotoCriteria fotoCriteria) {
		Foto[] fotos = listFotoByCriteria(fotoCriteria);
		if(fotos == null || fotos.length == 0) {
			return null;
		}
		return fotos[0];
	}
	
	public static Foto[] listFotoByCriteria(FotoCriteria fotoCriteria) {
		return fotoCriteria.listFoto();
	}
}
