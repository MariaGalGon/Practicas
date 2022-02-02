/**
 * Licensee: Maria(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteMDS2v4GalvezRosenovData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = basedatos.MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			basedatos.Producto lbasedatosProducto = basedatos.ProductoDAO.loadProductoByQuery(null, null);
			// Delete the persistent object
			basedatos.ProductoDAO.delete(lbasedatosProducto);
			basedatos.Oferta lbasedatosOferta = basedatos.OfertaDAO.loadOfertaByQuery(null, null);
			// Delete the persistent object
			basedatos.OfertaDAO.delete(lbasedatosOferta);
			basedatos.Categoria lbasedatosCategoria = basedatos.CategoriaDAO.loadCategoriaByQuery(null, null);
			// Delete the persistent object
			basedatos.CategoriaDAO.delete(lbasedatosCategoria);
			basedatos.Anuncio lbasedatosAnuncio = basedatos.AnuncioDAO.loadAnuncioByQuery(null, null);
			// Delete the persistent object
			basedatos.AnuncioDAO.delete(lbasedatosAnuncio);
			basedatos.Pedido lbasedatosPedido = basedatos.PedidoDAO.loadPedidoByQuery(null, null);
			// Delete the persistent object
			basedatos.PedidoDAO.delete(lbasedatosPedido);
			basedatos.Usuario lbasedatosUsuario = basedatos.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			basedatos.UsuarioDAO.delete(lbasedatosUsuario);
			basedatos.Cibernauta lbasedatosCibernauta = basedatos.CibernautaDAO.loadCibernautaByQuery(null, null);
			// Delete the persistent object
			basedatos.CibernautaDAO.delete(lbasedatosCibernauta);
			basedatos.Repartidor lbasedatosRepartidor = basedatos.RepartidorDAO.loadRepartidorByQuery(null, null);
			// Delete the persistent object
			basedatos.RepartidorDAO.delete(lbasedatosRepartidor);
			basedatos.Encargado_compras lbasedatosEncargado_compras = basedatos.Encargado_comprasDAO.loadEncargado_comprasByQuery(null, null);
			// Delete the persistent object
			basedatos.Encargado_comprasDAO.delete(lbasedatosEncargado_compras);
			basedatos.Item lbasedatosItem = basedatos.ItemDAO.loadItemByQuery(null, null);
			// Delete the persistent object
			basedatos.ItemDAO.delete(lbasedatosItem);
			basedatos.Administrador lbasedatosAdministrador = basedatos.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			basedatos.AdministradorDAO.delete(lbasedatosAdministrador);
			basedatos.Pedido_Entregado lbasedatosPedido_Entregado = basedatos.Pedido_EntregadoDAO.loadPedido_EntregadoByQuery(null, null);
			// Delete the persistent object
			basedatos.Pedido_EntregadoDAO.delete(lbasedatosPedido_Entregado);
			basedatos.Foto lbasedatosFoto = basedatos.FotoDAO.loadFotoByQuery(null, null);
			// Delete the persistent object
			basedatos.FotoDAO.delete(lbasedatosFoto);
			basedatos.Pedido_Pendiente lbasedatosPedido_Pendiente = basedatos.Pedido_PendienteDAO.loadPedido_PendienteByQuery(null, null);
			// Delete the persistent object
			basedatos.Pedido_PendienteDAO.delete(lbasedatosPedido_Pendiente);
			basedatos.Comentario lbasedatosComentario = basedatos.ComentarioDAO.loadComentarioByQuery(null, null);
			// Delete the persistent object
			basedatos.ComentarioDAO.delete(lbasedatosComentario);
			basedatos.Mensaje lbasedatosMensaje = basedatos.MensajeDAO.loadMensajeByQuery(null, null);
			// Delete the persistent object
			basedatos.MensajeDAO.delete(lbasedatosMensaje);
			basedatos.Pedido_Enviado lbasedatosPedido_Enviado = basedatos.Pedido_EnviadoDAO.loadPedido_EnviadoByQuery(null, null);
			// Delete the persistent object
			basedatos.Pedido_EnviadoDAO.delete(lbasedatosPedido_Enviado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteMDS2v4GalvezRosenovData deleteMDS2v4GalvezRosenovData = new DeleteMDS2v4GalvezRosenovData();
			try {
				deleteMDS2v4GalvezRosenovData.deleteTestData();
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
