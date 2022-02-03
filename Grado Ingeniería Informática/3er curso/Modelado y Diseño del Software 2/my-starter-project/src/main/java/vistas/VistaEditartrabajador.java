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
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.combobox.ComboBox;

/**
 * A Designer generated component for the vista-editartrabajador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-editartrabajador")
@JsModule("./src/vista-editartrabajador.js")
public class VistaEditartrabajador extends PolymerTemplate<VistaEditartrabajador.VistaEditartrabajadorModel> {

    @Id("cabecera_administrar_cuentas")
	private HorizontalLayout cabecera_administrar_cuentas;
	@Id("boyon_menu")
	private Button boyon_menu;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("titulo_administrar_cuentas")
	private H2 titulo_administrar_cuentas;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_perfil")
	private Button vaadinButton;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("identificador")
	private TextField identificador;
	@Id("vaadinHorizontalLayout2")
	private HorizontalLayout vaadinHorizontalLayout2;
	@Id("nombre")
	private TextField nombre;
	@Id("apellidos")
	private TextField apellidos;
	@Id("correo")
	private TextField correo;
	@Id("vaadinButton1")
	private Button vaadinButton1;
	@Id("vaadinVerticalLayout1")
	private Element vaadinVerticalLayout1;
	@Id("imagen_trabajador")
	private Image imagen_trabajador;
	@Id("vaadinVerticalLayout2")
	private Element vaadinVerticalLayout2;
	@Id("boton_guardar")
	private Button boton_guardar;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("logo")
	private Image logo;
	@Id("puesto")
	private TextField puesto;
	@Id("puestoDeTrabajo")
	private ComboBox<String> puestoDeTrabajo;
	@Id("hueco_upload")
	private HorizontalLayout hueco_upload;
	/**
     * Creates a new VistaEditartrabajador.
     */
    public VistaEditartrabajador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEditartrabajador and vista-editartrabajador
     */
    public interface VistaEditartrabajadorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera_administrar_cuentas() {
		return cabecera_administrar_cuentas;
	}

	public void setCabecera_administrar_cuentas(HorizontalLayout cabecera_administrar_cuentas) {
		this.cabecera_administrar_cuentas = cabecera_administrar_cuentas;
	}

	public Button getBoyon_menu() {
		return boyon_menu;
	}

	public void setBoyon_menu(Button boyon_menu) {
		this.boyon_menu = boyon_menu;
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

	public Button getVaadinButton() {
		return vaadinButton;
	}

	public void setVaadinButton(Button vaadinButton) {
		this.vaadinButton = vaadinButton;
	}

	public Element getIcono_perfil() {
		return icono_perfil;
	}

	public void setIcono_perfil(Element icono_perfil) {
		this.icono_perfil = icono_perfil;
	}

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public TextField getIdentificador() {
		return identificador;
	}

	public void setIdentificador(TextField identificador) {
		this.identificador = identificador;
	}

	public HorizontalLayout getVaadinHorizontalLayout2() {
		return vaadinHorizontalLayout2;
	}

	public void setVaadinHorizontalLayout2(HorizontalLayout vaadinHorizontalLayout2) {
		this.vaadinHorizontalLayout2 = vaadinHorizontalLayout2;
	}

	public TextField getNombre() {
		return nombre;
	}

	public void setNombre(TextField nombre) {
		this.nombre = nombre;
	}

	public TextField getApellidos() {
		return apellidos;
	}

	public void setApellidos(TextField apellidos) {
		this.apellidos = apellidos;
	}

	public TextField getCorreo() {
		return correo;
	}

	public void setCorreo(TextField correo) {
		this.correo = correo;
	}



	public Button getVaadinButton1() {
		return vaadinButton1;
	}

	public void setVaadinButton1(Button vaadinButton1) {
		this.vaadinButton1 = vaadinButton1;
	}

	public Element getVaadinVerticalLayout1() {
		return vaadinVerticalLayout1;
	}

	public void setVaadinVerticalLayout1(Element vaadinVerticalLayout1) {
		this.vaadinVerticalLayout1 = vaadinVerticalLayout1;
	}

	public Image getImagen_trabajador() {
		return imagen_trabajador;
	}

	public void setImagen_trabajador(Image imagen_trabajador) {
		this.imagen_trabajador = imagen_trabajador;
	}


	public Element getVaadinVerticalLayout2() {
		return vaadinVerticalLayout2;
	}

	public void setVaadinVerticalLayout2(Element vaadinVerticalLayout2) {
		this.vaadinVerticalLayout2 = vaadinVerticalLayout2;
	}

	public Button getBoton_guardar() {
		return boton_guardar;
	}

	public void setBoton_guardar(Button boton_guardar) {
		this.boton_guardar = boton_guardar;
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



	public TextField getPuesto() {
		return puesto;
	}

	public void setPuesto(TextField puesto) {
		this.puesto = puesto;
	}

	public ComboBox<String> getPuestoDeTrabajo() {
		return puestoDeTrabajo;
	}

	public void setPuestoDeTrabajo(ComboBox<String> puestoDeTrabajo) {
		this.puestoDeTrabajo = puestoDeTrabajo;
	}

	public HorizontalLayout getHueco_upload() {
		return hueco_upload;
	}

	public void setHueco_upload(HorizontalLayout hueco_upload) {
		this.hueco_upload = hueco_upload;
	}
}
