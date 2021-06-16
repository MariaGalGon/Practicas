package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-listacategoriasposibles template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listacategoriasposibles")
@JsModule("./src/vista-listacategoriasposibles.js")
public class VistaListacategoriasposibles extends PolymerTemplate<VistaListacategoriasposibles.VistaListacategoriasposiblesModel> {

    @Id("lista_categoria_posible")
	private Element lista_categoria_posible;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_aniadir_categoria_posible")
	private Button boton_aniadir_categoria_posible;
	@Id("boton_cancelar")
	private Button boton_cancelar;

	/**
     * Creates a new VistaListacategoriasposibles.
     */
    public VistaListacategoriasposibles() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListacategoriasposibles and vista-listacategoriasposibles
     */
    public interface VistaListacategoriasposiblesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getLista_categoria_posible() {
		return lista_categoria_posible;
	}

	public void setLista_categoria_posible(Element lista_categoria_posible) {
		this.lista_categoria_posible = lista_categoria_posible;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Button getBoton_aniadir_categoria_posible() {
		return boton_aniadir_categoria_posible;
	}

	public void setBoton_aniadir_categoria_posible(Button boton_aniadir_categoria_posible) {
		this.boton_aniadir_categoria_posible = boton_aniadir_categoria_posible;
	}

	public Button getBoton_cancelar() {
		return boton_cancelar;
	}

	public void setBoton_cancelar(Button boton_cancelar) {
		this.boton_cancelar = boton_cancelar;
	}
}
