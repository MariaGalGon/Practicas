package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-verdatosimagen template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verdatosimagen")
@JsModule("./src/vista-verdatosimagen.js")
public class VistaVerdatosimagen extends PolymerTemplate<VistaVerdatosimagen.VistaVerdatosimagenModel> {

    @Id("cuadro_seleccionar_img")
	private Element cuadro_seleccionar_img;
	@Id("img")
	private Image img;
	@Id("hueco_upload")
	private HorizontalLayout hueco_upload;
	/**
     * Creates a new VistaVerdatosimagen.
     */
    public VistaVerdatosimagen() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerdatosimagen and vista-verdatosimagen
     */
    public interface VistaVerdatosimagenModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getCuadro_seleccionar_img() {
		return cuadro_seleccionar_img;
	}

	public void setCuadro_seleccionar_img(Element cuadro_seleccionar_img) {
		this.cuadro_seleccionar_img = cuadro_seleccionar_img;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public HorizontalLayout getHueco_upload() {
		return hueco_upload;
	}

	public void setHueco_upload(HorizontalLayout hueco_upload) {
		this.hueco_upload = hueco_upload;
	}


}
