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

public class ProductoDAO {
	public static Producto loadProductoByORMID(int idProducto) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadProductoByORMID(session, idProducto);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto getProductoByORMID(int idProducto) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getProductoByORMID(session, idProducto);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto loadProductoByORMID(int idProducto, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadProductoByORMID(session, idProducto, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto getProductoByORMID(int idProducto, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return getProductoByORMID(session, idProducto, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto loadProductoByORMID(PersistentSession session, int idProducto) throws PersistentException {
		try {
			return (Producto) session.load(basedatos.Producto.class, new Integer(idProducto));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto getProductoByORMID(PersistentSession session, int idProducto) throws PersistentException {
		try {
			return (Producto) session.get(basedatos.Producto.class, new Integer(idProducto));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto loadProductoByORMID(PersistentSession session, int idProducto, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Producto) session.load(basedatos.Producto.class, new Integer(idProducto), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto getProductoByORMID(PersistentSession session, int idProducto, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Producto) session.get(basedatos.Producto.class, new Integer(idProducto), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProducto(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryProducto(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProducto(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return queryProducto(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto[] listProductoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listProductoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto[] listProductoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return listProductoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProducto(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Producto as Producto");
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
	
	public static List queryProducto(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Producto as Producto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Producto", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto[] listProductoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProducto(session, condition, orderBy);
			return (Producto[]) list.toArray(new Producto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto[] listProductoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProducto(session, condition, orderBy, lockMode);
			return (Producto[]) list.toArray(new Producto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto loadProductoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadProductoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto loadProductoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return loadProductoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto loadProductoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Producto[] productos = listProductoByQuery(session, condition, orderBy);
		if (productos != null && productos.length > 0)
			return productos[0];
		else
			return null;
	}
	
	public static Producto loadProductoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Producto[] productos = listProductoByQuery(session, condition, orderBy, lockMode);
		if (productos != null && productos.length > 0)
			return productos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProductoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateProductoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS2v4GalvezRosenovPersistentManager.instance().getSession();
			return iterateProductoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Producto as Producto");
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
	
	public static java.util.Iterator iterateProductoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basedatos.Producto as Producto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Producto", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto createProducto() {
		return new basedatos.Producto();
	}
	
	public static boolean save(basedatos.Producto producto) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().saveObject(producto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basedatos.Producto producto) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().deleteObject(producto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Producto producto)throws PersistentException {
		try {
			if (producto.getOferta_aplicada() != null) {
				producto.getOferta_aplicada().producto_asociado.remove(producto);
			}
			
			basedatos.Foto[] lFotoss = producto.fotos.toArray();
			for(int i = 0; i < lFotoss.length; i++) {
				lFotoss[i].setProducto(null);
			}
			basedatos.Item[] lCantidads = producto.cantidad.toArray();
			for(int i = 0; i < lCantidads.length; i++) {
				lCantidads[i].setProductos_pedido(null);
			}
			basedatos.Comentario[] lComentarioss = producto.comentarios.toArray();
			for(int i = 0; i < lComentarioss.length; i++) {
				lComentarioss[i].setProducto(null);
			}
			basedatos.Categoria[] lPertenece_a_categorias = producto.pertenece_a_categoria.toArray();
			for(int i = 0; i < lPertenece_a_categorias.length; i++) {
				lPertenece_a_categorias[i].producto_asociado.remove(producto);
			}
			return delete(producto);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basedatos.Producto producto, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (producto.getOferta_aplicada() != null) {
				producto.getOferta_aplicada().producto_asociado.remove(producto);
			}
			
			basedatos.Foto[] lFotoss = producto.fotos.toArray();
			for(int i = 0; i < lFotoss.length; i++) {
				lFotoss[i].setProducto(null);
			}
			basedatos.Item[] lCantidads = producto.cantidad.toArray();
			for(int i = 0; i < lCantidads.length; i++) {
				lCantidads[i].setProductos_pedido(null);
			}
			basedatos.Comentario[] lComentarioss = producto.comentarios.toArray();
			for(int i = 0; i < lComentarioss.length; i++) {
				lComentarioss[i].setProducto(null);
			}
			basedatos.Categoria[] lPertenece_a_categorias = producto.pertenece_a_categoria.toArray();
			for(int i = 0; i < lPertenece_a_categorias.length; i++) {
				lPertenece_a_categorias[i].producto_asociado.remove(producto);
			}
			try {
				session.delete(producto);
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
	
	public static boolean refresh(basedatos.Producto producto) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().refresh(producto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basedatos.Producto producto) throws PersistentException {
		try {
			MDS2v4GalvezRosenovPersistentManager.instance().getSession().evict(producto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Producto loadProductoByCriteria(ProductoCriteria productoCriteria) {
		Producto[] productos = listProductoByCriteria(productoCriteria);
		if(productos == null || productos.length == 0) {
			return null;
		}
		return productos[0];
	}
	
	public static Producto[] listProductoByCriteria(ProductoCriteria productoCriteria) {
		return productoCriteria.listProducto();
	}
}
