package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.H2;
import vistas.VistaCategoria;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-listacategorias template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listacategorias")
@JsModule("./src/vista-listacategorias.js")
public class VistaListacategorias extends PolymerTemplate<VistaListacategorias.VistaListacategoriasModel> {

	@Id("boton_menu")
	private Button boton_menu;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("titulo_categorias")
	private H2 titulo_categorias;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icon_perfil")
	private Element icon_perfil;
	@Id("cabecera_categorias")
	private HorizontalLayout cabecera_categorias;
	@Id("lista_categorias")
	private Element lista_categorias;
	@Id("boton_aniadir_categoria")
	private Button boton_aniadir_categoria;
	@Id("boton_seleccionar_categoria")
	private Button boton_seleccionar_categoria;
	@Id("logo")
	private Image logo;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("botones")
	private HorizontalLayout botones;
	/**
     * Creates a new VistaListacategorias.
     */
    public VistaListacategorias() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListacategorias and vista-listacategorias
     */
    public interface VistaListacategoriasModel extends TemplateModel {
        // Add setters and getters for template properties here.
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

	public H2 getTitulo_categorias() {
		return titulo_categorias;
	}

	public void setTitulo_categorias(H2 titulo_categorias) {
		this.titulo_categorias = titulo_categorias;
	}

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public Button getBoton_perfil() {
		return boton_perfil;
	}

	public void setBoton_perfil(Button boton_perfil) {
		this.boton_perfil = boton_perfil;
	}

	public Element getIcon_perfil() {
		return icon_perfil;
	}

	public void setIcon_perfil(Element icon_perfil) {
		this.icon_perfil = icon_perfil;
	}

	public HorizontalLayout getCabecera_categorias() {
		return cabecera_categorias;
	}

	public void setCabecera_categorias(HorizontalLayout cabecera_categorias) {
		this.cabecera_categorias = cabecera_categorias;
	}

	public Element getLista_categorias() {
		return lista_categorias;
	}

	public void setLista_categorias(Element lista_categorias) {
		this.lista_categorias = lista_categorias;
	}

	public Button getBoton_aniadir_categoria() {
		return boton_aniadir_categoria;
	}

	public void setBoton_aniadir_categoria(Button boton_aniadir_categoria) {
		this.boton_aniadir_categoria = boton_aniadir_categoria;
	}

	public Button getBoton_seleccionar_categoria() {
		return boton_seleccionar_categoria;
	}

	public void setBoton_seleccionar_categoria(Button boton_seleccionar_categoria) {
		this.boton_seleccionar_categoria = boton_seleccionar_categoria;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getBotones() {
		return botones;
	}

	public void setBotones(HorizontalLayout botones) {
		this.botones = botones;
	}

	
}
