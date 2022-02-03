package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-nuevomensaje template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-nuevomensaje")
@JsModule("./src/vista-nuevomensaje.js")
public class VistaNuevomensaje extends PolymerTemplate<VistaNuevomensaje.VistaNuevomensajeModel> {

    @Id("titulo")
	private H3 titulo;
	@Id("destinatario")
	private TextField destinatario;
	@Id("asunto")
	private TextField asunto;
	@Id("mensaje")
	private TextArea mensaje;
	@Id("boton_enviar")
	private Button boton_enviar;

	/**
     * Creates a new VistaNuevomensaje.
     */
    public VistaNuevomensaje() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaNuevomensaje and vista-nuevomensaje
     */
    public interface VistaNuevomensajeModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public H3 getTitulo() {
		return titulo;
	}

	public void setTitulo(H3 titulo) {
		this.titulo = titulo;
	}

	public TextField getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(TextField destinatario) {
		this.destinatario = destinatario;
	}

	public TextField getAsunto() {
		return asunto;
	}

	public void setAsunto(TextField asunto) {
		this.asunto = asunto;
	}

	public TextArea getMensaje() {
		return mensaje;
	}

	public void setMensaje(TextArea mensaje) {
		this.mensaje = mensaje;
	}

	public Button getBoton_enviar() {
		return boton_enviar;
	}

	public void setBoton_enviar(Button boton_enviar) {
		this.boton_enviar = boton_enviar;
	}
}
