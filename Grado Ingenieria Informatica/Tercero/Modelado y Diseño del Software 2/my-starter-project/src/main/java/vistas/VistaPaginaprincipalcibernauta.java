package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Image;
import vistas.VistaListaofertascibernauta;
import vistas.VistaListaproductosdestacados;

/**
 * A Designer generated component for the vista-paginaprincipalcibernauta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-paginaprincipalcibernauta")
@JsModule("./src/vista-paginaprincipalcibernauta.js")
public class VistaPaginaprincipalcibernauta extends PolymerTemplate<VistaPaginaprincipalcibernauta.VistaPaginaprincipalcibernautaModel> {

    @Id("cabecera_pagina_principal")
	private HorizontalLayout cabecera_pagina_principal;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("barra_busqueda")
	private TextField barra_busqueda;
	@Id("boton_buscar")
	private Button boton_buscar;
	@Id("boton_carrito")
	private Button boton_carrito;
	@Id("icono_carrito")
	private Element icono_carrito;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("contenido_pagina_principal")
	private HorizontalLayout contenido_pagina_principal;
	@Id("anuncio_pagina_principal")
	private Image anuncio_pagina_principal;
	@Id("listas_pagina_principal")
	private Element listas_pagina_principal;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("logo")
	private Image logo;
	@Id("contador")
	private Label contador;
	/**
     * Creates a new VistaPaginaprincipalcibernauta.
     */
    public VistaPaginaprincipalcibernauta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaPaginaprincipalcibernauta and vista-paginaprincipalcibernauta
     */
    public interface VistaPaginaprincipalcibernautaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera_pagina_principal() {
		return cabecera_pagina_principal;
	}

	public void setCabecera_pagina_principal(HorizontalLayout cabecera_pagina_principal) {
		this.cabecera_pagina_principal = cabecera_pagina_principal;
	}

	public Button getBoton_menu() {
		return boton_menu;
	}

	public void setBoton_menu(Button boton_menu) {
		this.boton_menu = boton_menu;
	}

	public Element getIcono_menu() {
		return icono_menu;
	}

	public void setIcono_menu(Element icono_menu) {
		this.icono_menu = icono_menu;
	}

	public TextField getBarra_busqueda() {
		return barra_busqueda;
	}

	public void setBarra_busqueda(TextField barra_busqueda) {
		this.barra_busqueda = barra_busqueda;
	}

	public Button getBoton_buscar() {
		return boton_buscar;
	}

	public void setBoton_buscar(Button boton_buscar) {
		this.boton_buscar = boton_buscar;
	}

	public Button getBoton_carrito() {
		return boton_carrito;
	}

	public void setBoton_carrito(Button boton_carrito) {
		this.boton_carrito = boton_carrito;
	}

	public Element getIcono_carrito() {
		return icono_carrito;
	}

	public void setIcono_carrito(Element icono_carrito) {
		this.icono_carrito = icono_carrito;
	}


	public Button getBoton_perfil() {
		return boton_perfil;
	}

	public void setBoton_perfil(Button boton_perfil) {
		this.boton_perfil = boton_perfil;
	}

	public Element getIcono_perfil() {
		return icono_perfil;
	}

	public void setIcono_perfil(Element icono_perfil) {
		this.icono_perfil = icono_perfil;
	}

	public HorizontalLayout getContenido_pagina_principal() {
		return contenido_pagina_principal;
	}

	public void setContenido_pagina_principal(HorizontalLayout contenido_pagina_principal) {
		this.contenido_pagina_principal = contenido_pagina_principal;
	}

	public Image getAnuncio_pagina_principal() {
		return anuncio_pagina_principal;
	}

	public void setAnuncio_pagina_principal(Image anuncio_pagina_principal) {
		this.anuncio_pagina_principal = anuncio_pagina_principal;
	}

	public Element getListas_pagina_principal() {
		return listas_pagina_principal;
	}

	public void setListas_pagina_principal(Element listas_pagina_principal) {
		this.listas_pagina_principal = listas_pagina_principal;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Label getContador() {
		return contador;
	}

	public void setContador(Label contador) {
		this.contador = contador;
	}

	

}
