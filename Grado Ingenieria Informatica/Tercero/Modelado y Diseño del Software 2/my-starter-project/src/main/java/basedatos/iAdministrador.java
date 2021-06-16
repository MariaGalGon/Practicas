package basedatos;

import java.sql.Date;
import java.util.ArrayList;

public interface iAdministrador {

	public Oferta[] cargar_lista_ofertas();

	public Oferta[] cargar_lista_seleccionar_ofertas();

	public void eliminar_ofertas(int[] aIdOfertas);

	public void guardar_ofertas(Date aFecha, String aDescripcion, String aCondiciones, String aNombre, int aIdOferta);

	public Producto[] cargar_productos_asociados_oferta(int aIdOferta);

	public void eliminar_producto_asociado(int[] aIdProductos, int aIdOferta);

	public Producto[] cargar_productos_aniadir_oferta(int aIdOferta);

	public void aniadir_productos_asociados_oferta(int[] aIdProductos, int aIdOferta);

	public Producto[] buscar_producto_aniadir_oferta(String aNombreProducto);

	public Categoria[] cargar_lista_seleccionar_categorias();

	public void eliminar_categorias(int[] aIdCategorias);

	public Categoria cargar_categoria(int aIdCategoria);

	public void guardar_categoria(String aNombre, int aIdCategoria);

	public void eliminar_productos_asociados_categoria(int[] aIdProductos, int aIdCategoria);

	public Producto[] cargar_productos_aniadir_categoria(int aIdCategoria);

	public void aniadir_productos_asociados_categoria(int[] aIdProductos, int aIdCategoria);

	public Producto[] buscar_producto_aniadir_categoria(String aNombreProducto);

	public void enviar_mensaje(String aDestinatario_mail, String aAsunto, String aTexto, int aIdRemitente);

	public void eliminar_mensaje(int aIdUsuario, int aIdMensaje);

	public void guardar_datos(String[] aDatos, int aIdUsuario);

	public void guardar_producto(String[] aFotos, double aPrecio, String aNombre, String aInformacion, String aCaracteristicas, int[] aIdCategorias, int aIdProducto);

	public Producto[] buscar_producto(String aBusqueda);

	public void guardar_anuncio(String aNombre, String aEnlace, int aAltura, int aAnchura, String aImagen, int aIdAnuncio);

	public void guardar_trabajador(String aNombre, String aApellidos, String aCorreo, String aIdUsuario, String aFoto);

	public Cibernauta[] cargar_cibernautas();

	public Categoria[] cargar_categorias();

	public void eliminar_anuncio(int aIdAnuncio);

	public Producto[] cargar_productos();

	public Categoria[] buscar_categoria(String aBusqueda);

	public Usuario[] cargar_trabajadores();

	public ArrayList<Pedido> cargar_lista_compras();

	public Anuncio[] cargar_anuncios();

	public Producto cargar_producto(int aIdProducto);

	public void eliminar_producto_catalogo(int aIdProducto);

	public String cargar_remitente(int aIdRemitente);
}