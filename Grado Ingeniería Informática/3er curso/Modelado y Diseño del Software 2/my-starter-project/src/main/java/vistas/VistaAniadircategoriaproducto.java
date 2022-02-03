package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import vistas.VistaListacategoriasposibles;
import vistas.VistaBuscarcategoria;

/**
 * A Designer generated component for the vista-aniadircategoriaproducto template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-aniadircategoriaproducto")
@JsModule("./src/vista-aniadircategoriaproducto.js")
public class VistaAniadircategoriaproducto extends PolymerTemplate<VistaAniadircategoriaproducto.VistaAniadircategoriaproductoModel> {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	/**
     * Creates a new VistaAniadircategoriaproducto.
     */
    public VistaAniadircategoriaproducto() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaAniadircategoriaproducto and vista-aniadircategoriaproducto
     */
    public interface VistaAniadircategoriaproductoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	
}
