package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-recuperarcontrasenia template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-recuperarcontrasenia")
@JsModule("./src/vista-recuperarcontrasenia.js")
public class VistaRecuperarcontrasenia extends PolymerTemplate<VistaRecuperarcontrasenia.VistaRecuperarcontraseniaModel> {

    @Id("titulo")
	private H1 titulo;
	@Id("informacion")
	private Paragraph informacion;
	@Id("correo")
	private TextField correo;
	@Id("boton_recuperar")
	private Button boton_recuperar;

	/**
     * Creates a new VistaRecuperarcontrasenia.
     */
    public VistaRecuperarcontrasenia() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaRecuperarcontrasenia and vista-recuperarcontrasenia
     */
    public interface VistaRecuperarcontraseniaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public H1 getTitulo() {
		return titulo;
	}

	public void setTitulo(H1 titulo) {
		this.titulo = titulo;
	}

	public Paragraph getInformacion() {
		return informacion;
	}

	public void setInformacion(Paragraph informacion) {
		this.informacion = informacion;
	}

	public TextField getCorreo() {
		return correo;
	}

	public void setCorreo(TextField correo) {
		this.correo = correo;
	}

	public Button getBoton_recuperar() {
		return boton_recuperar;
	}

	public void setBoton_recuperar(Button boton_recuperar) {
		this.boton_recuperar = boton_recuperar;
	}
}
