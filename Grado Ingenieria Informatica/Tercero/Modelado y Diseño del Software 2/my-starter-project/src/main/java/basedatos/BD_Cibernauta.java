package basedatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Cibernauta;

public class BD_Cibernauta {
	public BDPrincipal _bD_Principal_Cibernauta;
	public Vector<Cibernauta> _cibernautas = new Vector<Cibernauta>();

	public void guardar_datos(String[] aDatos, int aIdUsuario, String aFoto) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			Cibernauta c = new Cibernauta();
			c = CibernautaDAO.getCibernautaByORMID(aIdUsuario);

			c.setNombre(aDatos[0]);
			c.setApellidos(aDatos[1]);
			c.setCorreo(aDatos[2]);
			c.setContrasena(aDatos[3]);			
			c.setDireccion(aDatos[4]);
			c.setTarjeta(Integer.parseInt(aDatos[5]));
			c.setCvv(Integer.parseInt(aDatos[6]));
			c.setFoto(aFoto);

			CibernautaDAO.save(c);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void confirmar_baja(int aIdUsuario) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			Cibernauta c = new Cibernauta();
			c = CibernautaDAO.getCibernautaByORMID(aIdUsuario);

			c.setEstado(false);

			CibernautaDAO.save(c);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public int buscar_destinatario(String aDestinatario_mail) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		int destinatario = -1;

		try {
			List<Usuario> usuarios = UsuarioDAO.queryUsuario(null, null);

			for(Usuario x : usuarios) {
				if(x.getCorreo().equals(aDestinatario_mail) ) {
					destinatario = x.getIdUsuario();
					break;
				}
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return destinatario;
	}

	public Cibernauta iniciar_sesion(String aCorreo, String aContrasenia) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Cibernauta usuario = null;

		try {
			List<Cibernauta> cibernautas = CibernautaDAO.queryCibernauta(null, null);

			for(Cibernauta x : cibernautas) {
				if(x.getCorreo().equals(aCorreo) && x.getContrasena().equals(aContrasenia) && x.getEstado()) {
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

	public boolean registrarse(String[] aDatos) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		boolean creada = true;
		Cibernauta c = null;

		try {
			List<Cibernauta> cibernautas = CibernautaDAO.queryCibernauta(null, null);

			for(Cibernauta x : cibernautas) {
				if(x.getCorreo().equals(aDatos[1])) {
					creada = false;
					break;
				}
			}

			if(creada) {
				c = CibernautaDAO.createCibernauta();
				c.setUsuario(aDatos[0]);
				c.setCorreo(aDatos[1]);
				c.setContrasena(aDatos[2]);
				c.setNombre(aDatos[3]);
				c.setApellidos(aDatos[4]);
				c.setDireccion(aDatos[5]);
				c.setTarjeta(Integer.parseInt(aDatos[6]));
				c.setFoto(aDatos[7]);
				c.setEstado(true);

				CibernautaDAO.save(c);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
			return false;
		}

		return creada;
	}

	public Cibernauta cargar_cibernauta(int aIdCibernauta) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Cibernauta c = null;

		try {
			c = CibernautaDAO.getCibernautaByORMID(aIdCibernauta);			

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return c;
	}

	public String recuperar_contrasenia(String aCorreo) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		String contrasenia = null;

		try {
			List<Cibernauta> cibernautas = CibernautaDAO.queryCibernauta(null, null);

			for(Cibernauta x : cibernautas) {
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

	public Cibernauta[] cargar_cibernautas() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Cibernauta[] cibernautas = null;
		try {
			List<Cibernauta> c = CibernautaDAO.queryCibernauta(null, null);
			cibernautas = new Cibernauta[c.size()];
			for(int i = 0; i < c.size(); i++) {
				cibernautas[i] = c.get(i);

			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return cibernautas;
	}

	public String cargar_remitente(int aIdRemitente) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		String remitente = null;
		try {
			remitente = CibernautaDAO.getCibernautaByORMID(aIdRemitente).getCorreo();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return remitente;
	}
}