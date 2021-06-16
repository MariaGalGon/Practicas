package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.H4;
import vistas.VistaListaproductosasociados;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;

/**
 * A Designer generated component for the vista-editarproductoscategoria template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-editarproductoscategoria")
@JsModule("./src/vista-editarproductoscategoria.js")
public class VistaEditarproductoscategoria extends PolymerTemplate<VistaEditarproductoscategoria.VistaEditarproductoscategoriaModel> {

    @Id("cuadro_info")
	private HorizontalLayout cuadro_info;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_guardar")
	private Button boton_guardar;
	@Id("cabecera_categorias")
	private HorizontalLayout cabecera_categorias;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("titulo_categorias")
	private H2 titulo_categorias;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("logo")
	private Image logo;
	@Id("nombre_categoria")
	private TextField nombre_categoria;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaEditarproductoscategoria.
     */
    public VistaEditarproductoscategoria() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEditarproductoscategoria and vista-editarproductoscategoria
     */
    public interface VistaEditarproductoscategoriaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCuadro_info() {
		return cuadro_info;
	}

	public void setCuadro_info(HorizontalLayout cuadro_info) {
		this.cuadro_info = cuadro_info;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Button getBoton_guardar() {
		return boton_guardar;
	}

	public void setBoton_guardar(Button boton_guardar) {
		this.boton_guardar = boton_guardar;
	}

	public HorizontalLayout getCabecera_categorias() {
		return cabecera_categorias;
	}

	public void setCabecera_categorias(HorizontalLayout cabecera_categorias) {
		this.cabecera_categorias = cabecera_categorias;
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

	public Element getIcono_perfil() {
		return icono_perfil;
	}

	public void setIcono_perfil(Element icono_perfil) {
		this.icono_perfil = icono_perfil;
	}

	public Button getBoton_perfil() {
		return boton_perfil;
	}

	public void setBoton_perfil(Button boton_perfil) {
		this.boton_perfil = boton_perfil;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public TextField getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(TextField nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}
}
