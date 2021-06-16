package basedatos;

import java.sql.Date;

public interface iEncargado_compras {

	public void guardar_datos(String[] aDatos, int aIdUsuario);

	public Pedido[] elegir_estado_pedido(String aEstado, int[] aIdPedidos);

	public void cambiar_estado_pedido(String aEstado, int aIdPedido, Date aFecha);
}