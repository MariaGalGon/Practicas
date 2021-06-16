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
 * A Designer generated component for the vista-productopedido template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productopedido")
@JsModule("./src/vista-productopedido.js")
public class VistaProductopedido extends PolymerTemplate<VistaProductopedido.VistaProductopedidoModel> {

    @Id("par_pedido")
	private HorizontalLayout par_pedido;
	@Id("id_pedido")
	private Label id_pedido;
	@Id("estado_pedido")
	private Paragraph estado_pedido;
	@Id("boton_ver_mas")
	private Button boton_ver_mas;

	/**
     * Creates a new VistaProductopedido.
     */
    public VistaProductopedido() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProductopedido and vista-productopedido
     */
    public interface VistaProductopedidoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getPar_pedido() {
		return par_pedido;
	}

	public void setPar_pedido(HorizontalLayout par_pedido) {
		this.par_pedido = par_pedido;
	}

	public Label getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Label id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Paragraph getEstado_pedido() {
		return estado_pedido;
	}

	public void setEstado_pedido(Paragraph estado_pedido) {
		this.estado_pedido = estado_pedido;
	}

	public Button getBoton_ver_mas() {
		return boton_ver_mas;
	}

	public void setBoton_ver_mas(Button boton_ver_mas) {
		this.boton_ver_mas = boton_ver_mas;
	}
}
