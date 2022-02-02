package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_identificado;
import basedatos.iComun;
import vistas.VistaEscribircomentario;

public class Escribir_comentario extends VistaEscribircomentario{

	int valoracion;
	int idProducto;
	int idUsuario;
	iCibernauta_identificado ci = new BDPrincipal();

	
	public Escribir_comentario() {
		inicializar();
	}
	
	private void inicializar() {
		this.getContador_valoracion().setVisible(false);
		this.getEstrella_1().setSrc("/img/estrella_vacia.png");
		this.getEstrella_1().setHeight("2.5em");
		this.getEstrella_2().setSrc("/img/estrella_vacia.png");
		this.getEstrella_2().setHeight("2.5em");
		this.getEstrella_3().setSrc("/img/estrella_vacia.png");
		this.getEstrella_3().setHeight("2.5em");
		this.getEstrella_4().setSrc("/img/estrella_vacia.png");
		this.getEstrella_4().setHeight("2.5em");
		this.getEstrella_5().setSrc("/img/estrella_vacia.png");
		this.getEstrella_5().setHeight("2.5em");
		
		valoracion = 0;
		botones_Estrellas();
	}
	
	public void botones_Estrellas() {
		getEstrella_1().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {				
				getEstrella_1().setSrc("/img/estrella_llena.png");
				getEstrella_1().setHeight("2.5em");
				getEstrella_2().setSrc("/img/estrella_vacia.png");
				getEstrella_2().setHeight("2.5em");
				getEstrella_3().setSrc("/img/estrella_vacia.png");
				getEstrella_3().setHeight("2.5em");
				getEstrella_4().setSrc("/img/estrella_vacia.png");
				getEstrella_4().setHeight("2.5em");
				getEstrella_5().setSrc("/img/estrella_vacia.png");
				getEstrella_5().setHeight("2.5em");
				
				valoracion = 1;
				
			}
		});
		
		getEstrella_2().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				getEstrella_1().setSrc("/img/estrella_llena.png");
				getEstrella_1().setHeight("2.5em");
				getEstrella_2().setSrc("/img/estrella_llena.png");
				getEstrella_2().setHeight("2.5em");
				getEstrella_3().setSrc("/img/estrella_vacia.png");
				getEstrella_3().setHeight("2.5em");
				getEstrella_4().setSrc("/img/estrella_vacia.png");
				getEstrella_4().setHeight("2.5em");
				getEstrella_5().setSrc("/img/estrella_vacia.png");
				getEstrella_5().setHeight("2.5em");
				
				valoracion = 2;
			}
		});
		
		getEstrella_3().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				getEstrella_1().setSrc("/img/estrella_llena.png");
				getEstrella_1().setHeight("2.5em");
				getEstrella_2().setSrc("/img/estrella_llena.png");
				getEstrella_2().setHeight("2.5em");
				getEstrella_3().setSrc("/img/estrella_llena.png");
				getEstrella_3().setHeight("2.5em");
				getEstrella_4().setSrc("/img/estrella_vacia.png");
				getEstrella_4().setHeight("2.5em");
				getEstrella_5().setSrc("/img/estrella_vacia.png");
				getEstrella_5().setHeight("2.5em");
				
				valoracion = 3;
			}
		});
		
		getEstrella_4().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				getEstrella_1().setSrc("/img/estrella_llena.png");
				getEstrella_1().setHeight("2.5em");
				getEstrella_2().setSrc("/img/estrella_llena.png");
				getEstrella_2().setHeight("2.5em");
				getEstrella_3().setSrc("/img/estrella_llena.png");
				getEstrella_3().setHeight("2.5em");
				getEstrella_4().setSrc("/img/estrella_llena.png");
				getEstrella_4().setHeight("2.5em");
				getEstrella_5().setSrc("/img/estrella_vacia.png");
				getEstrella_5().setHeight("2.5em");
				
				valoracion = 4;
			}
		});
		
		getEstrella_5().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				getEstrella_1().setSrc("/img/estrella_llena.png");
				getEstrella_1().setHeight("2.5em");
				getEstrella_2().setSrc("/img/estrella_llena.png");
				getEstrella_2().setHeight("2.5em");
				getEstrella_3().setSrc("/img/estrella_llena.png");
				getEstrella_3().setHeight("2.5em");
				getEstrella_4().setSrc("/img/estrella_llena.png");
				getEstrella_4().setHeight("2.5em");
				getEstrella_5().setSrc("/img/estrella_llena.png");
				getEstrella_5().setHeight("2.5em");
				
				valoracion = 5;
			}
		});
	}
	
	public boolean comprobar_campos() {
		if(this.getArea_texto_comentario().getValue().equals("") || valoracion == 0) {
			Notification.show("Rellene todos los campos.");
			return false;
		}
		return true;
	}
	
	public void publicar() {
		
		ci.publicar_comentario(idUsuario, this.getArea_texto_comentario().getValue(), valoracion, idProducto);
	}
}