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
import vistas.VistaOferta;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-listaofertas template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaofertas")
@JsModule("./src/vista-listaofertas.js")
public class VistaListaofertas extends PolymerTemplate<VistaListaofertas.VistaListaofertasModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("titulo_ofertas")
	private H2 titulo_ofertas;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("cuadro_botones")
	private HorizontalLayout cuadro_botones;
	@Id("vaadinButton")
	private Button vaadinButton;
	@Id("vaadinButton1")
	private Button vaadinButton1;
	@Id("lista_ofertas")
	private Element lista_ofertas;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("boton_logo")
	private Image boton_logo;
	@Id("lista_seleccionar")
	private Element lista_seleccionar;

	/**
     * Creates a new VistaListaofertas.
     */
    public VistaListaofertas() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaofertas and vista-listaofertas
     */
    public interface VistaListaofertasModel extends TemplateModel {
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

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public H2 getTitulo_ofertas() {
		return titulo_ofertas;
	}

	public void setTitulo_ofertas(H2 titulo_ofertas) {
		this.titulo_ofertas = titulo_ofertas;
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

	public HorizontalLayout getCuadro_botones() {
		return cuadro_botones;
	}

	public void setCuadro_botones(HorizontalLayout cuadro_botones) {
		this.cuadro_botones = cuadro_botones;
	}

	public Button getVaadinButton() {
		return vaadinButton;
	}

	public void setVaadinButton(Button vaadinButton) {
		this.vaadinButton = vaadinButton;
	}

	public Button getVaadinButton1() {
		return vaadinButton1;
	}

	public void setVaadinButton1(Button vaadinButton1) {
		this.vaadinButton1 = vaadinButton1;
	}

	public Element getLista_ofertas() {
		return lista_ofertas;
	}

	public void setLista_ofertas(Element lista_ofertas) {
		this.lista_ofertas = lista_ofertas;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Image getBoton_logo() {
		return boton_logo;
	}

	public void setBoton_logo(Image boton_logo) {
		this.boton_logo = boton_logo;
	}

	public Element getLista_seleccionar() {
		return lista_seleccionar;
	}

	public void setLista_seleccionar(Element lista_seleccionar) {
		this.lista_seleccionar = lista_seleccionar;
	}
}
