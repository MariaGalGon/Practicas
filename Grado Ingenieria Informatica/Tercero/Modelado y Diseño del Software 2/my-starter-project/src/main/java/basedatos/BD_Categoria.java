package basedatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Categoria;

public class BD_Categoria {
	public BDPrincipal _bD_Principal_Categoria;
	public Vector<Categoria> _categoria = new Vector<Categoria>();

	public Categoria[] cargar_categorias_combobox() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Categoria[] categorias = null;
		try {
			List<Categoria> c = CategoriaDAO.queryCategoria(null, null);
			categorias = new Categoria[c.size()];
			for(int i = 0; i < c.size(); i++) {
				categorias[i] = c.get(i);

			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return categorias;
	}

	public Categoria[] cargar_lista_seleccionar_categorias() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Categoria[] categorias = null;
		try {
			List<Categoria> c = CategoriaDAO.queryCategoria(null, null);
			categorias = new Categoria[c.size()];
			for(int i = 0; i < c.size(); i++) {
				categorias[i] = c.get(i);

			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return categorias;
	}

	public void eliminar_categorias(int[] aIdCategorias) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			for(int i = 0; i<aIdCategorias.length; i++) {
				Categoria c = CategoriaDAO.getCategoriaByORMID(aIdCategorias[i]);
				CategoriaDAO.delete(c);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Categoria cargar_categoria(int aIdCategoria) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Categoria c = null;
		try {
			c = CategoriaDAO.getCategoriaByORMID(aIdCategoria);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return c;
	}

	public void guardar_categoria(String aNombre, int aIdCategoria) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Categoria c = null;
			if(aIdCategoria!=-1) { //Categoria existe
				c = CategoriaDAO.getCategoriaByORMID(aIdCategoria);
				c.setNombe(aNombre);
			}else { //Oferta no existe
				c = CategoriaDAO.createCategoria();
				c.setNombe(aNombre);
			}

			CategoriaDAO.save(c);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void eliminar_productos_asociados_categoria(int[] aIdProductos, int aIdCategoria) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Categoria c = CategoriaDAO.getCategoriaByORMID(aIdCategoria);

			for(int i = 0; i< aIdProductos.length; i++) {
				Producto p = ProductoDAO.getProductoByORMID(aIdProductos[i]);
				c.producto_asociado.remove(p);				

				CategoriaDAO.save(c);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void aniadir_productos_asociados_categoria(int[] aIdProductos, int aIdCategoria) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Categoria c = CategoriaDAO.getCategoriaByORMID(aIdCategoria);

			for(int i = 0; i< aIdProductos.length; i++) {
				Producto p = ProductoDAO.getProductoByORMID(aIdProductos[i]);
				if(!c.producto_asociado.contains(p))
					c.producto_asociado.add(p);
			}

			CategoriaDAO.save(c);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void guardar_categoria_producto(int[] aIdCategorias, int aIdProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Producto p = ProductoDAO.getProductoByORMID(aIdProducto);

			for(int i = 0; i< aIdCategorias.length; i++) {

				Categoria c = CategoriaDAO.getCategoriaByORMID(Math.abs(aIdCategorias[i]));
				if(aIdCategorias[i] <0) {
					c.producto_asociado.remove(p);
				}else if(!c.producto_asociado.contains(p))
					c.producto_asociado.add(p);
				CategoriaDAO.save(c);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Categoria[] buscar_categoria(String aBusqueda) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		Categoria[] categorias = null;
		try {
			List<Categoria> c = CategoriaDAO.queryCategoria(null, null);
			int tam = 0;
			for(int i = 0; i < c.size(); i++) {
				if(c.get(i).getNombe().toLowerCase().contains(aBusqueda.toLowerCase()))
					tam++;
			}
			int j=0;
			categorias = new Categoria[tam];

			for(int i = 0; i < c.size(); i++) {
				if(c.get(i).getNombe().toLowerCase().contains(aBusqueda.toLowerCase())) {
					categorias[j] = c.get(i);					
					j++;
				}
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return categorias;
	}

	public Categoria[] cargar_categorias() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Categoria[] categorias = null;
		try {
			List<Categoria> c = CategoriaDAO.queryCategoria(null, null);
			categorias = new Categoria[c.size()];
			for(int i = 0; i < c.size(); i++) {
				categorias[i] = c.get(i);

			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return categorias;
	}
}