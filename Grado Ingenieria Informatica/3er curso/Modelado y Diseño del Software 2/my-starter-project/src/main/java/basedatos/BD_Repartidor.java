package basedatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Repartidor;

public class BD_Repartidor {
	public BDPrincipal _bD_Principal_Repartidor;
	public Vector<Repartidor> _repartidors = new Vector<Repartidor>();

	public Repartidor iniciar_sesion(String aCorreo, String aContrasenia) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Repartidor usuario = null;

		try {
			List<Repartidor> repartidores = RepartidorDAO.queryRepartidor(null, null);

			for(Repartidor x : repartidores) {
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
			List<Repartidor> repartidores = RepartidorDAO.queryRepartidor(null, null);

			for(Repartidor x : repartidores) {
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

	public void guardar_perfil(int aIsUsuario, String aNombreApellidos, String aCorreo) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			Repartidor r = new Repartidor();
			r = RepartidorDAO.getRepartidorByORMID(aIsUsuario);
			
			String[] nombreCompleto = aNombreApellidos.split(" ");
			
			if(nombreCompleto.length == 2) {
				r.setNombre(nombreCompleto[0]);
				r.setApellidos(nombreCompleto[1]);
			} else if(nombreCompleto.length == 3) {
				r.setNombre(nombreCompleto[0]);
				r.setApellidos(nombreCompleto[1] + " " + nombreCompleto[2]);
			} else if(nombreCompleto.length == 4) {
				r.setNombre(nombreCompleto[0] + " " + nombreCompleto[1]);
				r.setApellidos(nombreCompleto[2] + " " + nombreCompleto[3]);
			}
			r.setCorreo(aCorreo);

			RepartidorDAO.save(r);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void guardar_trabajador(String aNombre, String aApellidos, String aCorreo, int aIdUsuarios) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Repartidor rep;

		try {
			if(aIdUsuarios == -2) //Si es un encargado nuevo abandonamos
				return;
			else if(aIdUsuarios == -3) {//Creamos un repartidor nuevo
				rep = RepartidorDAO.createRepartidor();
			}else { //Comprobamos si es un repartidor existente
				boolean existe = false;
				
				List<Repartidor> lista = RepartidorDAO.queryRepartidor(null, null);
				
				for(Repartidor r: lista) { 
					if(r.getIdUsuario() == aIdUsuarios){
						existe = true;
						break;
					}
				}
				
				if(!existe)
					return;
				
				rep = RepartidorDAO.getRepartidorByORMID(aIdUsuarios);
			}
			
			rep.setNombre(aNombre);
			rep.setApellidos(aApellidos);
			rep.setCorreo(aCorreo);
			rep.setContrasena("1234");

			 RepartidorDAO.save(rep);	

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

	}

	public Repartidor[] cargar_repartidores() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Repartidor[] repartidores = null;
		try {
			List<Repartidor> r = RepartidorDAO.queryRepartidor(null, null);
			repartidores = new Repartidor[r.size()];
			for(int i = 0; i < r.size(); i++) {
				repartidores[i] = r.get(i);

			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return repartidores;
	}
	
	public void existeRepartidor() throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			List<Repartidor> repartidores = RepartidorDAO.queryRepartidor(null, null);
			
			if(repartidores.isEmpty()) {
				Repartidor r = RepartidorDAO.createRepartidor();
				r.setNombre("Repartidor");
				r.setApellidos("Por defecto");
				r.setCorreo("repartidor@electrizon.es");
				r.setContrasena("1234");
				
				RepartidorDAO.save(r);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
	
	public Repartidor cargar_repartidor(int aIdRepartidor) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		Repartidor r = null;

		try {
			r = RepartidorDAO.getRepartidorByORMID(aIdRepartidor);			

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return r;
	}
}