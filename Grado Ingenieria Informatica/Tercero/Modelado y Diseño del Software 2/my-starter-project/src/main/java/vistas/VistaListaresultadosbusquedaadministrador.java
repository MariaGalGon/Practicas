package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaProductoresultado;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-listaresultadosbusquedaadministrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaresultadosbusquedaadministrador")
@JsModule("./src/vista-listaresultadosbusquedaadministrador.js")
public class VistaListaresultadosbusquedaadministrador extends PolymerTemplate<VistaListaresultadosbusquedaadministrador.VistaListaresultadosbusquedaadministradorModel> {

    @Id("lista_elementos_producto_resultado")
	private HorizontalLayout lista_elementos_producto_resultado;
	
	@Id("boton_aniadir_producto")
	private Button boton_aniadir_producto;

	/**
     * Creates a new VistaListaresultadosbusquedaadministrador.
     */
    public VistaListaresultadosbusquedaadministrador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaresultadosbusquedaadministrador and vista-listaresultadosbusquedaadministrador
     */
    public interface VistaListaresultadosbusquedaadministradorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getLista_elementos_producto_resultado() {
		return lista_elementos_producto_resultado;
	}

	public void setLista_elementos_producto_resultado(HorizontalLayout lista_elementos_producto_resultado) {
		this.lista_elementos_producto_resultado = lista_elementos_producto_resultado;
	}

	public Button getBoton_aniadir_producto() {
		return boton_aniadir_producto;
	}

	public void setBoton_aniadir_producto(Button boton_aniadir_producto) {
		this.boton_aniadir_producto = boton_aniadir_producto;
	}
}
