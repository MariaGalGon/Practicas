package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Paragraph;

/**
 * A Designer generated component for the vista-productocompra template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productocompra")
@JsModule("./src/vista-productocompra.js")
public class VistaProductocompra extends PolymerTemplate<VistaProductocompra.VistaProductocompraModel> {

    @Id("foto")
	private Image foto;
	@Id("nombre")
	private Label nombre;
	@Id("checkbox_listo")
	private Checkbox checkbox_listo;
	@Id("cantidad")
	private Label cantidad;
	@Id("numero_cantidad")
	private Paragraph numero_cantidad;

	/**
     * Creates a new VistaProductocompra.
     */
    public VistaProductocompra() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProductocompra and vista-productocompra
     */
    public interface VistaProductocompraModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Image getFoto() {
		return foto;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}

	public Label getNombre() {
		return nombre;
	}

	public void setNombre(Label nombre) {
		this.nombre = nombre;
	}

	public Checkbox getCheckbox_listo() {
		return checkbox_listo;
	}

	public void setCheckbox_listo(Checkbox checkbox_listo) {
		this.checkbox_listo = checkbox_listo;
	}

	public Label getCantidad() {
		return cantidad;
	}

	public void setCantidad(Label cantidad) {
		this.cantidad = cantidad;
	}

	public Paragraph getNumero_cantidad() {
		return numero_cantidad;
	}

	public void setNumero_cantidad(Paragraph numero_cantidad) {
		this.numero_cantidad = numero_cantidad;
	}
}
