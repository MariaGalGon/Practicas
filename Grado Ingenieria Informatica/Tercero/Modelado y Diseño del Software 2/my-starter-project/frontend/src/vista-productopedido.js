import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

class VistaProductopedido extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout theme="spacing" id="par_pedido" style="width: 100%; align-items: center; margin-bottom: var(--lumo-space-m); background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);">
 <label style="margin-right: var(--lumo-space-m); font-weight: bold; padding-right: var(--lumo-space-l);" id="id_pedido"></label>
 <p style="align-self: center; flex-grow: 1;" id="estado_pedido"></p>
 <vaadin-button style="align-self: center; flex-grow: 0;" id="boton_ver_mas">
   Ver mas 
 </vaadin-button>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-productopedido';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductopedido.is, VistaProductopedido);
