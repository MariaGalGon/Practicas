package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-crearcuenta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-crearcuenta")
@JsModule("./src/vista-crearcuenta.js")
public class VistaCrearcuenta extends PolymerTemplate<VistaCrearcuenta.VistaCrearcuentaModel> {

    @Id("usuario")
	private TextField usuario;
	@Id("correo")
	private TextField correo;
	@Id("nombre")
	private TextField nombre;
	@Id("apellidos")
	private TextField apellidos;
	@Id("foto")
	private Image foto;
	@Id("direccion")
	private TextField direccion;
	@Id("cuenta")
	private TextField cuenta;
	@Id("boton_crear_cuenta")
	private Button boton_crear_cuenta;
	@Id("verticalLayout")
	private Element verticalLayout;
	@Id("contrasenia")
	private PasswordField contrasenia;
	@Id("confirma_cont")
	private PasswordField confirma_cont;
	@Id("hueco_upload")
	private Element hueco_upload;
	@Id("hueco")
	private HorizontalLayout hueco;
	/**
     * Creates a new VistaCrearcuenta.
     */
    public VistaCrearcuenta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCrearcuenta and vista-crearcuenta
     */
    public interface VistaCrearcuentaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public TextField getUsuario() {
		return usuario;
	}

	public void setUsuario(TextField usuario) {
		this.usuario = usuario;
	}

	public TextField getCorreo() {
		return correo;
	}

	public void setCorreo(TextField correo) {
		this.correo = correo;
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

	public Image getFoto() {
		return foto;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}

	public TextField getDireccion() {
		return direccion;
	}

	public void setDireccion(TextField direccion) {
		this.direccion = direccion;
	}

	public TextField getCuenta() {
		return cuenta;
	}

	public void setCuenta(TextField cuenta) {
		this.cuenta = cuenta;
	}

	public Button getBoton_crear_cuenta() {
		return boton_crear_cuenta;
	}

	public void setBoton_crear_cuenta(Button boton_crear_cuenta) {
		this.boton_crear_cuenta = boton_crear_cuenta;
	}

	public Element getVerticalLayout() {
		return verticalLayout;
	}

	public void setVerticalLayout(Element verticalLayout) {
		this.verticalLayout = verticalLayout;
	}

	public PasswordField getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(PasswordField contrasenia) {
		this.contrasenia = contrasenia;
	}

	public PasswordField getConfirma_cont() {
		return confirma_cont;
	}

	public void setConfirma_cont(PasswordField confirma_cont) {
		this.confirma_cont = confirma_cont;
	}

	public Element getHueco_upload() {
		return hueco_upload;
	}

	public void setHueco_upload(Element hueco_upload) {
		this.hueco_upload = hueco_upload;
	}

	public HorizontalLayout getHueco() {
		return hueco;
	}

	public void setHueco(HorizontalLayout hueco) {
		this.hueco = hueco;
	}
}
