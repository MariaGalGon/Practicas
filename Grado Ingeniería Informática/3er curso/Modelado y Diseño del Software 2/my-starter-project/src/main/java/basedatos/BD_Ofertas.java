package basedatos;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Oferta;

public class BD_Ofertas {
	public BDPrincipal _bD_Principal_ofertas;
	public Vector<Oferta> _ofertas = new Vector<Oferta>();

	public Oferta[] cargar_lista_ofertas() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Oferta[] ofertas = null;
		try {
			List<Oferta> o = OfertaDAO.queryOferta(null, null);
			ofertas = new Oferta[o.size()];
			for(int i = 0; i < o.size(); i++) {
				ofertas[i] = o.get(i);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return ofertas;
	}

	public Oferta[] cargar_lista_seleccionar_ofertas() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Oferta[] ofertas = null;
		try {
			List<Oferta> o = OfertaDAO.queryOferta(null, null);
			ofertas = new Oferta[o.size()];
			for(int i = 0; i < o.size(); i++) {
				ofertas[i] = o.get(i);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return ofertas;
	}

	public void eliminar_ofertas(int[] aIdOfertas) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			for(int i = 0; i< aIdOfertas.length; i++) {

				Oferta o = OfertaDAO.getOfertaByORMID(aIdOfertas[i]);
				OfertaDAO.delete(o);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void guardar_ofertas(Date aFecha, String aDescripcion, String aCondiciones, String aNombre, int aIdOferta) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Oferta o = null;
			if(aIdOferta!=-1) { //Oferta existe
				o = OfertaDAO.getOfertaByORMID(aIdOferta);
				o.setNombre(aNombre);
				double d = Double.parseDouble(aCondiciones);
				o.setDescuento(d);
				o.setDetalles(aDescripcion);
				o.setFechaCaducidad(aFecha);
			}else { //Oferta no existe
				o = OfertaDAO.createOferta();
				o.setNombre(aNombre);
				double d = Double.parseDouble(aCondiciones);
				o.setDescuento(d);
				o.setDetalles(aDescripcion);
				o.setFechaCaducidad(aFecha);
			}

			OfertaDAO.save(o);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Producto[] cargar_productos_asociados_oferta(int aIdOferta) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		Oferta o = null;

		try {
			o = OfertaDAO.getOfertaByORMID(aIdOferta);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return o.producto_asociado.toArray();
	}

	public void aniadir_productos_asociados_oferta(int[] aIdProductos, int aIdOfertas) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Oferta o = OfertaDAO.getOfertaByORMID(aIdOfertas);

			for(int i = 0; i< aIdProductos.length; i++) {
				Producto p = ProductoDAO.getProductoByORMID(aIdProductos[i]);
				if(!o.producto_asociado.contains(p))
					o.producto_asociado.add(p);
			}

			OfertaDAO.save(o);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void eliminar_producto_asociado(int[] aIdProductos, int aIdOferta) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Oferta o = OfertaDAO.getOfertaByORMID(aIdOferta);

			for(int i = 0; i< aIdProductos.length; i++) {
				Producto p = ProductoDAO.getProductoByORMID(aIdProductos[i]);
				o.producto_asociado.remove(p);

				OfertaDAO.save(o);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}