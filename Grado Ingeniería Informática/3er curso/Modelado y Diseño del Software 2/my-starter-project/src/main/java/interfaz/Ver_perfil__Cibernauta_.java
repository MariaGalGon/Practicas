package interfaz;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_identificado;
import basedatos.iCibernauta_no_identificado;
import basedatos.iComun;
import imagenes.Uploader;


public class Ver_perfil__Cibernauta_ extends Ver_perfil_ampliado {


	basedatos.Producto[] bdProductos;
	public iComun comun = new BDPrincipal();
	Ver_datos__Cibernauta_ datosCibernauta;
	VerticalLayout contenido_tabs = this.getContenido_tabs().as(VerticalLayout.class);
	Ver_pedidos pedidos = new Ver_pedidos();
	Ver_mensajes mensajes = new Ver_mensajes(true);
	Dar_de_baja baja = new Dar_de_baja();
	public VerticalLayout layout;
	private iCibernauta_identificado cibernauta = new BDPrincipal();
	private iCibernauta_no_identificado cni = new BDPrincipal();
	String foto= "/img/perfil2.png";

	public Ver_perfil__Cibernauta_ () {
		super();
		inicializar();
	}

	public void inicializar() {
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		this.getTitulo_admin().setVisible(false);
		this.getBotones_repartidor().setVisible(false);
		datosCibernauta = new Ver_datos__Cibernauta_();

		contenido_tabs.add(datosCibernauta);		

		datosCibernauta.datos.getId_repartidor().setVisible(false);
		datosCibernauta.datos.getNombre_apellidos().setVisible(false);

		tabs();
		cargarDatos();
		baja();
		botones();		
		upload();
	}

	private void tabs() {
		VerticalLayout layout_tabs = this.getLayout_tabs().as(VerticalLayout.class);
		layout_tabs.removeAll();

		Tab tab1 = new Tab("Datos");

		tab1.setSelected(true);

		Tab tab2 = new Tab("Pedidos");

		Tab tab3 = new Tab("Mensajes");


		Tabs tabs = new Tabs(true, tab1, tab2, tab3);

		tabs.addSelectedChangeListener(event -> {
			String seleccion = event.getSelectedTab().getLabel();

			if(seleccion.equals("Datos")) {
				contenido_tabs.add(datosCibernauta);
				contenido_tabs.remove(pedidos);
				contenido_tabs.remove(mensajes);

			}else if(seleccion.equals("Pedidos")) {
				pedidos.inicializar();
				contenido_tabs.add(pedidos);
				contenido_tabs.remove(datosCibernauta);
				contenido_tabs.remove(mensajes);

			}else if(seleccion.equals("Mensajes")) {
				mensajes.inicializar();
				mensajes.id = Cibernauta_identificado.usuario.getIdUsuario();
				mensajes.cib = true;
				contenido_tabs.add(mensajes);
				contenido_tabs.remove(datosCibernauta);
				contenido_tabs.remove(pedidos);
			}
		});

		layout_tabs.add(tabs);	
	}

	public void buscar_producto() {
		bdProductos = comun.buscar_producto(this.getBarra_busqueda().getValue());
	}

	public void botones() {
		datosCibernauta.datos.getBoton_guardar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				guardar_datos();
			}
		});

		datosCibernauta.datos.getBoton_cerrar_sesion().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {				 				
				Cibernauta_no_identificado cni = new Cibernauta_no_identificado();
				layout.removeAll();
				layout.add(cni);				
			}
		});
	}

	private void cargarDatos() {
		basedatos.Cibernauta cib = Cibernauta_identificado.usuario;

		datosCibernauta.datos.getNombre().setValue(cib.getNombre());
		datosCibernauta.datos.getApellidos().setValue(cib.getApellidos());
		datosCibernauta.datos.getCorreo().setValue(cib.getCorreo());
		datosCibernauta.datos.getContrasenia().setValue(cib.getContrasena());
		datosCibernauta.datos.getDireccion_envio().setValue(cib.getDireccion());
		datosCibernauta.datos.getNumero_cuenta().setValue(Integer.toString(cib.getTarjeta()));
		datosCibernauta.datos.getCvv().setValue(Integer.toString(cib.getCvv()));
		foto = cib.getFoto();
		actualizar_foto();
	}

	public void guardar_datos() {
		basedatos.Cibernauta cib = Cibernauta_identificado.usuario;

		String[] datos = new String[7];
		datos[0] = datosCibernauta.datos.getNombre().getValue();
		datos[1] = datosCibernauta.datos.getApellidos().getValue();
		datos[2] = datosCibernauta.datos.getCorreo().getValue();
		datos[3] = datosCibernauta.datos.getContrasenia().getValue();		
		datos[4] = datosCibernauta.datos.getDireccion_envio().getValue();
		datos[5] = datosCibernauta.datos.getNumero_cuenta().getValue();
		datos[6] = datosCibernauta.datos.getCvv().getValue();

		cibernauta.guardar_datos(datos, cib.getIdUsuario(), foto); //Coger foto de verdad

		cni.cargar_cibernauta(Cibernauta_identificado.usuario.getIdUsuario());

		Notification.show("Datos guardados");
	}	

	private void baja() {
		//Pop-up dar de baja
		datosCibernauta.getDar_de_baja().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				contenido_tabs.add(baja);

			}
		});

		//Cancelar dar de baja
		baja.getBoton_cancelar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				contenido_tabs.remove(baja);

			}
		});

		//Confirmar dar de baja
		baja.getBoton_confirmar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				Cibernauta_no_identificado cni = new Cibernauta_no_identificado(true);
				cni.confirmarBaja.idUsuario = Cibernauta_identificado.usuario.getIdUsuario();
				cni.confirmarBaja.confirmar_baja();

				layout.removeAll();
				layout.add(cni);

			}
		});
	}
	
	public void upload() {
		MemoryBuffer buffer = new MemoryBuffer();
		Upload upload = new Upload(buffer);

		upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");
		Div output = new Div();

		upload.addSucceededListener(event -> {
			//  Component component = createComponent(event.getMIMEType(), event.getFileName(), buffer.getInputStream());
			File targetFile = new File("src/main/resources/targetFile.tmp");
			try {
				FileUtils.copyInputStreamToFile(buffer.getInputStream(), targetFile);
				//	FileUtils.copyInputStramtoFile(buffer.)
			}catch(IOException e) {
				e.printStackTrace();
			}
			//  showOutput(event.getFileName(), component, output);
			
				String foto1 ="https://i.imgur.com/"+ Uploader.upload(targetFile).subSequence(15, 22)+".png";
				foto = foto1;
				actualizar_foto();
		});
		upload.addFileRejectedListener(event -> {
			Paragraph component = new Paragraph();
			showOutput(event.getErrorMessage(), component, output);
		});
		upload.getElement().addEventListener("file-remove", event -> {
			output.removeAll();
		});
		
		datosCibernauta.imagen.getHueco_upload().removeAll();
		datosCibernauta.imagen.getHueco_upload().add(upload, output);

	}

	private Component createComponent(String mimeType, String fileName,
			InputStream stream) {
		if (mimeType.startsWith("text")) {
			return createTextComponent(stream);
		} else if (mimeType.startsWith("image")) {
			Image image = new Image();
			try {

				byte[] bytes = IOUtils.toByteArray(stream);
				image.getElement().setAttribute("src", new StreamResource(
						fileName, () -> new ByteArrayInputStream(bytes)));
				try (ImageInputStream in = ImageIO.createImageInputStream(
						new ByteArrayInputStream(bytes))) {
					final Iterator<ImageReader> readers = ImageIO
							.getImageReaders(in);
					if (readers.hasNext()) {
						ImageReader reader = readers.next();
						try {
							reader.setInput(in);
							image.setWidth(reader.getWidth(0) + "px");
							image.setHeight(reader.getHeight(0) + "px");
						} finally {
							reader.dispose();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.setSizeFull();
			return image;
		}
		Div content = new Div();
		String text = String.format("Mime type: '%s'\nSHA-256 hash: '%s'",
				mimeType, MessageDigestUtil.sha256(stream.toString()));
		content.setText(text);
		return content;

	}
	private Component createTextComponent(InputStream stream) {
		String text;
		try {
			text = IOUtils.toString(stream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			text = "exception reading stream";
		}
		return new Text(text);
	}
	private void showOutput(String text, Component content,
			HasComponents outputContainer) {
		HtmlComponent p = new HtmlComponent(Tag.P);
		p.getElement().setText(text);
		outputContainer.add(p);
		outputContainer.add(content);
	}

	public void actualizar_foto() {
		if(foto.equals("Foto")) {
			foto= "/img/perfil2.png";
		}
			
		datosCibernauta.imagen.getImg().setSrc(foto);
		datosCibernauta.imagen.getImg().setHeight("8em");

	}
}