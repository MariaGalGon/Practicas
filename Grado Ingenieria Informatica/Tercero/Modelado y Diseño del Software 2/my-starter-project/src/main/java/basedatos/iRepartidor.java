package basedatos;

public interface iRepartidor {

	public Pedido[] elegir_estado_envio(String aEstado, int[] aIdPedidos);

	public void guardar_perfil(int aIdUsuario, String aNombreApellidos, String aCorreo);

	public void cambiar_estado_envio(boolean aEntregado, int aIdPedido);
}