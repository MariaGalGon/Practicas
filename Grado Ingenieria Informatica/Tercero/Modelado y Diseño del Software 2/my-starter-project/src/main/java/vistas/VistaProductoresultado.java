package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-productoresultado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productoresultado")
@JsModule("./src/vista-productoresultado.js")
public class VistaProductoresultado extends PolymerTemplate<VistaProductoresultado.VistaProductoresultadoModel> {

    @Id("imagen_producto_resultado")
	private Image imagen_producto_resultado;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("nombre_producto_resultado")
	private Label nombre_producto_resultado;
	@Id("precio_producto_resultado")
	private Paragraph precio_producto_resultado;
	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;

	/**
     * Creates a new VistaProductoresultado.
     */
    public VistaProductoresultado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProductoresultado and vista-productoresultado
     */
    public interface VistaProductoresultadoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Image getImagen_producto_resultado() {
		return imagen_producto_resultado;
	}

	public void setImagen_producto_resultado(Image imagen_producto_resultado) {
		this.imagen_producto_resultado = imagen_producto_resultado;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Label getNombre_producto_resultado() {
		return nombre_producto_resultado;
	}

	public void setNombre_producto_resultado(Label nombre_producto_resultado) {
		this.nombre_producto_resultado = nombre_producto_resultado;
	}

	public Paragraph getPrecio_producto_resultado() {
		return precio_producto_resultado;
	}

	public void setPrecio_producto_resultado(Paragraph precio_producto_resultado) {
		this.precio_producto_resultado = precio_producto_resultado;
	}

	public VerticalLayout getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(VerticalLayout vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}
}
