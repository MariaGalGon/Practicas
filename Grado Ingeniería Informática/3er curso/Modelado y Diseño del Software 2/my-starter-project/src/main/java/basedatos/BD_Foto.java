package basedatos;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Foto;

public class BD_Foto {
	public BDPrincipal _bD_Principal_Comentario;
	public Vector<Foto> _foto = new Vector<Foto>();

	public void eliminar_fotos(int aIdProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Producto p = ProductoDAO.getProductoByORMID(aIdProducto);
			Foto[] arrayFotos = p.fotos.toArray();
			for(int i = 0; i<arrayFotos.length; i++){
				FotoDAO.delete(arrayFotos[i]);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}