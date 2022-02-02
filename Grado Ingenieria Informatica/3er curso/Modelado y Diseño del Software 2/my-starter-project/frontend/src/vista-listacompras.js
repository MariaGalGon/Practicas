import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import './vista-compra.js';

class VistaListacompras extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" id="cabecera_compras" style="align-self: stretch; margin: var(--lumo-space-s); align-items: center;">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu" style="align-self: center;">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h2 id="h2" style="align-self: center;">Listado de Compras</h2>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="flex-grow: 1; justify-content: flex-end; align-self: center;">
   <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil" style="align-self: center;">
    <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" id="lista_compras" style="align-self: stretch; width: 100%; flex-grow: 1;"></vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listacompras';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListacompras.is, VistaListacompras);
