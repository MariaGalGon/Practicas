/**
 * Licensee: Maria(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListMDS2v4GalvezRosenovData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Producto...");
		basedatos.Producto[] basedatosProductos = basedatos.ProductoDAO.listProductoByQuery(null, null);
		int length = Math.min(basedatosProductos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosProductos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Oferta...");
		basedatos.Oferta[] basedatosOfertas = basedatos.OfertaDAO.listOfertaByQuery(null, null);
		length = Math.min(basedatosOfertas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosOfertas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Categoria...");
		basedatos.Categoria[] basedatosCategorias = basedatos.CategoriaDAO.listCategoriaByQuery(null, null);
		length = Math.min(basedatosCategorias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosCategorias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Anuncio...");
		basedatos.Anuncio[] basedatosAnuncios = basedatos.AnuncioDAO.listAnuncioByQuery(null, null);
		length = Math.min(basedatosAnuncios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosAnuncios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pedido...");
		basedatos.Pedido[] basedatosPedidos = basedatos.PedidoDAO.listPedidoByQuery(null, null);
		length = Math.min(basedatosPedidos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosPedidos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Usuario...");
		basedatos.Usuario[] basedatosUsuarios = basedatos.UsuarioDAO.listUsuarioByQuery(null, null);
		length = Math.min(basedatosUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cibernauta...");
		basedatos.Cibernauta[] basedatosCibernautas = basedatos.CibernautaDAO.listCibernautaByQuery(null, null);
		length = Math.min(basedatosCibernautas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosCibernautas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Repartidor...");
		basedatos.Repartidor[] basedatosRepartidors = basedatos.RepartidorDAO.listRepartidorByQuery(null, null);
		length = Math.min(basedatosRepartidors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosRepartidors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Encargado_compras...");
		basedatos.Encargado_compras[] basedatosEncargado_comprases = basedatos.Encargado_comprasDAO.listEncargado_comprasByQuery(null, null);
		length = Math.min(basedatosEncargado_comprases.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosEncargado_comprases[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Item...");
		basedatos.Item[] basedatosItems = basedatos.ItemDAO.listItemByQuery(null, null);
		length = Math.min(basedatosItems.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosItems[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		basedatos.Administrador[] basedatosAdministradors = basedatos.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(basedatosAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pedido_Entregado...");
		basedatos.Pedido_Entregado[] basedatosPedido_Entregados = basedatos.Pedido_EntregadoDAO.listPedido_EntregadoByQuery(null, null);
		length = Math.min(basedatosPedido_Entregados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosPedido_Entregados[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Foto...");
		basedatos.Foto[] basedatosFotos = basedatos.FotoDAO.listFotoByQuery(null, null);
		length = Math.min(basedatosFotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosFotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pedido_Pendiente...");
		basedatos.Pedido_Pendiente[] basedatosPedido_Pendientes = basedatos.Pedido_PendienteDAO.listPedido_PendienteByQuery(null, null);
		length = Math.min(basedatosPedido_Pendientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosPedido_Pendientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Comentario...");
		basedatos.Comentario[] basedatosComentarios = basedatos.ComentarioDAO.listComentarioByQuery(null, null);
		length = Math.min(basedatosComentarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosComentarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Mensaje...");
		basedatos.Mensaje[] basedatosMensajes = basedatos.MensajeDAO.listMensajeByQuery(null, null);
		length = Math.min(basedatosMensajes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosMensajes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pedido_Enviado...");
		basedatos.Pedido_Enviado[] basedatosPedido_Enviados = basedatos.Pedido_EnviadoDAO.listPedido_EnviadoByQuery(null, null);
		length = Math.min(basedatosPedido_Enviados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basedatosPedido_Enviados[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Producto by Criteria...");
		basedatos.ProductoCriteria lbasedatosProductoCriteria = new basedatos.ProductoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosProductoCriteria.idProducto.eq();
		lbasedatosProductoCriteria.setMaxResults(ROW_COUNT);
		basedatos.Producto[] basedatosProductos = lbasedatosProductoCriteria.listProducto();
		int length =basedatosProductos== null ? 0 : Math.min(basedatosProductos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosProductos[i]);
		}
		System.out.println(length + " Producto record(s) retrieved."); 
		
		System.out.println("Listing Oferta by Criteria...");
		basedatos.OfertaCriteria lbasedatosOfertaCriteria = new basedatos.OfertaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosOfertaCriteria.idOferta.eq();
		lbasedatosOfertaCriteria.setMaxResults(ROW_COUNT);
		basedatos.Oferta[] basedatosOfertas = lbasedatosOfertaCriteria.listOferta();
		length =basedatosOfertas== null ? 0 : Math.min(basedatosOfertas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosOfertas[i]);
		}
		System.out.println(length + " Oferta record(s) retrieved."); 
		
		System.out.println("Listing Categoria by Criteria...");
		basedatos.CategoriaCriteria lbasedatosCategoriaCriteria = new basedatos.CategoriaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosCategoriaCriteria.idCategoria.eq();
		lbasedatosCategoriaCriteria.setMaxResults(ROW_COUNT);
		basedatos.Categoria[] basedatosCategorias = lbasedatosCategoriaCriteria.listCategoria();
		length =basedatosCategorias== null ? 0 : Math.min(basedatosCategorias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosCategorias[i]);
		}
		System.out.println(length + " Categoria record(s) retrieved."); 
		
		System.out.println("Listing Anuncio by Criteria...");
		basedatos.AnuncioCriteria lbasedatosAnuncioCriteria = new basedatos.AnuncioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosAnuncioCriteria.ID.eq();
		lbasedatosAnuncioCriteria.setMaxResults(ROW_COUNT);
		basedatos.Anuncio[] basedatosAnuncios = lbasedatosAnuncioCriteria.listAnuncio();
		length =basedatosAnuncios== null ? 0 : Math.min(basedatosAnuncios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosAnuncios[i]);
		}
		System.out.println(length + " Anuncio record(s) retrieved."); 
		
		System.out.println("Listing Pedido by Criteria...");
		basedatos.PedidoCriteria lbasedatosPedidoCriteria = new basedatos.PedidoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosPedidoCriteria.idPedido.eq();
		lbasedatosPedidoCriteria.setMaxResults(ROW_COUNT);
		basedatos.Pedido[] basedatosPedidos = lbasedatosPedidoCriteria.listPedido();
		length =basedatosPedidos== null ? 0 : Math.min(basedatosPedidos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosPedidos[i]);
		}
		System.out.println(length + " Pedido record(s) retrieved."); 
		
		System.out.println("Listing Usuario by Criteria...");
		basedatos.UsuarioCriteria lbasedatosUsuarioCriteria = new basedatos.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosUsuarioCriteria.idUsuario.eq();
		lbasedatosUsuarioCriteria.setMaxResults(ROW_COUNT);
		basedatos.Usuario[] basedatosUsuarios = lbasedatosUsuarioCriteria.listUsuario();
		length =basedatosUsuarios== null ? 0 : Math.min(basedatosUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
		System.out.println("Listing Cibernauta by Criteria...");
		basedatos.CibernautaCriteria lbasedatosCibernautaCriteria = new basedatos.CibernautaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosCibernautaCriteria.idUsuario.eq();
		lbasedatosCibernautaCriteria.setMaxResults(ROW_COUNT);
		basedatos.Cibernauta[] basedatosCibernautas = lbasedatosCibernautaCriteria.listCibernauta();
		length =basedatosCibernautas== null ? 0 : Math.min(basedatosCibernautas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosCibernautas[i]);
		}
		System.out.println(length + " Cibernauta record(s) retrieved."); 
		
		System.out.println("Listing Repartidor by Criteria...");
		basedatos.RepartidorCriteria lbasedatosRepartidorCriteria = new basedatos.RepartidorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosRepartidorCriteria.idUsuario.eq();
		lbasedatosRepartidorCriteria.setMaxResults(ROW_COUNT);
		basedatos.Repartidor[] basedatosRepartidors = lbasedatosRepartidorCriteria.listRepartidor();
		length =basedatosRepartidors== null ? 0 : Math.min(basedatosRepartidors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosRepartidors[i]);
		}
		System.out.println(length + " Repartidor record(s) retrieved."); 
		
		System.out.println("Listing Encargado_compras by Criteria...");
		basedatos.Encargado_comprasCriteria lbasedatosEncargado_comprasCriteria = new basedatos.Encargado_comprasCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosEncargado_comprasCriteria.idUsuario.eq();
		lbasedatosEncargado_comprasCriteria.setMaxResults(ROW_COUNT);
		basedatos.Encargado_compras[] basedatosEncargado_comprases = lbasedatosEncargado_comprasCriteria.listEncargado_compras();
		length =basedatosEncargado_comprases== null ? 0 : Math.min(basedatosEncargado_comprases.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosEncargado_comprases[i]);
		}
		System.out.println(length + " Encargado_compras record(s) retrieved."); 
		
		System.out.println("Listing Item by Criteria...");
		basedatos.ItemCriteria lbasedatosItemCriteria = new basedatos.ItemCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosItemCriteria.ID.eq();
		lbasedatosItemCriteria.setMaxResults(ROW_COUNT);
		basedatos.Item[] basedatosItems = lbasedatosItemCriteria.listItem();
		length =basedatosItems== null ? 0 : Math.min(basedatosItems.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosItems[i]);
		}
		System.out.println(length + " Item record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		basedatos.AdministradorCriteria lbasedatosAdministradorCriteria = new basedatos.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosAdministradorCriteria.idUsuario.eq();
		lbasedatosAdministradorCriteria.setMaxResults(ROW_COUNT);
		basedatos.Administrador[] basedatosAdministradors = lbasedatosAdministradorCriteria.listAdministrador();
		length =basedatosAdministradors== null ? 0 : Math.min(basedatosAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
		System.out.println("Listing Pedido_Entregado by Criteria...");
		basedatos.Pedido_EntregadoCriteria lbasedatosPedido_EntregadoCriteria = new basedatos.Pedido_EntregadoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosPedido_EntregadoCriteria.idPedido.eq();
		lbasedatosPedido_EntregadoCriteria.setMaxResults(ROW_COUNT);
		basedatos.Pedido_Entregado[] basedatosPedido_Entregados = lbasedatosPedido_EntregadoCriteria.listPedido_Entregado();
		length =basedatosPedido_Entregados== null ? 0 : Math.min(basedatosPedido_Entregados.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosPedido_Entregados[i]);
		}
		System.out.println(length + " Pedido_Entregado record(s) retrieved."); 
		
		System.out.println("Listing Foto by Criteria...");
		basedatos.FotoCriteria lbasedatosFotoCriteria = new basedatos.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosFotoCriteria.ID.eq();
		lbasedatosFotoCriteria.setMaxResults(ROW_COUNT);
		basedatos.Foto[] basedatosFotos = lbasedatosFotoCriteria.listFoto();
		length =basedatosFotos== null ? 0 : Math.min(basedatosFotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosFotos[i]);
		}
		System.out.println(length + " Foto record(s) retrieved."); 
		
		System.out.println("Listing Pedido_Pendiente by Criteria...");
		basedatos.Pedido_PendienteCriteria lbasedatosPedido_PendienteCriteria = new basedatos.Pedido_PendienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosPedido_PendienteCriteria.idPedido.eq();
		lbasedatosPedido_PendienteCriteria.setMaxResults(ROW_COUNT);
		basedatos.Pedido_Pendiente[] basedatosPedido_Pendientes = lbasedatosPedido_PendienteCriteria.listPedido_Pendiente();
		length =basedatosPedido_Pendientes== null ? 0 : Math.min(basedatosPedido_Pendientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosPedido_Pendientes[i]);
		}
		System.out.println(length + " Pedido_Pendiente record(s) retrieved."); 
		
		System.out.println("Listing Comentario by Criteria...");
		basedatos.ComentarioCriteria lbasedatosComentarioCriteria = new basedatos.ComentarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosComentarioCriteria.idComentario.eq();
		lbasedatosComentarioCriteria.setMaxResults(ROW_COUNT);
		basedatos.Comentario[] basedatosComentarios = lbasedatosComentarioCriteria.listComentario();
		length =basedatosComentarios== null ? 0 : Math.min(basedatosComentarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosComentarios[i]);
		}
		System.out.println(length + " Comentario record(s) retrieved."); 
		
		System.out.println("Listing Mensaje by Criteria...");
		basedatos.MensajeCriteria lbasedatosMensajeCriteria = new basedatos.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosMensajeCriteria.idMensaje.eq();
		lbasedatosMensajeCriteria.setMaxResults(ROW_COUNT);
		basedatos.Mensaje[] basedatosMensajes = lbasedatosMensajeCriteria.listMensaje();
		length =basedatosMensajes== null ? 0 : Math.min(basedatosMensajes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosMensajes[i]);
		}
		System.out.println(length + " Mensaje record(s) retrieved."); 
		
		System.out.println("Listing Pedido_Enviado by Criteria...");
		basedatos.Pedido_EnviadoCriteria lbasedatosPedido_EnviadoCriteria = new basedatos.Pedido_EnviadoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasedatosPedido_EnviadoCriteria.idPedido.eq();
		lbasedatosPedido_EnviadoCriteria.setMaxResults(ROW_COUNT);
		basedatos.Pedido_Enviado[] basedatosPedido_Enviados = lbasedatosPedido_EnviadoCriteria.listPedido_Enviado();
		length =basedatosPedido_Enviados== null ? 0 : Math.min(basedatosPedido_Enviados.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basedatosPedido_Enviados[i]);
		}
		System.out.println(length + " Pedido_Enviado record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListMDS2v4GalvezRosenovData listMDS2v4GalvezRosenovData = new ListMDS2v4GalvezRosenovData();
			try {
				listMDS2v4GalvezRosenovData.listTestData();
				//listMDS2v4GalvezRosenovData.listByCriteria();
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
