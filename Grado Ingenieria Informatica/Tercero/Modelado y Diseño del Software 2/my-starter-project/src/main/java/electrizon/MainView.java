package electrizon;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import basedatos.BD_Administrador;
import interfaz.Cibernauta_no_identificado;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
	
	public Cibernauta_no_identificado cni = new Cibernauta_no_identificado();
	
    public MainView() {
    	this.setAlignItems(Alignment.STRETCH);   	
    	
    	add(cni);
    	
    	comprobarAdmin();
    	comprobarEncargado();
    	comprobarRepartidor();
    }
    
    //Si no existe un administrador por defecto se crea
    public void comprobarAdmin() {
    	try {
    		basedatos.BD_Administrador _administrador = new basedatos.BD_Administrador();
        	_administrador.existeAdmin();
    	} catch (PersistentException e) {
			e.printStackTrace();
		}    	
    }
    
    //Si no existe un encargado por defecto se crea
    public void comprobarEncargado() {
    	try {
    		basedatos.BD_Encargado _encargado = new basedatos.BD_Encargado();
        	_encargado.existeEncargado();
    	} catch (PersistentException e) {
			e.printStackTrace();
		}    	
    }
    
  //Si no existe un repartidor por defecto se crea
    public void comprobarRepartidor() {
    	try {
    		basedatos.BD_Repartidor _repartidor = new basedatos.BD_Repartidor();
    		_repartidor.existeRepartidor();
    	} catch (PersistentException e) {
			e.printStackTrace();
		}    	
    }
}
