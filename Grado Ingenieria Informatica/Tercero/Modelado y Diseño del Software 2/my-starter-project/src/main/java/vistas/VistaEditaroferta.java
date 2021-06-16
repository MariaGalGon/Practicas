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
import com.vaadin.flow.component.html.H3;
import vistas.VistaInformacion;
import vistas.VistaVerproductosasociados;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;

/**
 * A Designer generated component for the vista-editaroferta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-editaroferta")
@JsModule("./src/vista-editaroferta.js")
public class VistaEditaroferta extends PolymerTemplate<VistaEditaroferta.VistaEditarofertaModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("titulo_oferta")
	private H2 titulo_oferta;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("cabecera_ofertas")
	private Element cabecera_ofertas;
	@Id("cabcera2")
	private HorizontalLayout cabcera2;
	@Id("logo")
	private Image logo;
	@Id("boton_guardar")
	private Button boton_guardar;
	@Id("vaadinHorizontalLayout2")
	private HorizontalLayout vaadinHorizontalLayout2;
	@Id("nombre_oferta1")
	private TextField nombre_oferta1;
	@Id("layout_tabs")
	private Element layout_tabs;
	@Id("contenido_tabs")
	private Element contenido_tabs;

	/**
     * Creates a new VistaEditaroferta.
     */
    public VistaEditaroferta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEditaroferta and vista-editaroferta
     */
    public interface VistaEditarofertaModel extends TemplateModel {
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

	public Element getIcono_menu() {
		return icono_menu;
	}

	public void setIcono_menu(Element icono_menu) {
		this.icono_menu = icono_menu;
	}

	public H2 getTitulo_oferta() {
		return titulo_oferta;
	}

	public void setTitulo_oferta(H2 titulo_oferta) {
		this.titulo_oferta = titulo_oferta;
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

	public Element getCabecera_ofertas() {
		return cabecera_ofertas;
	}

	public void setCabecera_ofertas(Element cabecera_ofertas) {
		this.cabecera_ofertas = cabecera_ofertas;
	}

	public HorizontalLayout getCabcera2() {
		return cabcera2;
	}

	public void setCabcera2(HorizontalLayout cabcera2) {
		this.cabcera2 = cabcera2;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Button getBoton_guardar() {
		return boton_guardar;
	}

	public void setBoton_guardar(Button boton_guardar) {
		this.boton_guardar = boton_guardar;
	}

	public HorizontalLayout getVaadinHorizontalLayout2() {
		return vaadinHorizontalLayout2;
	}

	public void setVaadinHorizontalLayout2(HorizontalLayout vaadinHorizontalLayout2) {
		this.vaadinHorizontalLayout2 = vaadinHorizontalLayout2;
	}

	public TextField getNombre_oferta1() {
		return nombre_oferta1;
	}

	public void setNombre_oferta1(TextField nombre_oferta1) {
		this.nombre_oferta1 = nombre_oferta1;
	}

	public Element getLayout_tabs() {
		return layout_tabs;
	}

	public void setLayout_tabs(Element layout_tabs) {
		this.layout_tabs = layout_tabs;
	}

	public Element getContenido_tabs() {
		return contenido_tabs;
	}

	public void setContenido_tabs(Element contenido_tabs) {
		this.contenido_tabs = contenido_tabs;
	}
	
	
}
