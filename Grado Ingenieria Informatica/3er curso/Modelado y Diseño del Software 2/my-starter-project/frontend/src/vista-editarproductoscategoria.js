import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import './vista-listaproductosasociados.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class VistaEditarproductoscategoria extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" id="cabecera_categorias" style="align-self: stretch; flex-grow: 0; align-items: center; margin: var(--lumo-space-s);">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h2 id="titulo_categorias">Categorías</h2>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="flex-grow: 1; justify-content: flex-end;">
   <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
    <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="cuadro_info" style="align-self: stretch; align-items: center; margin: var(--lumo-space-xl); margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs);">
  <vaadin-text-field label="Nombre" placeholder="" id="nombre_categoria"></vaadin-text-field>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="flex-grow: 1; justify-content: flex-end;">
   <vaadin-button id="boton_guardar">
     Guardar 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-editarproductoscategoria';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEditarproductoscategoria.is, VistaEditarproductoscategoria);
