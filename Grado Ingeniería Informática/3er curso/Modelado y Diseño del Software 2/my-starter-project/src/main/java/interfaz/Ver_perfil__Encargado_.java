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
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_no_identificado;
import basedatos.iEncargado_compras;
import imagenes.Uploader;

public class Ver_perfil__Encargado_ extends Ver_perfil__imagen_ {

	Ver_datos__Cibernauta_ datosEncargado;
	VerticalLayout contenido_tabs = this.getContenido_tabs().as(VerticalLayout.class);
	public VerticalLayout layout;
	private iEncargado_compras encargado = new BDPrincipal();
	private iCibernauta_no_identificado cni = new BDPrincipal();
	String foto= "/img/perfil2.png";

	public Ver_perfil__Encargado_ () {
		super();
		inicializar();
	}
	
	public void inicializar() {
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		this.getTitulo_admin().setVisible(false);
		this.getBoton_carrito().setVisible(false);
		this.getContador().setVisible(false);
		this.getBarra_busqueda().setVisible(false);
		this.getBoton_buscar().setVisible(false);
		this.getBoton_perfil().setVisible(false);
		this.getBotones_repartidor().setVisible(false);
		
		datosEncargado = new Ver_datos__Cibernauta_();
		datosEncargado.getDar_de_baja().setVisible(false);
		datosEncargado.datos.getId_repartidor().setVisible(false);
		datosEncargado.datos.getNumero_cuenta().setVisible(false);
		datosEncargado.datos.getCvv().setVisible(false);
		datosEncargado.datos.getDireccion_envio().setVisible(false);
		datosEncargado.datos.getNombre_apellidos().setVisible(false);
		contenido_tabs.add(datosEncargado);
		
		cargarDatos();
		botones();
		upload();
	}
	
	private void botones() {
		datosEncargado.datos.getBoton_guardar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				guardar_datos();
			}
		});
		
		datosEncargado.datos.getBoton_cerrar_sesion().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {				 				
				Cibernauta_no_identificado cni = new Cibernauta_no_identificado();
				layout.removeAll();
				layout.add(cni);				
			}
		});
	}
	
	private void cargarDatos() {
		basedatos.Encargado_compras enc = Encargado_compras.usuario;
		
		datosEncargado.datos.getNombre().setValue(enc.getNombre());
		datosEncargado.datos.getApellidos().setValue(enc.getApellidos());
		datosEncargado.datos.getCorreo().setValue(enc.getCorreo());
		datosEncargado.datos.getContrasenia().setValue(enc.getContrasena());	
		foto = enc.getFoto();
		actualizar_foto();

	}
	
	public void guardar_datos() {
		basedatos.Encargado_compras enc = Encargado_compras.usuario;
		
		String[] datos = new String[6];
		datos[0] = "Encargado";
		datos[1] = datosEncargado.datos.getNombre().getValue();
		datos[2] = datosEncargado.datos.getApellidos().getValue();
		datos[3] = datosEncargado.datos.getCorreo().getValue();
		datos[4] = datosEncargado.datos.getContrasenia().getValue();
		datos[5] = foto;


		encargado.guardar_datos(datos, enc.getIdUsuario());
		
		cni.cargar_encargado(Encargado_compras.usuario.getIdUsuario());
		
		Notification.show("Datos guardados");
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
		
		datosEncargado.imagen.getHueco_upload().removeAll();
		datosEncargado.imagen.getHueco_upload().add(upload, output);

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
		if(foto == null) {
			return;
		}
		if(foto.equals("Foto")) {
			foto= "/img/perfil2.png";
		}
			
		datosEncargado.imagen.getImg().setSrc(foto);
		datosEncargado.imagen.getImg().setHeight("8em");

	}
	
	
}