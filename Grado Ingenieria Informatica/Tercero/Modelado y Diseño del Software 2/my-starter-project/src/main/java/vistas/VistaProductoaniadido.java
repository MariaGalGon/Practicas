package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;

/**
 * A Designer generated component for the vista-productoaniadido template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productoaniadido")
@JsModule("./src/vista-productoaniadido.js")
public class VistaProductoaniadido extends PolymerTemplate<VistaProductoaniadido.VistaProductoaniadidoModel> {

    @Id("imagen_producto_aniadido")
	private Image imagen_producto_aniadido;
	@Id("informacion_producto_aniadido")
	private HorizontalLayout informacion_producto_aniadido;
	@Id("nombre_producto_aniadido")
	private Label nombre_producto_aniadido;
	@Id("precio_producto_aniadido")
	private Paragraph precio_producto_aniadido;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_eliminar_producto_aniadido")
	private Button boton_eliminar_producto_aniadido;
	@Id("cantidad_producto_aniadido")
	private ComboBox<String> cantidad_producto_aniadido;

	/**
     * Creates a new VistaProductoaniadido.
     */
    public VistaProductoaniadido() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProductoaniadido and vista-productoaniadido
     */
    public interface VistaProductoaniadidoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Image getImagen_producto_aniadido() {
		return imagen_producto_aniadido;
	}

	public void setImagen_producto_aniadido(Image imagen_producto_aniadido) {
		this.imagen_producto_aniadido = imagen_producto_aniadido;
	}

	public HorizontalLayout getInformacion_producto_aniadido() {
		return informacion_producto_aniadido;
	}

	public void setInformacion_producto_aniadido(HorizontalLayout informacion_producto_aniadido) {
		this.informacion_producto_aniadido = informacion_producto_aniadido;
	}

	public Label getNombre_producto_aniadido() {
		return nombre_producto_aniadido;
	}

	public void setNombre_producto_aniadido(Label nombre_producto_aniadido) {
		this.nombre_producto_aniadido = nombre_producto_aniadido;
	}

	public Paragraph getPrecio_producto_aniadido() {
		return precio_producto_aniadido;
	}

	public void setPrecio_producto_aniadido(Paragraph precio_producto_aniadido) {
		this.precio_producto_aniadido = precio_producto_aniadido;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Button getBoton_eliminar_producto_aniadido() {
		return boton_eliminar_producto_aniadido;
	}

	public void setBoton_eliminar_producto_aniadido(Button boton_eliminar_producto_aniadido) {
		this.boton_eliminar_producto_aniadido = boton_eliminar_producto_aniadido;
	}

	public ComboBox<String> getCantidad_producto_aniadido() {
		return cantidad_producto_aniadido;
	}

	public void setCantidad_producto_aniadido(ComboBox<String> cantidad_producto_aniadido) {
		this.cantidad_producto_aniadido = cantidad_producto_aniadido;
	}
}
