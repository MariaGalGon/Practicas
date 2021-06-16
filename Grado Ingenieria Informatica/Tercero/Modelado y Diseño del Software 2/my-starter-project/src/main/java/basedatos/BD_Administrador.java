package basedatos;

import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Administrador {
	public BDPrincipal _bD_Principal_Administrador;
	public Administrador _administrador;

	public Administrador iniciar_sesion(String aCorreo, String aContrasenia) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Administrador usuario = null;

		try {
			List<Administrador> administradores = AdministradorDAO.queryAdministrador(null, null);

			for(Administrador x : administradores) {
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
			List<Administrador> administradores = AdministradorDAO.queryAdministrador(null, null);

			for(Administrador x : administradores) {
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
			Administrador a = new Administrador();
			a = AdministradorDAO.getAdministradorByORMID(aIdUsuario);

			a.setNombre(aDatos[1]);
			a.setApellidos(aDatos[2]);
			a.setCorreo(aDatos[3]);
			a.setContrasena(aDatos[4]);
			a.setFoto(aDatos[5]);

			AdministradorDAO.save(a);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Administrador cargar_admin(int aIdAdmin) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Administrador a = null;

		try {
			a = AdministradorDAO.getAdministradorByORMID(aIdAdmin);			

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return a;
	}

	public void existeAdmin() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			List<Administrador> administradores = AdministradorDAO.queryAdministrador(null, null);

			if(administradores.isEmpty()) {
				Administrador a = AdministradorDAO.createAdministrador();
				a.setNombre("Admin");
				a.setApellidos("Por defecto");
				a.setCorreo("admin@electrizon.es");
				a.setContrasena("1234");

				AdministradorDAO.save(a);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}