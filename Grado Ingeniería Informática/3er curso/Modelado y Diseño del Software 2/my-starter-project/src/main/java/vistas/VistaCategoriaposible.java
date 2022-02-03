package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Paragraph;

/**
 * A Designer generated component for the vista-categoriaposible template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-categoriaposible")
@JsModule("./src/vista-categoriaposible.js")
public class VistaCategoriaposible extends PolymerTemplate<VistaCategoriaposible.VistaCategoriaposibleModel> {

    @Id("par_categoria_posible")
	private HorizontalLayout par_categoria_posible;
	@Id("checkbox_categoria_posible")
	private Checkbox checkbox_categoria_posible;
	@Id("detalles_categoria_posible")
	private Paragraph detalles_categoria_posible;

	/**
     * Creates a new VistaCategoriaposible.
     */
    public VistaCategoriaposible() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCategoriaposible and vista-categoriaposible
     */
    public interface VistaCategoriaposibleModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getPar_categoria_posible() {
		return par_categoria_posible;
	}

	public void setPar_categoria_posible(HorizontalLayout par_categoria_posible) {
		this.par_categoria_posible = par_categoria_posible;
	}

	public Checkbox getCheckbox_categoria_posible() {
		return checkbox_categoria_posible;
	}

	public void setCheckbox_categoria_posible(Checkbox checkbox_categoria_posible) {
		this.checkbox_categoria_posible = checkbox_categoria_posible;
	}

	public Paragraph getDetalles_categoria_posible() {
		return detalles_categoria_posible;
	}

	public void setDetalles_categoria_posible(Paragraph detalles_categoria_posible) {
		this.detalles_categoria_posible = detalles_categoria_posible;
	}
}
