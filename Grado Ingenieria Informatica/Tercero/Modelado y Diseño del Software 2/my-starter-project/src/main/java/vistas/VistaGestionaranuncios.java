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
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import vistas.VistaEditaranuncio;
import vistas.VistaListaanuncios;

/**
 * A Designer generated component for the vista-gestionaranuncios template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-gestionaranuncios")
@JsModule("./src/vista-gestionaranuncios.js")
public class VistaGestionaranuncios extends PolymerTemplate<VistaGestionaranuncios.VistaGestionaranunciosModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_menu")
	private Button boton_menu;
	private Element icono_logo;
	@Id("titulo_gestionar_anuncios")
	private H2 titulo_gestionar_anuncios;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("cuerpo_gestionar_anuncios")
	private HorizontalLayout cuerpo_gestionar_anuncios;
	@Id("cuadro_vista")
	private Element cuadro_vista;
	@Id("titulo_vista")
	private H4 titulo_vista;
	@Id("imagen_vista")
	private Image imagen_vista;
	@Id("vaadinHorizontalLayout2")
	private HorizontalLayout vaadinHorizontalLayout2;
	@Id("cuadro_lista_anuncios")
	private Element cuadro_lista_anuncios;
	@Id("titulo_lista_anuncios")
	private H4 titulo_lista_anuncios;
	@Id("logo")
	private Image logo;
	@Id("layout_lista")
	private Element layout_lista;
	@Id("layout_editar")
	private Element layout_editar;
	/**
     * Creates a new VistaGestionaranuncios.
     */
    public VistaGestionaranuncios() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaGestionaranuncios and vista-gestionaranuncios
     */
    public interface VistaGestionaranunciosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Button getBoton_menu() {
		return boton_menu;
	}

	public void setBoton_menu(Button boton_menu) {
		this.boton_menu = boton_menu;
	}

	public Element getIcono_logo() {
		return icono_logo;
	}

	public void setIcono_logo(Element icono_logo) {
		this.icono_logo = icono_logo;
	}

	public H2 getTitulo_gestionar_anuncios() {
		return titulo_gestionar_anuncios;
	}

	public void setTitulo_gestionar_anuncios(H2 titulo_gestionar_anuncios) {
		this.titulo_gestionar_anuncios = titulo_gestionar_anuncios;
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

	public Element getIcono_perfil() {
		return icono_perfil;
	}

	public void setIcono_perfil(Element icono_perfil) {
		this.icono_perfil = icono_perfil;
	}

	public HorizontalLayout getCuerpo_gestionar_anuncios() {
		return cuerpo_gestionar_anuncios;
	}

	public void setCuerpo_gestionar_anuncios(HorizontalLayout cuerpo_gestionar_anuncios) {
		this.cuerpo_gestionar_anuncios = cuerpo_gestionar_anuncios;
	}

	public Element getCuadro_vista() {
		return cuadro_vista;
	}

	public void setCuadro_vista(Element cuadro_vista) {
		this.cuadro_vista = cuadro_vista;
	}

	public H4 getTitulo_vista() {
		return titulo_vista;
	}

	public void setTitulo_vista(H4 titulo_vista) {
		this.titulo_vista = titulo_vista;
	}

	public Image getImagen_vista() {
		return imagen_vista;
	}

	public void setImagen_vista(Image imagen_vista) {
		this.imagen_vista = imagen_vista;
	}

	public HorizontalLayout getVaadinHorizontalLayout2() {
		return vaadinHorizontalLayout2;
	}

	public void setVaadinHorizontalLayout2(HorizontalLayout vaadinHorizontalLayout2) {
		this.vaadinHorizontalLayout2 = vaadinHorizontalLayout2;
	}

	public Element getCuadro_lista_anuncios() {
		return cuadro_lista_anuncios;
	}

	public void setCuadro_lista_anuncios(Element cuadro_lista_anuncios) {
		this.cuadro_lista_anuncios = cuadro_lista_anuncios;
	}

	public H4 getTitulo_lista_anuncios() {
		return titulo_lista_anuncios;
	}

	public void setTitulo_lista_anuncios(H4 titulo_lista_anuncios) {
		this.titulo_lista_anuncios = titulo_lista_anuncios;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Element getLayout_lista() {
		return layout_lista;
	}

	public void setLayout_lista(Element layout_lista) {
		this.layout_lista = layout_lista;
	}

	public Element getLayout_editar() {
		return layout_editar;
	}

	public void setLayout_editar(Element layout_editar) {
		this.layout_editar = layout_editar;
	}
}
