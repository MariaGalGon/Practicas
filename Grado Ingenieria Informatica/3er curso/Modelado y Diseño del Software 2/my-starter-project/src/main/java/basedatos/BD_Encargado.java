package basedatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Encargado_compras;

public class BD_Encargado {
	public BDPrincipal _bD_Principal_trabajadores;
	public Vector<Encargado_compras> _encargado_comprases = new Vector<Encargado_compras>();

	public Encargado_compras iniciar_sesion(String aCorreo, String aContrasenia) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Encargado_compras usuario = null;

		try {
			List<Encargado_compras> encargados = Encargado_comprasDAO.queryEncargado_compras(null, null);
			for(Encargado_compras x : encargados) {

				if(x.getCorreo() == null || x.getContrasena() == null)
					continue;

				if(x.getCorreo().equals(aCorreo) && x.getContrasena().equals(aContrasenia)) {
					usuario = x;
					break;
				}
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return usuario;
	}

	public String recuperar_contrasenia(String aCorreo) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		String contrasenia = null;

		try {
			List<Encargado_compras> encargados = Encargado_comprasDAO.queryEncargado_compras(null, null);

			for(Encargado_compras x : encargados) {
				if(x.getCorreo().equals(aCorreo)) {
					contrasenia = x.getContrasena();
					break;
				}
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		return contrasenia;
	}

	public void guardar_datos(String[] aDatos, int aIdUsuario) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			Encargado_compras e = new Encargado_compras();
			e = Encargado_comprasDAO.getEncargado_comprasByORMID(aIdUsuario);

			e.setNombre(aDatos[1]);
			e.setApellidos(aDatos[2]);
			e.setCorreo(aDatos[3]);
			e.setContrasena(aDatos[4]);
			e.setFoto(aDatos[5]);

			Encargado_comprasDAO.save(e);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Encargado_compras cargar_encargado(int aIdEncargado) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Encargado_compras en = null;

		try {
			en = Encargado_comprasDAO.getEncargado_comprasByORMID(aIdEncargado);			

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return en;
	}

	public void guardar_trabajador(String aNombre, String aApellidos, String aCorreo, int aIdUsuario, String aFoto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Encargado_compras enc;

		try {
			if(aIdUsuario == -3) //Si es un repartidor nuevo abandonamos
				return;
			else if(aIdUsuario == -2) {//Creamos un encargado nuevo
				enc = Encargado_comprasDAO.createEncargado_compras();
			}else { //Comprobamos si es un repartidor existente
				boolean existe = false;

				List<Encargado_compras> lista = Encargado_comprasDAO.queryEncargado_compras(null, null);

				for(Encargado_compras e: lista) { 
					if(e.getIdUsuario() == aIdUsuario){
						existe = true;
						break;
					}
				}

				if(!existe)
					return;

				enc = Encargado_comprasDAO.getEncargado_comprasByORMID(aIdUsuario);
			}

			enc.setNombre(aNombre);
			enc.setApellidos(aApellidos);
			enc.setCorreo(aCorreo);
			enc.setContrasena("1234");
			enc.setFoto(aFoto);

			//FALTA FOTO
			Encargado_comprasDAO.save(enc);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Encargado_compras[] cargar_encargados() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Encargado_compras[] encargados = null;
		try {
			List<Encargado_compras> e = Encargado_comprasDAO.queryEncargado_compras(null, null);
			encargados  = new Encargado_compras[e.size()];
			for(int i = 0; i < e.size(); i++) {
				encargados[i] = e.get(i);

			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return encargados;
	}

	public void existeEncargado() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			List<Encargado_compras> encargados = Encargado_comprasDAO.queryEncargado_compras(null, null);

			if(encargados.isEmpty()) {
				Encargado_compras e = Encargado_comprasDAO.createEncargado_compras();
				e.setNombre("Encargado");
				e.setApellidos("Por defecto");
				e.setCorreo("encargado@electrizon.es");
				e.setContrasena("1234");

				Encargado_comprasDAO.save(e);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}