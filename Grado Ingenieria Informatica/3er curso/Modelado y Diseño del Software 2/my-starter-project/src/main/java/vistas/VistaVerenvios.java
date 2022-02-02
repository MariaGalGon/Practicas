package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import vistas.VistaListaenvios;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-verenvios template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verenvios")
@JsModule("./src/vista-verenvios.js")
public class VistaVerenvios extends PolymerTemplate<VistaVerenvios.VistaVerenviosModel> {

    @Id("cabecera")
	private HorizontalLayout cabecera;
	@Id("h2")
	private H2 h2;
	@Id("logo")
	private Image logo;
	@Id("tab_envios")
	private Button tab_envios;
	@Id("tabs_perfil")
	private Button tabs_perfil;
	@Id("layout_envios")
	private Element layout_envios;
	/**
     * Creates a new VistaVerenvios.
     */
    public VistaVerenvios() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerenvios and vista-verenvios
     */
    public interface VistaVerenviosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera() {
		return cabecera;
	}

	public void setCabecera(HorizontalLayout cabecera) {
		this.cabecera = cabecera;
	}

	public H2 getH2() {
		return h2;
	}

	public void setH2(H2 h2) {
		this.h2 = h2;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Button getTab_envios() {
		return tab_envios;
	}

	public void setTab_envios(Button tab_envios) {
		this.tab_envios = tab_envios;
	}

	public Button getTabs_perfil() {
		return tabs_perfil;
	}

	public void setTabs_perfil(Button tabs_perfil) {
		this.tabs_perfil = tabs_perfil;
	}

	public Element getLayout_envios() {
		return layout_envios;
	}

	public void setLayout_envios(Element layout_envios) {
		this.layout_envios = layout_envios;
	}
}
