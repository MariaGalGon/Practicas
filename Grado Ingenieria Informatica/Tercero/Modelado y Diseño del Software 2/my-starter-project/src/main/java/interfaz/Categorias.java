package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaListacategorias;

public class Categorias extends VistaListacategorias{
	public Editar_productos_categoria editCateg;
	public iAdministrador adm;
	ListBox<Categoria> lista;
	Categoria[] categoriaInterfaz;
	Seleccionar_categorias seleccionarCategorias;
	VerticalLayout vertical;
	int[] ids;

	public Categorias() {
		inicializar();
	}

	public void inicializar() {
		adm = new BDPrincipal();
		seleccionarCategorias = new Seleccionar_categorias();
		vertical = this.getVaadinVerticalLayout().as(VerticalLayout.class);

		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");

		lista = this.getLista_categorias().as(ListBox.class);
		lista.clear();

		editCateg = new Editar_productos_categoria();

		cargar_lista_categorias();
		seleccionar();

	}

	private void seleccionar() {
		//Acceder a lista seleccionar
		this.getBoton_seleccionar_categoria().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				getLista_categorias().setVisible(false);
				getBotones().setVisible(false);
				vertical.add(seleccionarCategorias);
			}
		});

		//Salir lista seleccionar
		seleccionarCategorias.getBoton_cancelar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				vertical.remove(seleccionarCategorias);
				getLista_categorias().setVisible(true);
				getBotones().setVisible(true);
			}
		});

	}

	private void cargar_lista_categorias() {
		basedatos.Categoria[] categoriasBD = adm.cargar_categorias();

		categoriaInterfaz = new Categoria[categoriasBD.length];
		ids = new int[categoriasBD.length];

		for(int i = 0; i < categoriasBD.length; i++) {
			Categoria c = new Categoria();
			c.getNombre_categoria().setText(categoriasBD[i].getNombe());

			categoriaInterfaz[i] = c;			
			ids[i] = categoriasBD[i].getIdCategoria();
			lista.add(c);
		}
	}


}