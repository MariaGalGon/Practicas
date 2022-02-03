package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Abrir_menu_lateral__Cibernauta_ extends Abrir_menu_lateral {
	public Comun _comun;
	public VerticalLayout lista;
	public Enlace perfil;

	
	public Abrir_menu_lateral__Cibernauta_() {
		lista = this.getListaVertical().as(VerticalLayout.class);
		
		perfil = new Enlace();
		perfil.getNombre_seccion().setText("Perfil");
	
		lista.add(perfil);
	}
}