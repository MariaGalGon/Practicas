package interfaz;

import java.util.ArrayList;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaAniadircategoriaproducto;

public class Aniadir_categoria_producto extends VistaAniadircategoriaproducto{
	public Categorias_posibles _categorias_posibles;
	public Buscar_categoria _buscar_categoria;
	VerticalLayout vertical;
	iAdministrador adm = new BDPrincipal();
	basedatos.Categoria[] bdCategorias;
	Categoria_producto[] categoriaInterfaz;
	int ids[];
	ArrayList<Integer> idsSeleccionados;

	public Aniadir_categoria_producto() {
		inicializar();
	}

	public void inicializar() {

		_categorias_posibles = new Categorias_posibles();
		_buscar_categoria = new Buscar_categoria();
		vertical = this.getVaadinVerticalLayout().as(VerticalLayout.class);

		vertical.removeAll();
		vertical.add(_buscar_categoria);
		vertical.add(_categorias_posibles);
		cargar_categorias();
		botones();
	}

	private void botones() {
		_buscar_categoria.getVaadinButton().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				buscar_categoria();

			}
		});

	}

	public void cargar_categorias() {
		// TODO Auto-generated method stub
		bdCategorias = adm.cargar_categorias();
		categoriaInterfaz = new Categoria_producto[bdCategorias.length];
		ids = new int[bdCategorias.length];

		_categorias_posibles.lista.removeAll();
		for(int i = 0; i<bdCategorias.length; i++) {
			categoriaInterfaz[i] = new Categoria_producto();
			ids[i] = bdCategorias[i].getIdCategoria();

			categoriaInterfaz[i].getCheckbox_categoria_producto().setLabel(bdCategorias[i].getNombe());
			_categorias_posibles.lista.add(categoriaInterfaz[i]);
		}

	}

	public void buscar_categoria() {
		bdCategorias = adm.buscar_categoria(_buscar_categoria.getBarra_buscar_categoria().getValue());

		_categorias_posibles.lista.removeAll();
		ids = new int[bdCategorias.length];

		categoriaInterfaz = new Categoria_producto[bdCategorias.length];
		for(int i = 0; i < bdCategorias.length; i++) {
			categoriaInterfaz[i] = new Categoria_producto();
			ids[i] = bdCategorias[i].getIdCategoria();

			categoriaInterfaz[i].getCheckbox_categoria_producto().setLabel(bdCategorias[i].getNombe());
			_categorias_posibles.lista.add(categoriaInterfaz[i]);
		}
	}

	public void actualizarSeleccionados() {
		idsSeleccionados = new ArrayList<Integer>();

		for(int i = 0; i < categoriaInterfaz.length; i++) {
			if(categoriaInterfaz[i].getCheckbox_categoria_producto().getValue()) {
				idsSeleccionados.add(ids[i]);
			}
		}
	}

}