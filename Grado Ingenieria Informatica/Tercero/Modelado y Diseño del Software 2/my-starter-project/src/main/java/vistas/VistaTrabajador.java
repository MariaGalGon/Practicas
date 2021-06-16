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
 * A Designer generated component for the vista-trabajador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-trabajador")
@JsModule("./src/vista-trabajador.js")
public class VistaTrabajador extends PolymerTemplate<VistaTrabajador.VistaTrabajadorModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("id_trabajador")
	private Label id_trabajador;
	@Id("estado_trabajdor")
	private Paragraph estado_trabajdor;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("vaadinButton")
	private Button vaadinButton;

	/**
     * Creates a new VistaTrabajador.
     */
    public VistaTrabajador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaTrabajador and vista-trabajador
     */
    public interface VistaTrabajadorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Label getId_trabajador() {
		return id_trabajador;
	}

	public void setId_trabajador(Label id_trabajador) {
		this.id_trabajador = id_trabajador;
	}

	public Paragraph getEstado_trabajdor() {
		return estado_trabajdor;
	}

	public void setEstado_trabajdor(Paragraph estado_trabajdor) {
		this.estado_trabajdor = estado_trabajdor;
	}

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public Button getVaadinButton() {
		return vaadinButton;
	}

	public void setVaadinButton(Button vaadinButton) {
		this.vaadinButton = vaadinButton;
	}
}
