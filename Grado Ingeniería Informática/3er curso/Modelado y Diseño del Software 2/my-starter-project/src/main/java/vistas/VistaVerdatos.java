package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.PasswordField;

/**
 * A Designer generated component for the vista-verdatos template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verdatos")
@JsModule("./src/vista-verdatos.js")
public class VistaVerdatos extends PolymerTemplate<VistaVerdatos.VistaVerdatosModel> {

    @Id("ver_datos")
	private Element ver_datos;
	@Id("cuadro_nombre_apellidos")
	private HorizontalLayout cuadro_nombre_apellidos;
	@Id("nombre")
	private TextField nombre;
	@Id("apellidos")
	private TextField apellidos;
	@Id("nombre_apellidos")
	private TextField nombre_apellidos;
	@Id("correo")
	private TextField correo;
	@Id("boton_guardar")
	private Button boton_guardar;
	@Id("boton_cerrar_sesion")
	private Button boton_cerrar_sesion;
	@Id("direccion_envio")
	private TextField direccion_envio;
	@Id("numero_cuenta")
	private TextField numero_cuenta;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("cvv")
	private TextField cvv;
	@Id("id_repartidor")
	private TextField id_repartidor;
	@Id("contrasenia")
	private PasswordField contrasenia;

	/**
     * Creates a new VistaVerdatos.
     */
    public VistaVerdatos() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerdatos and vista-verdatos
     */
    public interface VistaVerdatosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVer_datos() {
		return ver_datos;
	}

	public void setVer_datos(Element ver_datos) {
		this.ver_datos = ver_datos;
	}

	public HorizontalLayout getCuadro_nombre_apellidos() {
		return cuadro_nombre_apellidos;
	}

	public void setCuadro_nombre_apellidos(HorizontalLayout cuadro_nombre_apellidos) {
		this.cuadro_nombre_apellidos = cuadro_nombre_apellidos;
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

	public TextField getNombre_apellidos() {
		return nombre_apellidos;
	}

	public void setNombre_apellidos(TextField nombre_apellidos) {
		this.nombre_apellidos = nombre_apellidos;
	}

	public TextField getCorreo() {
		return correo;
	}

	public void setCorreo(TextField correo) {
		this.correo = correo;
	}

	public Button getBoton_guardar() {
		return boton_guardar;
	}

	public void setBoton_guardar(Button boton_guardar) {
		this.boton_guardar = boton_guardar;
	}

	public Button getBoton_cerrar_sesion() {
		return boton_cerrar_sesion;
	}

	public void setBoton_cerrar_sesion(Button boton_cerrar_sesion) {
		this.boton_cerrar_sesion = boton_cerrar_sesion;
	}

	public TextField getDireccion_envio() {
		return direccion_envio;
	}

	public void setDireccion_envio(TextField direccion_envio) {
		this.direccion_envio = direccion_envio;
	}

	public TextField getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(TextField numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public TextField getCvv() {
		return cvv;
	}

	public void setCvv(TextField cvv) {
		this.cvv = cvv;
	}

	public TextField getId_repartidor() {
		return id_repartidor;
	}

	public void setId_repartidor(TextField id_repartidor) {
		this.id_repartidor = id_repartidor;
	}

	public PasswordField getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(PasswordField contrasenia) {
		this.contrasenia = contrasenia;
	}
}
