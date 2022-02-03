package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-mensajeabierto template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-mensajeabierto")
@JsModule("./src/vista-mensajeabierto.js")
public class VistaMensajeabierto extends PolymerTemplate<VistaMensajeabierto.VistaMensajeabiertoModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("remitente")
	private Label remitente;
	@Id("nombre_remitente")
	private Paragraph nombre_remitente;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("asunto")
	private Label asunto;
	@Id("contenido_asunto")
	private Paragraph contenido_asunto;
	@Id("vaadinHorizontalLayout2")
	private HorizontalLayout vaadinHorizontalLayout2;
	@Id("fecha")
	private Label fecha;
	@Id("fecha_contenido")
	private Paragraph fecha_contenido;
	@Id("texto")
	private Label texto;
	@Id("mensaje_contenido")
	private Paragraph mensaje_contenido;
	@Id("boton_responder")
	private Button boton_responder;
	@Id("boton_eliminar")
	private Button boton_eliminar;

	/**
     * Creates a new VistaMensajeabierto.
     */
    public VistaMensajeabierto() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaMensajeabierto and vista-mensajeabierto
     */
    public interface VistaMensajeabiertoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Label getRemitente() {
		return remitente;
	}

	public void setRemitente(Label remitente) {
		this.remitente = remitente;
	}

	public Paragraph getNombre_remitente() {
		return nombre_remitente;
	}

	public void setNombre_remitente(Paragraph nombre_remitente) {
		this.nombre_remitente = nombre_remitente;
	}

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public Label getAsunto() {
		return asunto;
	}

	public void setAsunto(Label asunto) {
		this.asunto = asunto;
	}

	public Paragraph getContenido_asunto() {
		return contenido_asunto;
	}

	public void setContenido_asunto(Paragraph contenido_asunto) {
		this.contenido_asunto = contenido_asunto;
	}

	public HorizontalLayout getVaadinHorizontalLayout2() {
		return vaadinHorizontalLayout2;
	}

	public void setVaadinHorizontalLayout2(HorizontalLayout vaadinHorizontalLayout2) {
		this.vaadinHorizontalLayout2 = vaadinHorizontalLayout2;
	}

	public Label getFecha() {
		return fecha;
	}

	public void setFecha(Label fecha) {
		this.fecha = fecha;
	}

	public Paragraph getFecha_contenido() {
		return fecha_contenido;
	}

	public void setFecha_contenido(Paragraph fecha_contenido) {
		this.fecha_contenido = fecha_contenido;
	}

	public Label getTexto() {
		return texto;
	}

	public void setTexto(Label texto) {
		this.texto = texto;
	}

	public Paragraph getMensaje_contenido() {
		return mensaje_contenido;
	}

	public void setMensaje_contenido(Paragraph mensaje_contenido) {
		this.mensaje_contenido = mensaje_contenido;
	}

	public Button getBoton_responder() {
		return boton_responder;
	}

	public void setBoton_responder(Button boton_responder) {
		this.boton_responder = boton_responder;
	}

	public Button getBoton_eliminar() {
		return boton_eliminar;
	}

	public void setBoton_eliminar(Button boton_eliminar) {
		this.boton_eliminar = boton_eliminar;
	}
}
