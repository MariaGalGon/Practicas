package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_no_identificado;
import vistas.VistaRecuperarcontrasenia;

public class Recuperar_contrasenia extends VistaRecuperarcontrasenia {

	private iCibernauta_no_identificado cibernauta = new BDPrincipal();
	public static boolean encontrada;
	
	public void recuperar_contrasenia() {
		cibernauta.recuperar_contrasenia(this.getCorreo().getValue());
	}
	
}