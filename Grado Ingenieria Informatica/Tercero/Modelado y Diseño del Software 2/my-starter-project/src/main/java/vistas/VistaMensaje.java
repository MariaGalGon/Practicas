package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-mensaje template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-mensaje")
@JsModule("./src/vista-mensaje.js")
public class VistaMensaje extends PolymerTemplate<VistaMensaje.VistaMensajeModel> {

    @Id("vendedor")
	private Label vendedor;
	@Id("asunto")
	private Paragraph asunto;
	@Id("fecha")
	private Paragraph fecha;
	@Id("vertical")
	private HorizontalLayout vertical;

	/**
     * Creates a new VistaMensaje.
     */
    public VistaMensaje() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaMensaje and vista-mensaje
     */
    public interface VistaMensajeModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Label getVendedor() {
		return vendedor;
	}

	public void setVendedor(Label vendedor) {
		this.vendedor = vendedor;
	}

	public Paragraph getAsunto() {
		return asunto;
	}

	public void setAsunto(Paragraph asunto) {
		this.asunto = asunto;
	}

	public Paragraph getFecha() {
		return fecha;
	}

	public void setFecha(Paragraph fecha) {
		this.fecha = fecha;
	}

	public HorizontalLayout getVertical() {
		return vertical;
	}

	public void setVertical(HorizontalLayout vertical) {
		this.vertical = vertical;
	}
}
