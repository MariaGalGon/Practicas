package basedatos;

public interface iComun {

	public Producto[] cargar_productos_destacados();

	public Oferta[] cargar_ofertas();

	public Categoria[] cargar_categorias_combobox();

	public Producto[] buscar_producto(String aBusqueda);

	public Producto cargar_datos_producto(int aIdProducto);

	public Anuncio[] cargar_anuncios();
}