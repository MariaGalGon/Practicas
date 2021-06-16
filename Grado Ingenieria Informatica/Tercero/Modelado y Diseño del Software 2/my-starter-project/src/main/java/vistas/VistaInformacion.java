package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.datepicker.DatePicker;

/**
 * A Designer generated component for the vista-informacion template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-informacion")
@JsModule("./src/vista-informacion.js")
public class VistaInformacion extends PolymerTemplate<VistaInformacion.VistaInformacionModel> {

    
	
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("vaadinVerticalLayout1")
	private Element vaadinVerticalLayout1;
	@Id("text_descripcion")
	private TextArea text_descripcion;
	@Id("condicionesDelDescuento")
	private TextArea condicionesDelDescuento;
	@Id("fecha")
	private DatePicker fecha;


	/**
     * Creates a new VistaInformacion.
     */
    public VistaInformacion() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaInformacion and vista-informacion
     */
    public interface VistaInformacionModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Element getVaadinVerticalLayout1() {
		return vaadinVerticalLayout1;
	}

	public void setVaadinVerticalLayout1(Element vaadinVerticalLayout1) {
		this.vaadinVerticalLayout1 = vaadinVerticalLayout1;
	}

	public TextArea getText_descripcion() {
		return text_descripcion;
	}

	public void setText_descripcion(TextArea text_descripcion) {
		this.text_descripcion = text_descripcion;
	}

	public TextArea getCondicionesDelDescuento() {
		return condicionesDelDescuento;
	}

	public void setCondicionesDelDescuento(TextArea condicionesDelDescuento) {
		this.condicionesDelDescuento = condicionesDelDescuento;
	}

	public DatePicker getFecha() {
		return fecha;
	}

	public void setFecha(DatePicker fecha) {
		this.fecha = fecha;
	}

	
	
}
