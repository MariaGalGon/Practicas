package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_identificado;
import vistas.VistaVerdatoscibernauta;



public class Ver_datos__Cibernauta_ extends VistaVerdatoscibernauta {
	
	public Ver_datos datos;
	public Ver_datos__imagen_ imagen;
	public VerticalLayout layoutDatos;
	public VerticalLayout layoutImagen;
	
	public Ver_datos__Cibernauta_() {
		layoutImagen = this.getImagen().as(VerticalLayout.class);
		layoutDatos = this.getDatos().as(VerticalLayout.class);
		
		datos = new  Ver_datos();
		imagen = new Ver_datos__imagen_();
		
		layoutImagen.add(imagen);
		layoutDatos.add(datos);
		
	}
}