package basedatos;

import java.sql.Date;
import java.util.ArrayList;

import org.orm.PersistentException;

import com.vaadin.flow.component.notification.Notification;

import interfaz.*;

public class BDPrincipal implements iCibernauta_no_identificado, iComun, iRepartidor, iBanco, iEncargado_compras, iCorreo, iCibernauta_identificado, iAdministrador {
	public BD_Ofertas _ofertas;
	public BD_Producto _productos;
	public BD_Categoria _categoria;
	public BD_Encargado _encargado;
	public BD_Administrador _administrador;
	public BD_Cibernauta _cibernauta;
	public BD_Mensaje _mensaje;
	public BD_Pedido_Pendiente _pendiente;
	public BD_Comentario _comentario;
	public BD_Foto _foto;
	public BD_Repartidor _repartidor;
	public BD_Item _item;
	public BD_Pedido_Enviado _enviado;
	public BD_Pedido_Entregado _entregado;
	public BD_Anuncio _anuncio;

	public  BDPrincipal() {
		_ofertas = new BD_Ofertas();
		_productos = new BD_Producto();
		_categoria = new BD_Categoria();
		_encargado = new BD_Encargado();
		_administrador = new BD_Administrador();
		_cibernauta = new BD_Cibernauta();
		_mensaje = new BD_Mensaje();
		_pendiente = new BD_Pedido_Pendiente();
		_comentario = new BD_Comentario();
		_foto = new BD_Foto();
		_repartidor = new BD_Repartidor();
		_item = new BD_Item();
		_enviado = new BD_Pedido_Enviado();
		_entregado = new BD_Pedido_Entregado();
		_anuncio = new BD_Anuncio();
	}

	public Cibernauta_no_identificado get_Cibernauta_no_identificado() {
		throw new UnsupportedOperationException();
	}

	public Repartidor get_Repartidor() {
		throw new UnsupportedOperationException();
	}

	public Banco get_Banco() {
		throw new UnsupportedOperationException();
	}

	public Encargado_compras get_Encargado_compras() {
		throw new UnsupportedOperationException();
	}

	public Correo get_Correo() {
		throw new UnsupportedOperationException();
	}

	public Cibernauta_identificado get_Cibernauta_identificado() {
		throw new UnsupportedOperationException();
	}

	public Administrador get_Administrador() {
		throw new UnsupportedOperationException();
	}

	public void iniciar_sesion(String aCorreo, String aContrasenia) {
		try {
			Cibernauta cib = new Cibernauta();
			cib = _cibernauta.iniciar_sesion(aCorreo, aContrasenia);

			if(cib != null) { 
				Iniciar_sesion.tipo = "Cibernauta";
				cargar_cibernauta(cib.getIdUsuario());
			} else {
				Administrador admin = new Administrador();
				admin = _administrador.iniciar_sesion(aCorreo, aContrasenia);

				if(admin != null) { 
					Iniciar_sesion.tipo = "Administrador";
					cargar_admin(admin.getIdUsuario());
				} else {
					Encargado_compras enc = new Encargado_compras();
					enc = _encargado.iniciar_sesion(aCorreo, aContrasenia);

					if(enc != null) { 
						Iniciar_sesion.tipo = "Encargado";
						cargar_encargado(enc.getIdUsuario());
					} else {
						Repartidor rep = new Repartidor();
						rep = _repartidor.iniciar_sesion(aCorreo, aContrasenia);

						if(rep != null) { 
							Iniciar_sesion.tipo = "Repartidor";
							cargar_repartidor(rep.getIdUsuario());
						}
					}
				}
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void cargar_repartidor(int aIdRepartidor) {
		try {
			interfaz.Repartidor.usuario = _repartidor.cargar_repartidor(aIdRepartidor);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void cargar_encargado(int aIdEncargado) {
		try {
			interfaz.Encargado_compras.usuario = _encargado.cargar_encargado(aIdEncargado);
		} catch (PersistentException e) {
			e.printStackTrace();
		}	 
	}

	public void cargar_admin(int aIdAdmin) {
		try {
			interfaz.Administrador.usuario = _administrador.cargar_admin(aIdAdmin);
		} catch (PersistentException e) {
			e.printStackTrace();
		}		
	}

	public void cargar_cibernauta(int aIdCibernauta) {
		try {
			interfaz.Cibernauta_identificado.usuario = _cibernauta.cargar_cibernauta(aIdCibernauta);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public boolean registrarse(String[] aDatos) {
		boolean creado = false;
		try {
			creado = _cibernauta.registrarse(aDatos);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}

		return creado;
	}

	public void recuperar_contrasenia(String aCorreo) {
		String contrasenia = null;
		
		try {
			contrasenia = _cibernauta.recuperar_contrasenia(aCorreo);
			
			if(contrasenia == null) {
				contrasenia = _administrador.recuperar_contrasenia(aCorreo);
				
				if(contrasenia == null) {
					contrasenia = _encargado.recuperar_contrasenia(aCorreo);
					
					if(contrasenia == null) {
						contrasenia = _repartidor.recuperar_contrasenia(aCorreo);
					}
				}
			}
			
			if(contrasenia != null) {
				Recuperar_contrasenia.encontrada = true;
				Notification.show("Su contrasenia es: " + contrasenia);
			} else {
				Recuperar_contrasenia.encontrada = false;
				Notification.show("No se encontro ningun usuario con el correo introducido");
			}
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Producto[] cargar_productos_destacados() {
		Producto[] productos = null;		

		try {
			productos = _productos.cargar_productos_destacados();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productos;
	}

	public Oferta[] cargar_ofertas() {
		Oferta[] ofertas = null;
		try {
			ofertas = _ofertas.cargar_lista_ofertas();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ofertas;
	}

	public Categoria[] cargar_categorias_combobox() {
		Categoria[] categorias = null;


		try {
			categorias = _categoria.cargar_categorias_combobox();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return categorias;	
	}

	public Producto[] buscar_producto(String aBusqueda) {
		Producto[] productos = null;


		try {
			productos = _productos.buscar_producto(aBusqueda);
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return productos;
	}

	public Producto cargar_datos_producto(int aIdProducto) {
		Producto p = null;

		try {
			p = _productos.cargar_datos_producto(aIdProducto);
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return p;
	}

	public Anuncio[] cargar_anuncios() {
		Anuncio[] anuncios = null;
		try {
			anuncios =  _anuncio.cargar_anuncios();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return anuncios;
	}

	public Pedido[] elegir_estado_envio(String aEstado, int[] aIdPedidos) {
		Pedido[] pedidos = null;

		try {
			if(aEstado.equals("No entregados")) {
				pedidos = _enviado.elegir_estado_envio(aIdPedidos);
			} else if(aEstado.equals("Entregados")) {
				pedidos = _entregado.elegir_estado_envio(aIdPedidos);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return pedidos;
	}

	public void guardar_perfil(int aIdUsuario, String aNombreApellidos, String aCorreo) {
		try {
			_repartidor.guardar_perfil(aIdUsuario, aNombreApellidos, aCorreo);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void cambiar_estado_envio(boolean aEntregado, int aIdPedido) {
		try {
			if(aEntregado) {
				Pedido_Enviado p = _enviado.quitar_pedido(aIdPedido);
				Date f = new java.sql.Date(System.currentTimeMillis());
				_entregado.aniadir_pedido(f, p);
			} else {
				Pedido_Entregado p = _entregado.quitar_pedido(aIdPedido);
				_enviado.aniadir_pedido(p);
			}
			
			this.cargar_repartidor(interfaz.Repartidor.usuario.getIdUsuario());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void guardar_datos(String[] aDatos, int aIdUsuario) {
		try {
			if(aDatos[0].equals("Administrador")) {
				_administrador.guardar_datos(aDatos, aIdUsuario);
			} else if(aDatos[0].equals("Encargado")) {
				_encargado.guardar_datos(aDatos, aIdUsuario);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Pedido[] elegir_estado_pedido(String aEstado, int[] aIdPedidos) {
		Pedido[] pedidos = null;

		try {
			if(aEstado.equals("Pendiente")) {
				pedidos = _pendiente.elegir_estado_pedido(aIdPedidos);
			} else if(aEstado.equals("Enviado")) {
				pedidos = _enviado.elegir_estado_pedido(aIdPedidos);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return pedidos;
	}

	public void cambiar_estado_pedido(String aEstado, int aIdPedido, Date aFecha) {
		try {
			if(aEstado.equals("Pendiente")) {
				Pedido_Enviado pe = new Pedido_Enviado();
				pe = _enviado.quitar_pedido(aIdPedido);
				_pendiente.aniadir_pedido(pe);
			} else if(aEstado.equals("Enviado")) {
				Pedido_Pendiente pp = new Pedido_Pendiente();
				pp = _pendiente.quitar_pedido(aIdPedido);
				_enviado.aniadir_pedido(pp, aFecha);
			}
			
			this.cargar_encargado(interfaz.Encargado_compras.usuario.getIdUsuario());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void realizar_compra(Cibernauta aUsuario, Item[] aCarrito) {
		try {
			_pendiente.realizar_compra(aUsuario, aCarrito);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void guardar_datos(String[] aDatos, int aIdUsuario, String aFoto) {
		try {
			_cibernauta.guardar_datos(aDatos, aIdUsuario, aFoto);

		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void confirmar_baja(int aIdUsuario) {
		try {
			_cibernauta.confirmar_baja(aIdUsuario);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void eliminar_mensaje(int aIdUsuario, int aIdMensaje) {
		try {
			_mensaje.eliminar_mensaje(aIdUsuario, aIdMensaje);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancelar_pedido(int aIdPedido) {
		try {
			_pendiente.cancelar_pedido(aIdPedido);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void publicar_comentario(int aIdUsuario, String aTexto, int aValoracion, int aIdProducto) {
		try {
			_comentario.publicar_comentario(aIdUsuario, aTexto, aValoracion, aIdProducto);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enviar_mensaje(String aDestinatario_mail, String aAsunto, String aTexto, int aIdRemitente) {
		try {
			int destinatario =  _cibernauta.buscar_destinatario(aDestinatario_mail);
			_mensaje.enviar_mensaje(destinatario, aAsunto, aTexto, aIdRemitente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String cargar_remitente(int aIdRemitente) {
		String remitente = null;
		try {
			remitente = _cibernauta.cargar_remitente(aIdRemitente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return remitente;
	}

	public Oferta[] cargar_lista_ofertas() {
		Oferta[] ofertas = null;


		try {
			ofertas = _ofertas.cargar_lista_ofertas();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return ofertas;
	}

	public Oferta[] cargar_lista_seleccionar_ofertas() {
		Oferta[] ofertas = null;


		try {
			ofertas = _ofertas.cargar_lista_seleccionar_ofertas();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return ofertas;
	}

	public void eliminar_ofertas(int[] aIdOfertas) {
		try {

			_ofertas.eliminar_ofertas(aIdOfertas);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardar_ofertas(Date aFecha, String aDescripcion, String aCondiciones, String aNombre, int aIdOferta) {
		try {
			_ofertas.guardar_ofertas(aFecha, aDescripcion, aCondiciones, aNombre, aIdOferta);

		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Producto[] cargar_productos_asociados_oferta(int aIdOferta) {
		Producto[] productos = null;


		try {
			productos = _ofertas.cargar_productos_asociados_oferta(aIdOferta);
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return productos;
	}

	public void eliminar_producto_asociado(int[] aIdProductos, int aIdOferta) {
		try {
			_productos.eliminar_producto_asociado(aIdProductos, aIdOferta);
			_ofertas.eliminar_producto_asociado(aIdProductos, aIdOferta);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Producto[] cargar_productos_aniadir_oferta(int aIdOferta) {
		Producto[] productos = null;

		try {
			productos = _productos.cargar_productos_aniadir_oferta(aIdOferta);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productos;
	}

	public void aniadir_productos_asociados_oferta(int[] aIdProductos, int aIdOferta) {
		try {
			_productos.aniadir_productos_asociados_oferta(aIdProductos, aIdOferta);
			_ofertas.aniadir_productos_asociados_oferta(aIdProductos, aIdOferta);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Producto[] buscar_producto_aniadir_oferta(String aNombreProducto) {
		Producto[] productos = null;


		try {
			productos = _productos.buscar_producto_aniadir_oferta(aNombreProducto);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productos;
	}

	public Categoria[] cargar_lista_seleccionar_categorias() {
		Categoria[] categorias = null;


		try {
			categorias = _categoria.cargar_lista_seleccionar_categorias();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return categorias;
	}

	public void eliminar_categorias(int[] aIdCategorias) {
		try {
			_categoria.eliminar_categorias(aIdCategorias);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Categoria cargar_categoria(int aIdCategoria) {
		Categoria c = null;

		try {
			c = _categoria.cargar_categoria(aIdCategoria);
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return c;
	}

	public void guardar_categoria(String aNombre, int aIdCategoria) {
		try {
			_categoria.guardar_categoria(aNombre, aIdCategoria);

		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void eliminar_productos_asociados_categoria(int[] aIdProductos, int aIdCategoria) {
		try {
			_productos.eliminar_productos_asociados_categoria(aIdProductos, aIdCategoria);
			_categoria.eliminar_productos_asociados_categoria(aIdProductos, aIdCategoria);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Producto[] cargar_productos_aniadir_categoria(int aIdCategoria) {
		Producto[] productos = null;

		try {
			productos = _productos.cargar_productos_aniadir_categoria(aIdCategoria);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productos;
	}

	public void aniadir_productos_asociados_categoria(int[] aIdProductos, int aIdCategoria) {
		try {
			_productos.aniadir_productos_asociados_categoria(aIdProductos, aIdCategoria);
			_categoria.aniadir_productos_asociados_categoria(aIdProductos, aIdCategoria);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Producto[] buscar_producto_aniadir_categoria(String aNombreProducto) {
		Producto[] productos = null;


		try {
			productos = _productos.buscar_producto_aniadir_categoria(aNombreProducto);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productos;
	}

	public void guardar_producto(String[] aFotos, double aPrecio, String aNombre, String aInformacion, String aCaracteristicas, int[] aIdCategorias, int aIdProducto) {
		try {
			_productos.guardar_producto(aFotos, aPrecio, aNombre, aInformacion, aCaracteristicas, aIdCategorias, aIdProducto);
			if(aIdCategorias != null) {
				_categoria.guardar_categoria_producto(aIdCategorias, aIdProducto);
			}
			//Falta lo de las fotos
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void guardar_anuncio(String aNombre, String aEnlace, int aAltura, int aAnchura, String aImagen, int aIdAnuncio) {
		try {
			_anuncio.guardar_anuncio(aNombre, aEnlace, aAltura, aAnchura, aImagen, aIdAnuncio);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardar_trabajador(String aNombre, String aApellidos, String aCorreo, String aIdUsuario, String aFoto) {
		try {
			_repartidor.guardar_trabajador(aNombre, aApellidos, aCorreo, Integer.parseInt(aIdUsuario));
			_encargado.guardar_trabajador(aNombre, aApellidos, aCorreo, Integer.parseInt(aIdUsuario), aFoto);

		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Cibernauta[] cargar_cibernautas() {
		Cibernauta[] cib = null;
		try {
			cib = _cibernauta.cargar_cibernautas();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cib;
	}

	public Categoria[] cargar_categorias() {
		Categoria[] categorias = null;


		try {
			categorias = _categoria.cargar_categorias();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return categorias;
	}

	public void eliminar_anuncio(int aIdAnuncio) {
		try {
			_anuncio.eliminar_anuncio(aIdAnuncio);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Producto[] cargar_productos() {
		Producto[] productos = null;


		try {
			productos = _productos.cargar_productos();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return productos;
	}

	public Categoria[] buscar_categoria(String aBusqueda) {
		Categoria[] categorias = null;


		try {
			categorias = _categoria.buscar_categoria(aBusqueda);
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return categorias;
	}

	public Usuario[] cargar_trabajadores() {
		ArrayList<Usuario> usuariosList = new ArrayList<Usuario>();
		Usuario[] repartidores;
		Usuario[] encargados;


		try {
			repartidores = _repartidor.cargar_repartidores();
			encargados = _encargado.cargar_encargados();

			for(int i = 0; i< repartidores.length; i++) {
				usuariosList.add(repartidores[i]);
			}

			for(int i = 0; i< encargados.length; i++) {
				usuariosList.add(encargados[i]);
			}


		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Usuario[] usuarios = new Usuario[usuariosList.size()];

		for(int i = 0; i< usuariosList.size(); i++) {
			usuarios[i] = usuariosList.get(i);
		}

		return usuarios;
	}

	public ArrayList<Pedido> cargar_lista_compras() {
		ArrayList<Pedido> pedidosList = new ArrayList<Pedido>();
		try {
			Pedido[] arrayPendiente = _pendiente.cargar_lista_compras();
			Pedido[] arrayEnviado = _enviado.cargar_lista_compras();
			Pedido[] arrayEntregado = _entregado.cargar_lista_compras();
			if(arrayPendiente != null) {
				for(int i = 0; i < arrayPendiente.length; i++) {
					pedidosList.add(arrayPendiente[i]);
				}
			}

			if(arrayEnviado != null) {
				for(int i = 0; i <  arrayEnviado.length; i++) {
					pedidosList.add( arrayEnviado[i]);
				}
			}

			if(arrayEntregado != null) {
				for(int i = 0; i <  arrayEntregado.length; i++) {
					pedidosList.add( arrayEntregado[i]);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return pedidosList;

	}

	public Producto cargar_producto(int aIdProducto) {
		Producto p = null;

		try {
			p = _productos.cargar_producto(aIdProducto);
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return p;
	}

	public void eliminar_producto_catalogo(int aIdProducto) {
		try {
			_foto.eliminar_fotos(aIdProducto);
			_productos.eliminar_producto_catalogo(aIdProducto);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Comun get_Comun() {
		throw new UnsupportedOperationException();
	}
}