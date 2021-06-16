package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.combobox.ComboBox;

/**
 * A Designer generated component for the vista-listaproductosdestacados template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaproductosdestacados")
@JsModule("./src/vista-listaproductosdestacados.js")
public class VistaListaproductosdestacados extends PolymerTemplate<VistaListaproductosdestacados.VistaListaproductosdestacadosModel> {

    @Id("cabecera_lista_productos")
	private HorizontalLayout cabecera_lista_productos;
	@Id("titulo_lista_productos")
	private H2 titulo_lista_productos;
	@Id("combobox_lista_productos")
	private ComboBox<String> combobox_lista_productos;
	@Id("cuadro_lista_boton")
	private HorizontalLayout cuadro_lista_boton;
	@Id("horizontalFuera")
	private HorizontalLayout horizontalFuera;
	/**
     * Creates a new VistaListaproductosdestacados.
     */
    public VistaListaproductosdestacados() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaproductosdestacados and vista-listaproductosdestacados
     */
    public interface VistaListaproductosdestacadosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	

	public HorizontalLayout getCabecera_lista_productos() {
		return cabecera_lista_productos;
	}

	public void setCabecera_lista_productos(HorizontalLayout cabecera_lista_productos) {
		this.cabecera_lista_productos = cabecera_lista_productos;
	}

	public H2 getTitulo_lista_productos() {
		return titulo_lista_productos;
	}

	public void setTitulo_lista_productos(H2 titulo_lista_productos) {
		this.titulo_lista_productos = titulo_lista_productos;
	}

	public ComboBox<String> getCombobox_lista_productos() {
		return combobox_lista_productos;
	}

	public void setCombobox_lista_productos(ComboBox<String> combobox_lista_productos) {
		this.combobox_lista_productos = combobox_lista_productos;
	}

	public HorizontalLayout getCuadro_lista_boton() {
		return cuadro_lista_boton;
	}

	public void setCuadro_lista_boton(HorizontalLayout cuadro_lista_boton) {
		this.cuadro_lista_boton = cuadro_lista_boton;
	}

	public HorizontalLayout getHorizontalFuera() {
		return horizontalFuera;
	}

	public void setHorizontalFuera(HorizontalLayout horizontalFuera) {
		this.horizontalFuera = horizontalFuera;
	}

}
