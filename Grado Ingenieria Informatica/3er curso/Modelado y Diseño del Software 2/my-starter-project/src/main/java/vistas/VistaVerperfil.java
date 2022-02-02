package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

/**
 * A Designer generated component for the vista-verperfil template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verperfil")
@JsModule("./src/vista-verperfil.js")
public class VistaVerperfil extends PolymerTemplate<VistaVerperfil.VistaVerperfilModel> {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("cabeceras")
	private HorizontalLayout cabeceras;
	@Id("ironIcon")
	private Element ironIcon;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("titulo_admin")
	private H2 titulo_admin;
	@Id("barra_busqueda")
	private TextField barra_busqueda;
	@Id("titulo_perfil")
	private H2 titulo_perfil;
	@Id("boton_buscar")
	private Button boton_buscar;
	@Id("boton_carrito")
	private Button boton_carrito;
	@Id("icono_carrito")
	private Element icono_carrito;
	@Id("contador")
	private Label contador;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("ironIcon1")
	private Element ironIcon1;
	@Id("logo")
	private Image logo;
	@Id("layout_tabs")
	private Element layout_tabs;
	@Id("tab_envios")
	private Button tab_envios;
	@Id("tab_perfil")
	private Button tab_perfil;
	@Id("contenido_tabs")
	private Element contenido_tabs;
	@Id("botones_repartidor")
	private HorizontalLayout botones_repartidor;

	/**
     * Creates a new VistaVerperfil.
     */
    public VistaVerperfil() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerperfil and vista-verperfil
     */
    public interface VistaVerperfilModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(HorizontalLayout cabeceras) {
		this.cabeceras = cabeceras;
	}

	public Element getIronIcon() {
		return ironIcon;
	}

	public void setIronIcon(Element ironIcon) {
		this.ironIcon = ironIcon;
	}

	public Button getBoton_menu() {
		return boton_menu;
	}

	public void setBoton_menu(Button boton_menu) {
		this.boton_menu = boton_menu;
	}

	public H2 getTitulo_admin() {
		return titulo_admin;
	}

	public void setTitulo_admin(H2 titulo_admin) {
		this.titulo_admin = titulo_admin;
	}

	public TextField getBarra_busqueda() {
		return barra_busqueda;
	}

	public void setBarra_busqueda(TextField barra_busqueda) {
		this.barra_busqueda = barra_busqueda;
	}

	public H2 getTitulo_perfil() {
		return titulo_perfil;
	}

	public void setTitulo_perfil(H2 titulo_perfil) {
		this.titulo_perfil = titulo_perfil;
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

	public Label getContador() {
		return contador;
	}

	public void setContador(Label contador) {
		this.contador = contador;
	}

	public Button getBoton_perfil() {
		return boton_perfil;
	}

	public void setBoton_perfil(Button boton_perfil) {
		this.boton_perfil = boton_perfil;
	}

	public Element getIronIcon1() {
		return ironIcon1;
	}

	public void setIronIcon1(Element ironIcon1) {
		this.ironIcon1 = ironIcon1;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Element getLayout_tabs() {
		return layout_tabs;
	}

	public void setLayout_tabs(Element layout_tabs) {
		this.layout_tabs = layout_tabs;
	}

	public Button getTab_envios() {
		return tab_envios;
	}

	public void setTab_envios(Button tab_envios) {
		this.tab_envios = tab_envios;
	}

	public Button getTab_perfil() {
		return tab_perfil;
	}

	public void setTab_perfil(Button tab_perfil) {
		this.tab_perfil = tab_perfil;
	}

	public Element getContenido_tabs() {
		return contenido_tabs;
	}

	public void setContenido_tabs(Element contenido_tabs) {
		this.contenido_tabs = contenido_tabs;
	}

	public HorizontalLayout getBotones_repartidor() {
		return botones_repartidor;
	}

	public void setBotones_repartidor(HorizontalLayout botones_repartidor) {
		this.botones_repartidor = botones_repartidor;
	}
}
