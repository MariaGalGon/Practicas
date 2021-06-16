import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box-dropdown-wrapper.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import './vista-productopedido.js';

class VistaListapedidos extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; padding: var(--lumo-space-s);">
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; align-items: center;" id="cabecera">
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center;" id="boton_menu">
   <iron-icon icon="lumo:menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h1 style="align-self: center;" id="seccion">Pedidos</h1>
 </vaadin-horizontal-layout>
 <vaadin-combo-box id="elegir_estado"></vaadin-combo-box>
 <vaadin-vertical-layout theme="spacing" id="lista_pedidos" style="align-self: stretch;"></vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listapedidos';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListapedidos.is, VistaListapedidos);
