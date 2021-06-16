package basedatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Anuncio;

public class BD_Anuncio {
	public BDPrincipal _bD_Principal_Anuncio;
	public Vector<Anuncio> _anuncio = new Vector<Anuncio>();

	public void guardar_anuncio(String aNombre, String aEnlace, int aAltura, int aAnchura, String aImagen, int aIdAnuncio) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Anuncio a = null;
			if(aIdAnuncio!=-1) { //Anuncio existe
				a = AnuncioDAO.getAnuncioByORMID(aIdAnuncio);

				//faltan fotos y categorias
			}else { //Producto no existe
				a = AnuncioDAO.createAnuncio();

			}
			a.setNombre(aNombre);
			a.setEnlace(aEnlace);
			a.setAltura(aAltura);
			a.setAnchura(aAnchura);
			a.setImagen(aImagen);

			AnuncioDAO.save(a);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Anuncio[] cargar_anuncios() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Anuncio[] anuncios = null;
		try {
			List<Anuncio> a = AnuncioDAO.queryAnuncio(null, null);
			anuncios = new Anuncio[a.size()];
			for(int i = 0; i < a.size(); i++) {
				anuncios[i] = a.get(i);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return anuncios;
	}

	public void eliminar_anuncio(int aIdAnuncio) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			Anuncio a = AnuncioDAO.getAnuncioByORMID(aIdAnuncio);
			AnuncioDAO.delete(a);


			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}