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
 * A Designer generated component for the vista-categoriaproducto template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-categoriaproducto")
@JsModule("./src/vista-categoriaproducto.js")
public class VistaCategoriaproducto extends PolymerTemplate<VistaCategoriaproducto.VistaCategoriaproductoModel> {

    @Id("par_categoria_producto")
	private HorizontalLayout par_categoria_producto;
	@Id("checkbox_categoria_producto")
	private Checkbox checkbox_categoria_producto;
	@Id("descripcion_categoria_producto")
	private Paragraph descripcion_categoria_producto;

	/**
     * Creates a new VistaCategoriaproducto.
     */
    public VistaCategoriaproducto() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCategoriaproducto and vista-categoriaproducto
     */
    public interface VistaCategoriaproductoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getPar_categoria_producto() {
		return par_categoria_producto;
	}

	public void setPar_categoria_producto(HorizontalLayout par_categoria_producto) {
		this.par_categoria_producto = par_categoria_producto;
	}

	public Checkbox getCheckbox_categoria_producto() {
		return checkbox_categoria_producto;
	}

	public void setCheckbox_categoria_producto(Checkbox checkbox_categoria_producto) {
		this.checkbox_categoria_producto = checkbox_categoria_producto;
	}

	public Paragraph getDescripcion_categoria_producto() {
		return descripcion_categoria_producto;
	}

	public void setDescripcion_categoria_producto(Paragraph descripcion_categoria_producto) {
		this.descripcion_categoria_producto = descripcion_categoria_producto;
	}
}
