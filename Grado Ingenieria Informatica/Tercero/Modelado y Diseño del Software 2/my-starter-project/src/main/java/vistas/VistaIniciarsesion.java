package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.PasswordField;

/**
 * A Designer generated component for the vista-iniciarsesion template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-iniciarsesion")
@JsModule("./src/vista-iniciarsesion.js")
public class VistaIniciarsesion extends PolymerTemplate<VistaIniciarsesion.VistaIniciarsesionModel> {

    @Id("web_titulo")
	private H1 titulo;
	@Id("web_correo")
	private TextField correo;
	@Id("web_enlace_recuperar_contrasenia")
	private Element enlace_recuperar_contrasenia;
	@Id("web_boton_iniciar_sesion")
	private Button boton_iniciar_sesion;
	@Id("web_boton_crear_cuenta")
	private Button boton_crear_cuenta;
	@Id("web")
	private Element web;
	@Id("contrasenia")
	private PasswordField contrasenia;

	/**
     * Creates a new VistaIniciarsesion.
     */
    public VistaIniciarsesion() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaIniciarsesion and vista-iniciarsesion
     */
    public interface VistaIniciarsesionModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public H1 getTitulo() {
		return titulo;
	}

	public void setTitulo(H1 titulo) {
		this.titulo = titulo;
	}

	public TextField getCorreo() {
		return correo;
	}

	public void setCorreo(TextField correo) {
		this.correo = correo;
	}

	public Element getEnlace_recuperar_contrasenia() {
		return enlace_recuperar_contrasenia;
	}

	public void setEnlace_recuperar_contrasenia(Element enlace_recuperar_contrasenia) {
		this.enlace_recuperar_contrasenia = enlace_recuperar_contrasenia;
	}

	public Button getBoton_iniciar_sesion() {
		return boton_iniciar_sesion;
	}

	public void setBoton_iniciar_sesion(Button boton_iniciar_sesion) {
		this.boton_iniciar_sesion = boton_iniciar_sesion;
	}

	public Button getBoton_crear_cuenta() {
		return boton_crear_cuenta;
	}

	public void setBoton_crear_cuenta(Button boton_crear_cuenta) {
		this.boton_crear_cuenta = boton_crear_cuenta;
	}


	public Element getWeb() {
		return web;
	}

	public void setWeb(Element web) {
		this.web = web;
	}

	public void setContrasenia(PasswordField contrasenia) {
		this.contrasenia = contrasenia;
	}

	public PasswordField getContrasenia() {
		return contrasenia;
	}
}
