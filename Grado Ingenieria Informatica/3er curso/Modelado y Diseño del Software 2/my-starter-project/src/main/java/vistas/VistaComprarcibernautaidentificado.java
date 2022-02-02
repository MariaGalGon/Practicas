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
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;

/**
 * A Designer generated component for the vista-comprarcibernautaidentificado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-comprarcibernautaidentificado")
@JsModule("./src/vista-comprarcibernautaidentificado.js")
public class VistaComprarcibernautaidentificado extends PolymerTemplate<VistaComprarcibernautaidentificado.VistaComprarcibernautaidentificadoModel> {

    @Id("cabecera_carrito")
	private HorizontalLayout cabecera_carrito;
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
	@Id("label_contador")
	private Label label_contador;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("cuadro_datos_envio")
	private Element cuadro_datos_envio;
	@Id("titulo_datos_envio")
	private H2 titulo_datos_envio;
	@Id("envio_nombre")
	private TextField envio_nombre;
	@Id("envio_direccion")
	private TextField envio_direccion;
	@Id("envio_num_cuenta")
	private TextField envio_num_cuenta;
	@Id("envio_apellidos")
	private TextField envio_apellidos;
	@Id("envio_cvv")
	private TextField envio_cvv;
	@Id("cuadro_resumen_carrito")
	private Element cuadro_resumen_carrito;
	@Id("titulo_resumen")
	private H3 titulo_resumen;
	@Id("boton_comprar_carrito")
	private Button boton_comprar_carrito;
	@Id("logo")
	private Image logo;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("subtotal")
	private Paragraph subtotal;
	@Id("envio")
	private Paragraph envio;
	@Id("total")
	private Paragraph total;
	/**
     * Creates a new VistaComprarcibernautaidentificado.
     */
    public VistaComprarcibernautaidentificado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaComprarcibernautaidentificado and vista-comprarcibernautaidentificado
     */
    public interface VistaComprarcibernautaidentificadoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera_carrito() {
		return cabecera_carrito;
	}

	public void setCabecera_carrito(HorizontalLayout cabecera_carrito) {
		this.cabecera_carrito = cabecera_carrito;
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

	public Label getLabel_contador() {
		return label_contador;
	}

	public void setLabel_contador(Label label_contador) {
		this.label_contador = label_contador;
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

	public Element getCuadro_datos_envio() {
		return cuadro_datos_envio;
	}

	public void setCuadro_datos_envio(Element cuadro_datos_envio) {
		this.cuadro_datos_envio = cuadro_datos_envio;
	}

	public H2 getTitulo_datos_envio() {
		return titulo_datos_envio;
	}

	public void setTitulo_datos_envio(H2 titulo_datos_envio) {
		this.titulo_datos_envio = titulo_datos_envio;
	}

	public TextField getEnvio_nombre() {
		return envio_nombre;
	}

	public void setEnvio_nombre(TextField envio_nombre) {
		this.envio_nombre = envio_nombre;
	}

	public TextField getEnvio_direccion() {
		return envio_direccion;
	}

	public void setEnvio_direccion(TextField envio_direccion) {
		this.envio_direccion = envio_direccion;
	}

	public TextField getEnvio_num_cuenta() {
		return envio_num_cuenta;
	}

	public void setEnvio_num_cuenta(TextField envio_num_cuenta) {
		this.envio_num_cuenta = envio_num_cuenta;
	}

	public TextField getEnvio_apellidos() {
		return envio_apellidos;
	}

	public void setEnvio_apellidos(TextField envio_apellidos) {
		this.envio_apellidos = envio_apellidos;
	}

	public TextField getEnvio_cvv() {
		return envio_cvv;
	}

	public void setEnvio_cvv(TextField envio_cvv) {
		this.envio_cvv = envio_cvv;
	}

	public Element getCuadro_resumen_carrito() {
		return cuadro_resumen_carrito;
	}

	public void setCuadro_resumen_carrito(Element cuadro_resumen_carrito) {
		this.cuadro_resumen_carrito = cuadro_resumen_carrito;
	}

	public H3 getTitulo_resumen() {
		return titulo_resumen;
	}

	public void setTitulo_resumen(H3 titulo_resumen) {
		this.titulo_resumen = titulo_resumen;
	}

	public Button getBoton_comprar_carrito() {
		return boton_comprar_carrito;
	}

	public void setBoton_comprar_carrito(Button boton_comprar_carrito) {
		this.boton_comprar_carrito = boton_comprar_carrito;
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

	public Paragraph getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Paragraph subtotal) {
		this.subtotal = subtotal;
	}

	public Paragraph getEnvio() {
		return envio;
	}

	public void setEnvio(Paragraph envio) {
		this.envio = envio;
	}

	public Paragraph getTotal() {
		return total;
	}

	public void setTotal(Paragraph total) {
		this.total = total;
	}
}
