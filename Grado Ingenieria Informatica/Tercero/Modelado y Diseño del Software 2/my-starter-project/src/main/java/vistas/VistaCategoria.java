package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-categoria template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-categoria")
@JsModule("./src/vista-categoria.js")
public class VistaCategoria extends PolymerTemplate<VistaCategoria.VistaCategoriaModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("nombre_categoria")
	private Label nombre_categoria;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("boton_editar_productos")
	private Button boton_editar_productos;
	/**
     * Creates a new VistaCategoria.
     */
    public VistaCategoria() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCategoria and vista-categoria
     */
    public interface VistaCategoriaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	/*public Checkbox getCheckbox_categoria() {
		return checkbox_categoria;
	}

	public void setCheckbox_categoria(Checkbox checkbox_categoria) {
		this.checkbox_categoria = checkbox_categoria;
	}*/

	

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Label getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(Label nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public Button getBoton_editar_productos() {
		return boton_editar_productos;
	}

	public void setBoton_editar_productos(Button boton_editar_productos) {
		this.boton_editar_productos = boton_editar_productos;
	}
}
