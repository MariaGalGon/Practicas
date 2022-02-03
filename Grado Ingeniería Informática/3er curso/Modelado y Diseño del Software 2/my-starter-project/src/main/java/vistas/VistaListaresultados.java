package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaResultado;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-listaresultados template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaresultados")
@JsModule("./src/vista-listaresultados.js")
public class VistaListaresultados extends PolymerTemplate<VistaListaresultados.VistaListaresultadosModel> {

    @Id("lista_elementos_resultado")
	private HorizontalLayout lista_elementos_resultado;
	@Id("boton_aniadir_resultados")
	private Button boton_aniadir_resultados;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaListaresultados.
     */
    public VistaListaresultados() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaresultados and vista-listaresultados
     */
    public interface VistaListaresultadosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getLista_elementos_resultado() {
		return lista_elementos_resultado;
	}

	public void setLista_elementos_resultado(HorizontalLayout lista_elementos_resultado) {
		this.lista_elementos_resultado = lista_elementos_resultado;
	}

	public Button getBoton_aniadir_resultados() {
		return boton_aniadir_resultados;
	}

	public void setBoton_aniadir_resultados(Button boton_aniadir_resultados) {
		this.boton_aniadir_resultados = boton_aniadir_resultados;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}
}
