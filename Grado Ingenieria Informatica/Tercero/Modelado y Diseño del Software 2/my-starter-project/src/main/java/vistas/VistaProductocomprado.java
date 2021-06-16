package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;

/**
 * A Designer generated component for the vista-productocomprado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productocomprado")
@JsModule("./src/vista-productocomprado.js")
public class VistaProductocomprado extends PolymerTemplate<VistaProductocomprado.VistaProductocompradoModel> {

    @Id("par_producto_comprado")
	private Element par_producto_comprado;
	@Id("img_producto")
	private Image img_producto;
	@Id("hor1")
	private HorizontalLayout hor1;
	@Id("nombre")
	private Label nombre;
	@Id("precio")
	private Paragraph precio;
	@Id("hor2")
	private HorizontalLayout hor2;
	@Id("cantidad")
	private Label cantidad;
	@Id("contador_cantidad")
	private Paragraph contador_cantidad;

	/**
     * Creates a new VistaProductocomprado.
     */
    public VistaProductocomprado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProductocomprado and vista-productocomprado
     */
    public interface VistaProductocompradoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getPar_producto_comprado() {
		return par_producto_comprado;
	}

	public void setPar_producto_comprado(Element par_producto_comprado) {
		this.par_producto_comprado = par_producto_comprado;
	}

	public Image getImg_producto() {
		return img_producto;
	}

	public void setImg_producto(Image img_producto) {
		this.img_producto = img_producto;
	}

	public HorizontalLayout getHor1() {
		return hor1;
	}

	public void setHor1(HorizontalLayout hor1) {
		this.hor1 = hor1;
	}

	public Label getNombre() {
		return nombre;
	}

	public void setNombre(Label nombre) {
		this.nombre = nombre;
	}

	public Paragraph getPrecio() {
		return precio;
	}

	public void setPrecio(Paragraph precio) {
		this.precio = precio;
	}

	public HorizontalLayout getHor2() {
		return hor2;
	}

	public void setHor2(HorizontalLayout hor2) {
		this.hor2 = hor2;
	}

	public Label getCantidad() {
		return cantidad;
	}

	public void setCantidad(Label cantidad) {
		this.cantidad = cantidad;
	}

	public Paragraph getContador_cantidad() {
		return contador_cantidad;
	}

	public void setContador_cantidad(Paragraph contador_cantidad) {
		this.contador_cantidad = contador_cantidad;
	}
}
