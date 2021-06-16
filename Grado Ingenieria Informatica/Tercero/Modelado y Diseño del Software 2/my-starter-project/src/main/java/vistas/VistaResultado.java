package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.checkbox.Checkbox;

/**
 * A Designer generated component for the vista-resultado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-resultado")
@JsModule("./src/vista-resultado.js")
public class VistaResultado extends PolymerTemplate<VistaResultado.VistaResultadoModel> {

    @Id("imagen_resultado")
	private Image imagen_resultado;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("nombre_resultado")
	private Label nombre_resultado;
	@Id("checkbox_resultado")
	private Checkbox checkbox_resultado;

	/**
     * Creates a new VistaResultado.
     */
    public VistaResultado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaResultado and vista-resultado
     */
    public interface VistaResultadoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Image getImagen_resultado() {
		return imagen_resultado;
	}

	public void setImagen_resultado(Image imagen_resultado) {
		this.imagen_resultado = imagen_resultado;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Label getNombre_resultado() {
		return nombre_resultado;
	}

	public void setNombre_resultado(Label nombre_resultado) {
		this.nombre_resultado = nombre_resultado;
	}

	public Checkbox getCheckbox_resultado() {
		return checkbox_resultado;
	}

	public void setCheckbox_resultado(Checkbox checkbox_resultado) {
		this.checkbox_resultado = checkbox_resultado;
	}
}
