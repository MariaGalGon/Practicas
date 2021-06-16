package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.H2;

/**
 * A Designer generated component for the vista-listaproductosasociados template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaproductosasociados")
@JsModule("./src/vista-listaproductosasociados.js")
public class VistaListaproductosasociados extends PolymerTemplate<VistaListaproductosasociados.VistaListaproductosasociadosModel> {

	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("lista_productos_asociados")
	private Element lista_productos_asociados;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("boton_aniadir")
	private Button boton_aniadir;
	@Id("boton_eliminar")
	private Button boton_eliminar;

	/**
     * Creates a new VistaListaproductosasociados.
     */
    public VistaListaproductosasociados() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaproductosasociados and vista-listaproductosasociados
     */
    public interface VistaListaproductosasociadosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Element getLista_productos_asociados() {
		return lista_productos_asociados;
	}

	public void setLista_productos_asociados(Element lista_productos_asociados) {
		this.lista_productos_asociados = lista_productos_asociados;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Button getBoton_aniadir() {
		return boton_aniadir;
	}

	public void setBoton_aniadir(Button boton_aniadir) {
		this.boton_aniadir = boton_aniadir;
	}

	public Button getBoton_eliminar() {
		return boton_eliminar;
	}

	public void setBoton_eliminar(Button boton_eliminar) {
		this.boton_eliminar = boton_eliminar;
	}
}
