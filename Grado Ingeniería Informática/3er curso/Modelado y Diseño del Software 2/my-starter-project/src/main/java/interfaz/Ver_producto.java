package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaVerproducto;



public class Ver_producto extends VistaVerproducto {

	
	public Ver_producto() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		
		this.getFoto_producto().setSrc("/img/imagen.jpg");
		this.getFoto_producto().setHeight("14.5em");
		
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
	}
	
}