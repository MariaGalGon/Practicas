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

/**
 * A Designer generated component for the vista-buscarproducto template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-buscarproducto")
@JsModule("./src/vista-buscarproducto.js")
public class VistaBuscarproducto extends PolymerTemplate<VistaBuscarproducto.VistaBuscarproductoModel> {

    @Id("cabecera_admin_buscar_producto")
	private HorizontalLayout cabecera_admin_buscar_producto;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("barra_busqueda_producto")
	private TextField barra_busqueda_producto;
	@Id("boton_buscar")
	private Button boton_buscar;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("cabecera_cibernauta_buscar_producto")
	private HorizontalLayout cabecera_cibernauta_buscar_producto;
	@Id("boton_menu1")
	private Button boton_menu1;
	@Id("icono_menu1")
	private Element icono_menu1;
	@Id("barra_busqueda")
	private TextField barra_busqueda;
	@Id("boton_buscar1")
	private Button boton_buscar1;
	@Id("boton_carrito")
	private Button boton_carrito;
	@Id("icono_carrito")
	private Element icono_carrito;
	@Id("label_contador")
	private Label label_contador;
	@Id("boton_perfil1")
	private Button boton_perfil1;
	@Id("icono_perfil1")
	private Element icono_perfil1;
	@Id("logo_admin")
	private Image logo_admin;
	@Id("logo_user")
	private Image logo_user;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("resultados")
	private HorizontalLayout resultados;

	/**
     * Creates a new VistaBuscarproducto.
     */
    public VistaBuscarproducto() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaBuscarproducto and vista-buscarproducto
     */
    public interface VistaBuscarproductoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera_admin_buscar_producto() {
		return cabecera_admin_buscar_producto;
	}

	public void setCabecera_admin_buscar_producto(HorizontalLayout cabecera_admin_buscar_producto) {
		this.cabecera_admin_buscar_producto = cabecera_admin_buscar_producto;
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


	public TextField getBarra_busqueda_producto() {
		return barra_busqueda_producto;
	}

	public void setBarra_busqueda_producto(TextField barra_busqueda_producto) {
		this.barra_busqueda_producto = barra_busqueda_producto;
	}

	public Button getBoton_buscar() {
		return boton_buscar;
	}

	public void setBoton_buscar(Button boton_buscar) {
		this.boton_buscar = boton_buscar;
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

	public HorizontalLayout getCabecera_cibernauta_buscar_producto() {
		return cabecera_cibernauta_buscar_producto;
	}

	public void setCabecera_cibernauta_buscar_producto(HorizontalLayout cabecera_cibernauta_buscar_producto) {
		this.cabecera_cibernauta_buscar_producto = cabecera_cibernauta_buscar_producto;
	}

	public Button getBoton_menu1() {
		return boton_menu1;
	}

	public void setBoton_menu1(Button boton_menu1) {
		this.boton_menu1 = boton_menu1;
	}

	public Element getIcono_menu1() {
		return icono_menu1;
	}

	public void setIcono_menu1(Element icono_menu1) {
		this.icono_menu1 = icono_menu1;
	}



	public TextField getBarra_busqueda() {
		return barra_busqueda;
	}

	public void setBarra_busqueda(TextField barra_busqueda) {
		this.barra_busqueda = barra_busqueda;
	}

	public Button getBoton_buscar1() {
		return boton_buscar1;
	}

	public void setBoton_buscar1(Button boton_buscar1) {
		this.boton_buscar1 = boton_buscar1;
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

	public Label getLabel_contador() {
		return label_contador;
	}

	public void setLabel_contador(Label label_contador) {
		this.label_contador = label_contador;
	}

	public Button getBoton_perfil1() {
		return boton_perfil1;
	}

	public void setBoton_perfil1(Button boton_perfil1) {
		this.boton_perfil1 = boton_perfil1;
	}

	public Element getIcono_perfil1() {
		return icono_perfil1;
	}

	public void setIcono_perfil1(Element icono_perfil1) {
		this.icono_perfil1 = icono_perfil1;
	}

	public Image getLogo_admin() {
		return logo_admin;
	}

	public void setLogo_admin(Image logo_admin) {
		this.logo_admin = logo_admin;
	}

	public Image getLogo_user() {
		return logo_user;
	}

	public void setLogo_user(Image logo_user) {
		this.logo_user = logo_user;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getResultados() {
		return resultados;
	}

	public void setResultados(HorizontalLayout resultados) {
		this.resultados = resultados;
	}
}
