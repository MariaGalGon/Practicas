package interfaz;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_identificado;
import vistas.VistaConfirmar;



public class Confirmar extends VistaConfirmar{

	
	int idUsuario;
	private iCibernauta_identificado cibernauta = new BDPrincipal();
	
	public Confirmar() {
		inicializar();		
	}
	
	private void inicializar() {
		this.getFoto().setSrc("/img/esperar.png");
		this.getFoto().setHeight("10em");
	}
	
	public void confirmar_baja() {
		cibernauta.confirmar_baja(idUsuario);
	}
}