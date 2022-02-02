package basedatos;

public interface iCibernauta_no_identificado extends iComun {

	public void iniciar_sesion(String aCorreo, String aContrasenia);

	public void cargar_repartidor(int aIdRepartidor);

	public void cargar_encargado(int aIdEncargado);

	public void cargar_admin(int aIdAdmin);

	public void cargar_cibernauta(int aIdCibernauta);

	public boolean registrarse(String[] aDatos);

	public void recuperar_contrasenia(String aCorreo);
}