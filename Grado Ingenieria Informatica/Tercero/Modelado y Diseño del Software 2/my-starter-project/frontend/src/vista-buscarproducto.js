import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-listaresultadosbusquedaadministrador.js';
import './vista-listaresultados.js';
import './vista-listaresultadosbusqueda.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';

class VistaBuscarproducto extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; align-items: stretch;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; width: 100%;" id="cabecera_admin_buscar_producto">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo_admin">
  <vaadin-text-field placeholder="Producto" style="flex-grow: 1;" id="barra_busqueda_producto"></vaadin-text-field>
  <vaadin-button id="boton_buscar">
    Buscar 
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
   <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; width: 100%;" id="cabecera_cibernauta_buscar_producto">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu1">
   <iron-icon icon="lumo:menu" id="icono_menu1"></iron-icon>
  </vaadin-button>
  <img id="logo_user">
  <vaadin-text-field placeholder="search..." style="flex-grow: 1;" id="barra_busqueda"></vaadin-text-field>
  <vaadin-button id="boton_buscar1">
    Buscar 
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_carrito">
   <iron-icon icon="vaadin:cart" id="icono_carrito"></iron-icon>
  </vaadin-button>
  <label id="label_contador" style="align-self: center;"></label>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil1">
   <iron-icon icon="lumo:user" id="icono_perfil1"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="resultados" style="align-self: stretch; flex-wrap: wrap;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-buscarproducto';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaBuscarproducto.is, VistaBuscarproducto);
