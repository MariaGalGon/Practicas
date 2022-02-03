/**
 * Licensee: Maria(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateMDS2v4GalvezRosenovData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = basedatos.MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();
		try {
			basedatos.Producto lbasedatosProducto = basedatos.ProductoDAO.createProducto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pertenece_a_categoria, comentarios, cantidad, fotos, valoracionMedia, precio
			basedatos.ProductoDAO.save(lbasedatosProducto);
			basedatos.Oferta lbasedatosOferta = basedatos.OfertaDAO.createOferta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : descuento
			basedatos.OfertaDAO.save(lbasedatosOferta);
			basedatos.Categoria lbasedatosCategoria = basedatos.CategoriaDAO.createCategoria();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : producto_asociado
			basedatos.CategoriaDAO.save(lbasedatosCategoria);
			basedatos.Anuncio lbasedatosAnuncio = basedatos.AnuncioDAO.createAnuncio();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : anchura, altura
			basedatos.AnuncioDAO.save(lbasedatosAnuncio);
			basedatos.Pedido lbasedatosPedido = basedatos.PedidoDAO.createPedido();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : cantidad, totalProductos, precioTotal, comprado_por, repartidor, encargado_compras
			basedatos.PedidoDAO.save(lbasedatosPedido);
			basedatos.Usuario lbasedatosUsuario = basedatos.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : mensaje_enviado, mensaje_recibido
			basedatos.UsuarioDAO.save(lbasedatosUsuario);
			basedatos.Cibernauta lbasedatosCibernauta = basedatos.CibernautaDAO.createCibernauta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : comprado, comentarios, estado, cvv, tarjeta
			basedatos.CibernautaDAO.save(lbasedatosCibernauta);
			basedatos.Repartidor lbasedatosRepartidor = basedatos.RepartidorDAO.createRepartidor();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pedidos
			basedatos.RepartidorDAO.save(lbasedatosRepartidor);
			basedatos.Encargado_compras lbasedatosEncargado_compras = basedatos.Encargado_comprasDAO.createEncargado_compras();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pedidos
			basedatos.Encargado_comprasDAO.save(lbasedatosEncargado_compras);
			basedatos.Item lbasedatosItem = basedatos.ItemDAO.createItem();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : cantidadProducto, pedido, productos_pedido
			basedatos.ItemDAO.save(lbasedatosItem);
			basedatos.Administrador lbasedatosAdministrador = basedatos.AdministradorDAO.createAdministrador();
			// Initialize the properties of the persistent object here
			basedatos.AdministradorDAO.save(lbasedatosAdministrador);
			basedatos.Pedido_Entregado lbasedatosPedido_Entregado = basedatos.Pedido_EntregadoDAO.createPedido_Entregado();
			// Initialize the properties of the persistent object here
			basedatos.Pedido_EntregadoDAO.save(lbasedatosPedido_Entregado);
			basedatos.Foto lbasedatosFoto = basedatos.FotoDAO.createFoto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : producto
			basedatos.FotoDAO.save(lbasedatosFoto);
			basedatos.Pedido_Pendiente lbasedatosPedido_Pendiente = basedatos.Pedido_PendienteDAO.createPedido_Pendiente();
			// Initialize the properties of the persistent object here
			basedatos.Pedido_PendienteDAO.save(lbasedatosPedido_Pendiente);
			basedatos.Comentario lbasedatosComentario = basedatos.ComentarioDAO.createComentario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : valoracion, cibernauta, producto
			basedatos.ComentarioDAO.save(lbasedatosComentario);
			basedatos.Mensaje lbasedatosMensaje = basedatos.MensajeDAO.createMensaje();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : remitente, destinatario
			basedatos.MensajeDAO.save(lbasedatosMensaje);
			basedatos.Pedido_Enviado lbasedatosPedido_Enviado = basedatos.Pedido_EnviadoDAO.createPedido_Enviado();
			// Initialize the properties of the persistent object here
			basedatos.Pedido_EnviadoDAO.save(lbasedatosPedido_Enviado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateMDS2v4GalvezRosenovData createMDS2v4GalvezRosenovData = new CreateMDS2v4GalvezRosenovData();
			try {
				createMDS2v4GalvezRosenovData.createTestData();
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
