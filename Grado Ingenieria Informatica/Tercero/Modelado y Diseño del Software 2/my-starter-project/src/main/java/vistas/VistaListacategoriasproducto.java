package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaCategoria;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-listacategoriasproducto template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listacategoriasproducto")
@JsModule("./src/vista-listacategoriasproducto.js")
public class VistaListacategoriasproducto extends PolymerTemplate<VistaListacategoriasproducto.VistaListacategoriasproductoModel> {

	@Id("cuadro_botones")
	private HorizontalLayout cuadro_botones;
	@Id("boton_aniadir_categoria_producto")
	private Button boton_aniadir_categoria_producto;
	@Id("boton_eliminar_categoria_producto")
	private Button boton_eliminar_categoria_producto;
	@Id("lista_categorias_producto")
	private Element lista_categorias_producto;

	/**
     * Creates a new VistaListacategoriasproducto.
     */
    public VistaListacategoriasproducto() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListacategoriasproducto and vista-listacategoriasproducto
     */
    public interface VistaListacategoriasproductoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }






	public HorizontalLayout getCuadro_botones() {
		return cuadro_botones;
	}

	public void setCuadro_botones(HorizontalLayout cuadro_botones) {
		this.cuadro_botones = cuadro_botones;
	}

	public Button getBoton_aniadir_categoria_producto() {
		return boton_aniadir_categoria_producto;
	}

	public void setBoton_aniadir_categoria_producto(Button boton_aniadir_categoria_producto) {
		this.boton_aniadir_categoria_producto = boton_aniadir_categoria_producto;
	}

	public Button getBoton_eliminar_categoria_producto() {
		return boton_eliminar_categoria_producto;
	}

	public void setBoton_eliminar_categoria_producto(Button boton_eliminar_categoria_producto) {
		this.boton_eliminar_categoria_producto = boton_eliminar_categoria_producto;
	}

	public Element getLista_categorias_producto() {
		return lista_categorias_producto;
	}

	public void setLista_categorias_producto(Element lista_categorias_producto) {
		this.lista_categorias_producto = lista_categorias_producto;
	}
}
