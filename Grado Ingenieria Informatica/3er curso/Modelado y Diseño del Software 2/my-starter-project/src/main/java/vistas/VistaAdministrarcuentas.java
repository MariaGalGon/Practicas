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
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-administrarcuentas template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-administrarcuentas")
@JsModule("./src/vista-administrarcuentas.js")
public class VistaAdministrarcuentas extends PolymerTemplate<VistaAdministrarcuentas.VistaAdministrarcuentasModel> {

    @Id("cabecera_administrar_cuentas")
	private HorizontalLayout cabecera_administrar_cuentas;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("titulo_administrar_cuentas")
	private H2 titulo_administrar_cuentas;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("logo")
	private Image logo;
	@Id("layout_tabs")
	private Element layout_tabs;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("contenido_tabs")
	private Element contenido_tabs;

	/**
     * Creates a new VistaAdministrarcuentas.
     */
    public VistaAdministrarcuentas() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaAdministrarcuentas and vista-administrarcuentas
     */
    public interface VistaAdministrarcuentasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera_administrar_cuentas() {
		return cabecera_administrar_cuentas;
	}

	public void setCabecera_administrar_cuentas(HorizontalLayout cabecera_administrar_cuentas) {
		this.cabecera_administrar_cuentas = cabecera_administrar_cuentas;
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

	public H2 getTitulo_administrar_cuentas() {
		return titulo_administrar_cuentas;
	}

	public void setTitulo_administrar_cuentas(H2 titulo_administrar_cuentas) {
		this.titulo_administrar_cuentas = titulo_administrar_cuentas;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
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

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Element getContenido_tabs() {
		return contenido_tabs;
	}

	public void setContenido_tabs(Element contenido_tabs) {
		this.contenido_tabs = contenido_tabs;
	}
}
