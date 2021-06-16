package basedatos;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Comentario;

public class BD_Comentario {
	public BDPrincipal _bD_Principal_Comentario;
	public Vector<Comentario> _comentario = new Vector<Comentario>();

	public void publicar_comentario(int aIdUsuario, String aTexto, int aValoracion, int aIdProducto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {

			Comentario c = ComentarioDAO.createComentario();
			c.setCibernauta(CibernautaDAO.getCibernautaByORMID(aIdUsuario));
			c.setProducto(ProductoDAO.getProductoByORMID(aIdProducto));
			c.setTexto(aTexto);
			c.setValoracion(aValoracion);
			ComentarioDAO.save(c);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}