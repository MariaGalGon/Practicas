package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-producto template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-producto")
@JsModule("./src/vista-producto.js")
public class VistaProducto extends PolymerTemplate<VistaProducto.VistaProductoModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("label_oferta_producto")
	private Label label_oferta_producto;
	@Id("fecha_oferta_producto")
	private Paragraph fecha_oferta_producto;
	@Id("imagen_producto")
	private Image imagen_producto;
	@Id("precio_producto")
	private Paragraph precio_producto;
	@Id("nombre_producto")
	private Label nombre_producto;
	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("tachado")
	private Paragraph tachado;
	/**
     * Creates a new VistaProducto.
     */
    public VistaProducto() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProducto and vista-producto
     */
    public interface VistaProductoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Label getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(Label nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Label getLabel_oferta_producto() {
		return label_oferta_producto;
	}

	public void setLabel_oferta_producto(Label label_oferta_producto) {
		this.label_oferta_producto = label_oferta_producto;
	}

	public Paragraph getFecha_oferta_producto() {
		return fecha_oferta_producto;
	}

	public void setFecha_oferta_producto(Paragraph fecha_oferta_producto) {
		this.fecha_oferta_producto = fecha_oferta_producto;
	}

	public Image getImagen_producto() {
		return imagen_producto;
	}

	public void setImagen_producto(Image imagen_producto) {
		this.imagen_producto = imagen_producto;
	}

	public Paragraph getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(Paragraph precio_producto) {
		this.precio_producto = precio_producto;
	}

	public VerticalLayout getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(VerticalLayout vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Paragraph getTachado() {
		return tachado;
	}

	public void setTachado(Paragraph tachado) {
		this.tachado = tachado;
	}
}
