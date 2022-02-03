package basedatos;

public interface iCibernauta_identificado extends iComun {

	public void realizar_compra(Cibernauta aUsuario, Item[] aCarrito);

	public void guardar_datos(String[] aDatos, int aIdUsuario, String aFoto);

	public void confirmar_baja(int aIdUsuario);

	public void eliminar_mensaje(int aIdUsuario, int aIdMensaje);

	public void cancelar_pedido(int aIdPedido);

	public void publicar_comentario(int aIdUsuario, String aTexto, int aValoracion, int aIdProducto);

	public void enviar_mensaje(String aDestinatario_mail, String aAsunto, String aTexto, int aIdRemitente);

	public String cargar_remitente(int aIdRemitente);
}