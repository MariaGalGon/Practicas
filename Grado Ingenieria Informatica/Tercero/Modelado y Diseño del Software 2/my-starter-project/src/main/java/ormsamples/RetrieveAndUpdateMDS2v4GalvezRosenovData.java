/**
 * Licensee: Maria(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateMDS2v4GalvezRosenovData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = basedatos.MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			basedatos.Producto lbasedatosProducto = basedatos.ProductoDAO.loadProductoByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.ProductoDAO.save(lbasedatosProducto);
			basedatos.Oferta lbasedatosOferta = basedatos.OfertaDAO.loadOfertaByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.OfertaDAO.save(lbasedatosOferta);
			basedatos.Categoria lbasedatosCategoria = basedatos.CategoriaDAO.loadCategoriaByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.CategoriaDAO.save(lbasedatosCategoria);
			basedatos.Anuncio lbasedatosAnuncio = basedatos.AnuncioDAO.loadAnuncioByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.AnuncioDAO.save(lbasedatosAnuncio);
			basedatos.Pedido lbasedatosPedido = basedatos.PedidoDAO.loadPedidoByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.PedidoDAO.save(lbasedatosPedido);
			basedatos.Usuario lbasedatosUsuario = basedatos.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.UsuarioDAO.save(lbasedatosUsuario);
			basedatos.Cibernauta lbasedatosCibernauta = basedatos.CibernautaDAO.loadCibernautaByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.CibernautaDAO.save(lbasedatosCibernauta);
			basedatos.Repartidor lbasedatosRepartidor = basedatos.RepartidorDAO.loadRepartidorByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.RepartidorDAO.save(lbasedatosRepartidor);
			basedatos.Encargado_compras lbasedatosEncargado_compras = basedatos.Encargado_comprasDAO.loadEncargado_comprasByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.Encargado_comprasDAO.save(lbasedatosEncargado_compras);
			basedatos.Item lbasedatosItem = basedatos.ItemDAO.loadItemByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.ItemDAO.save(lbasedatosItem);
			basedatos.Administrador lbasedatosAdministrador = basedatos.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.AdministradorDAO.save(lbasedatosAdministrador);
			basedatos.Pedido_Entregado lbasedatosPedido_Entregado = basedatos.Pedido_EntregadoDAO.loadPedido_EntregadoByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.Pedido_EntregadoDAO.save(lbasedatosPedido_Entregado);
			basedatos.Foto lbasedatosFoto = basedatos.FotoDAO.loadFotoByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.FotoDAO.save(lbasedatosFoto);
			basedatos.Pedido_Pendiente lbasedatosPedido_Pendiente = basedatos.Pedido_PendienteDAO.loadPedido_PendienteByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.Pedido_PendienteDAO.save(lbasedatosPedido_Pendiente);
			basedatos.Comentario lbasedatosComentario = basedatos.ComentarioDAO.loadComentarioByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.ComentarioDAO.save(lbasedatosComentario);
			basedatos.Mensaje lbasedatosMensaje = basedatos.MensajeDAO.loadMensajeByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.MensajeDAO.save(lbasedatosMensaje);
			basedatos.Pedido_Enviado lbasedatosPedido_Enviado = basedatos.Pedido_EnviadoDAO.loadPedido_EnviadoByQuery(null, null);
			// Update the properties of the persistent object
			basedatos.Pedido_EnviadoDAO.save(lbasedatosPedido_Enviado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Producto by ProductoCriteria");
		basedatos.ProductoCriteria lbasedatosProductoCriteria = new basedatos.ProductoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosProductoCriteria.idProducto.eq();
		System.out.println(lbasedatosProductoCriteria.uniqueProducto());
		
		System.out.println("Retrieving Oferta by OfertaCriteria");
		basedatos.OfertaCriteria lbasedatosOfertaCriteria = new basedatos.OfertaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosOfertaCriteria.idOferta.eq();
		System.out.println(lbasedatosOfertaCriteria.uniqueOferta());
		
		System.out.println("Retrieving Categoria by CategoriaCriteria");
		basedatos.CategoriaCriteria lbasedatosCategoriaCriteria = new basedatos.CategoriaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosCategoriaCriteria.idCategoria.eq();
		System.out.println(lbasedatosCategoriaCriteria.uniqueCategoria());
		
		System.out.println("Retrieving Anuncio by AnuncioCriteria");
		basedatos.AnuncioCriteria lbasedatosAnuncioCriteria = new basedatos.AnuncioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosAnuncioCriteria.ID.eq();
		System.out.println(lbasedatosAnuncioCriteria.uniqueAnuncio());
		
		System.out.println("Retrieving Pedido by PedidoCriteria");
		basedatos.PedidoCriteria lbasedatosPedidoCriteria = new basedatos.PedidoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosPedidoCriteria.idPedido.eq();
		System.out.println(lbasedatosPedidoCriteria.uniquePedido());
		
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		basedatos.UsuarioCriteria lbasedatosUsuarioCriteria = new basedatos.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosUsuarioCriteria.idUsuario.eq();
		System.out.println(lbasedatosUsuarioCriteria.uniqueUsuario());
		
		System.out.println("Retrieving Cibernauta by CibernautaCriteria");
		basedatos.CibernautaCriteria lbasedatosCibernautaCriteria = new basedatos.CibernautaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosCibernautaCriteria.idUsuario.eq();
		System.out.println(lbasedatosCibernautaCriteria.uniqueCibernauta());
		
		System.out.println("Retrieving Repartidor by RepartidorCriteria");
		basedatos.RepartidorCriteria lbasedatosRepartidorCriteria = new basedatos.RepartidorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosRepartidorCriteria.idUsuario.eq();
		System.out.println(lbasedatosRepartidorCriteria.uniqueRepartidor());
		
		System.out.println("Retrieving Encargado_compras by Encargado_comprasCriteria");
		basedatos.Encargado_comprasCriteria lbasedatosEncargado_comprasCriteria = new basedatos.Encargado_comprasCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosEncargado_comprasCriteria.idUsuario.eq();
		System.out.println(lbasedatosEncargado_comprasCriteria.uniqueEncargado_compras());
		
		System.out.println("Retrieving Item by ItemCriteria");
		basedatos.ItemCriteria lbasedatosItemCriteria = new basedatos.ItemCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosItemCriteria.ID.eq();
		System.out.println(lbasedatosItemCriteria.uniqueItem());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		basedatos.AdministradorCriteria lbasedatosAdministradorCriteria = new basedatos.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosAdministradorCriteria.idUsuario.eq();
		System.out.println(lbasedatosAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Pedido_Entregado by Pedido_EntregadoCriteria");
		basedatos.Pedido_EntregadoCriteria lbasedatosPedido_EntregadoCriteria = new basedatos.Pedido_EntregadoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosPedido_EntregadoCriteria.idPedido.eq();
		System.out.println(lbasedatosPedido_EntregadoCriteria.uniquePedido_Entregado());
		
		System.out.println("Retrieving Foto by FotoCriteria");
		basedatos.FotoCriteria lbasedatosFotoCriteria = new basedatos.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosFotoCriteria.ID.eq();
		System.out.println(lbasedatosFotoCriteria.uniqueFoto());
		
		System.out.println("Retrieving Pedido_Pendiente by Pedido_PendienteCriteria");
		basedatos.Pedido_PendienteCriteria lbasedatosPedido_PendienteCriteria = new basedatos.Pedido_PendienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosPedido_PendienteCriteria.idPedido.eq();
		System.out.println(lbasedatosPedido_PendienteCriteria.uniquePedido_Pendiente());
		
		System.out.println("Retrieving Comentario by ComentarioCriteria");
		basedatos.ComentarioCriteria lbasedatosComentarioCriteria = new basedatos.ComentarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosComentarioCriteria.idComentario.eq();
		System.out.println(lbasedatosComentarioCriteria.uniqueComentario());
		
		System.out.println("Retrieving Mensaje by MensajeCriteria");
		basedatos.MensajeCriteria lbasedatosMensajeCriteria = new basedatos.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosMensajeCriteria.idMensaje.eq();
		System.out.println(lbasedatosMensajeCriteria.uniqueMensaje());
		
		System.out.println("Retrieving Pedido_Enviado by Pedido_EnviadoCriteria");
		basedatos.Pedido_EnviadoCriteria lbasedatosPedido_EnviadoCriteria = new basedatos.Pedido_EnviadoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasedatosPedido_EnviadoCriteria.idPedido.eq();
		System.out.println(lbasedatosPedido_EnviadoCriteria.uniquePedido_Enviado());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateMDS2v4GalvezRosenovData retrieveAndUpdateMDS2v4GalvezRosenovData = new RetrieveAndUpdateMDS2v4GalvezRosenovData();
			try {
				retrieveAndUpdateMDS2v4GalvezRosenovData.retrieveAndUpdateTestData();
				//retrieveAndUpdateMDS2v4GalvezRosenovData.retrieveByCriteria();
			}
			finally {
				basedatos.MDS2v4GalvezRosenovPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
