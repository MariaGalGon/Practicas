package basedatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Producto;

public class BD_Producto {
	public BDPrincipal _bD_Principal_productos;
	public Vector<Producto> _productos = new Vector<Producto>();

	public Producto[] cargar_productos_destacados() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Producto[] productos = null;
		try {
			List<Producto> p = ProductoDAO.queryProducto(null, null);
			productos = new Producto[p.size()];
			for(int i = 0; i < p.size(); i++) {
				productos[i] = p.get(i);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return productos;
	}

	public Producto[] buscar_producto(String aBusqueda) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		Producto[] productos = null;
		try {
			List<Producto> p = ProductoDAO.queryProducto(null, null);
			int tam = 0;
			for(int i = 0; i < p.size(); i++) {
				if(p.get(i).getNombre().toLowerCase().contains(aBusqueda.toLowerCase()))
					tam++;
			}
			int j=0;
			productos = new Producto[tam];

			for(int i = 0; i < p.size(); i++) {
				if(p.get(i).getNombre().toLowerCase().contains(aBusqueda.toLowerCase())) {
					productos[j] = p.get(i);					
					j++;
				}
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return productos;
	}

	public void eliminar_producto_asociado(int[] aIdProductos, int aIdOferta) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Oferta o = OfertaDAO.getOfertaByORMID(aIdOferta);

			for(int i = 0; i< aIdProductos.length; i++) {
				Producto p = ProductoDAO.getProductoByORMID(aIdProductos[i]);
				p.setOferta_aplicada(null);
				ProductoDAO.save(p);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Producto[] cargar_productos_aniadir_oferta(int aIdOferta) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Producto[] productos = null;
		try {
			List<Producto> p = ProductoDAO.queryProducto(null, null);
			productos = new Producto[p.size()];
			for(int i = 0; i < p.size(); i++) {
				productos[i] = p.get(i);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return productos;
	}

	public void aniadir_productos_asociados_oferta(int[] aIdProductos, int aIdOferta) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Oferta o = OfertaDAO.getOfertaByORMID(aIdOferta);

			for(int i = 0; i< aIdProductos.length; i++) {
				Producto p = ProductoDAO.getProductoByORMID(aIdProductos[i]);
				if(!p.getOferta_aplicada().equals(o))
					p.setOferta_aplicada(o);
				ProductoDAO.save(p);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Producto[] buscar_producto_aniadir_oferta(String aNombreProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Producto[] productos = null;
		try {
			List<Producto> p = ProductoDAO.queryProducto(null, null);
			int tam = 0;
			for(int i = 0; i < p.size(); i++) {
				if(p.get(i).getNombre().toLowerCase().contains(aNombreProducto.toLowerCase()))
					tam++;
			}
			int j=0;
			productos = new Producto[tam];

			for(int i = 0; i < p.size(); i++) {
				if(p.get(i).getNombre().toLowerCase().contains(aNombreProducto.toLowerCase())) {
					productos[j] = p.get(i);					
					j++;
				}
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return productos;
	}

	public void eliminar_productos_asociados_categoria(int[] aIdProductos, int aIdCategoria) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Categoria c = CategoriaDAO.getCategoriaByORMID(aIdCategoria);

			for(int i = 0; i< aIdProductos.length; i++) {
				Producto p = ProductoDAO.getProductoByORMID(aIdProductos[i]);
				p.pertenece_a_categoria.remove(c);
				ProductoDAO.save(p);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Producto[] cargar_productos_aniadir_categoria(int aIdCategoria) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Producto[] productos = null;
		try {
			List<Producto> p = ProductoDAO.queryProducto(null, null);
			productos = new Producto[p.size()];
			for(int i = 0; i < p.size(); i++) {
				productos[i] = p.get(i);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return productos;
	}

	public void aniadir_productos_asociados_categoria(int[] aIdProductos, int aIdCategoria) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Categoria c = CategoriaDAO.getCategoriaByORMID(aIdCategoria);

			for(int i = 0; i< aIdProductos.length; i++) {
				Producto p = ProductoDAO.getProductoByORMID(aIdProductos[i]);
				if(!p.pertenece_a_categoria.contains(c))
					p.pertenece_a_categoria.add(c);
				ProductoDAO.save(p);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Producto[] buscar_producto_aniadir_categoria(String aNombreProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Producto[] productos = null;
		try {
			List<Producto> p = ProductoDAO.queryProducto(null, null);
			int tam = 0;
			for(int i = 0; i < p.size(); i++) {
				if(p.get(i).getNombre().toLowerCase().contains(aNombreProducto.toLowerCase()))
					tam++;
			}
			int j=0;
			productos = new Producto[tam];

			for(int i = 0; i < p.size(); i++) {
				if(p.get(i).getNombre().toLowerCase().contains(aNombreProducto.toLowerCase())) {
					productos[j] = p.get(i);					
					j++;
				}
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return productos;
	}

	public Producto cargar_datos_producto(int aIdProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Producto p = null;
		try {
			p = ProductoDAO.getProductoByORMID(aIdProducto);
		} catch (Exception e) {
			t.rollback();
		}

		return p;
	}

	public Producto cargar_producto(int aIdProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		Producto p = null;
		try {
			p = ProductoDAO.getProductoByORMID(aIdProducto);
		} catch (Exception e) {
			t.rollback();
		}

		return p;
	}

	public void guardar_producto(String[] aFotos, double aPrecio, String aNombre, String aInformacion, String aCaracteristicas, int[] aIdCategorias, int aIdProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Producto p = null;
			if(aIdProducto!=-1) { //Producto existe
				p = ProductoDAO.getProductoByORMID(aIdProducto);
				p.setNombre(aNombre);
				p.setInformacion(aInformacion);
				p.setPrecio(aPrecio);
				p.setDescripcion(aCaracteristicas);
				p.fotos.clear();
				if(aFotos[0]!=null)
					p.setImagen(aFotos[0]);
				
				if(aIdCategorias != null) {
					for(int i = 0; i<aIdCategorias.length; i++) {
						Categoria c = CategoriaDAO.getCategoriaByORMID(Math.abs(aIdCategorias[i]));
						if(aIdCategorias[i] <0) {
							p.pertenece_a_categoria.remove(c);
						}else if(!p.pertenece_a_categoria.contains(c))
							p.pertenece_a_categoria.add(c);
					}
				}
				
				for(int i = 0 ; i< aFotos.length;i++) {
					Foto f = FotoDAO.createFoto();
					f.setDireccion(aFotos[i]);
					p.fotos.add(f);
				}

				//faltan fotos y categorias
			}else { //Producto no existe
				p = ProductoDAO.createProducto();
				p.setPrecio(aPrecio);
				p.setNombre(aNombre);
				p.setInformacion(aInformacion);
				p.setDescripcion(aCaracteristicas);
				p.setValoracionMedia(0);
				
				

				if(aIdCategorias != null) {
					for(int i = 0; i<aIdCategorias.length; i++) {
						Categoria c = CategoriaDAO.getCategoriaByORMID(Math.abs(aIdCategorias[i]));
						if(aIdCategorias[i] <0) {
							p.pertenece_a_categoria.remove(c);
						}else if(!p.pertenece_a_categoria.contains(c))
							p.pertenece_a_categoria.add(c);
					}
				}
				
				
				if(aFotos[0]!=null)
					p.setImagen(aFotos[0]);
				else {
					
				}
				
				for(int i = 0; i<aFotos.length; i++) {
					Foto f = FotoDAO.createFoto();
					f.setDireccion(aFotos[i]);
					p.fotos.add(f);
				}

			}

			ProductoDAO.save(p);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Producto[] cargar_productos() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Producto[] productos = null;
		try {
			List<Producto> p = ProductoDAO.queryProducto(null, null);
			productos = new Producto[p.size()];
			for(int i = 0; i < p.size(); i++) {
				productos[i] = p.get(i);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return productos;
	}

	public void eliminar_producto_catalogo(int aIdProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {

			Producto p = ProductoDAO.getProductoByORMID(aIdProducto);
			p.fotos.clear();
			ProductoDAO.deleteAndDissociate(p);


			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}