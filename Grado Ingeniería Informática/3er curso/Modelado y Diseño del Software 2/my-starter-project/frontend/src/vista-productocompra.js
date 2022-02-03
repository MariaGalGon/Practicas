import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';

class VistaProductocompra extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			background-color: #f5f5f5;
        			border-radius: 10px;
                }
            </style>
<vaadin-vertical-layout style=" margin-bottom: var(--lumo-space-m); padding: var(--lumo-space-xl); padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m); justify-content: flex-start; align-items: center; padding-top: var(--lumo-space-s);">
 <img id="foto" style="flex-grow: 0; align-self: center; border-radius: 10px;  background-color: #f5f5f5;">
 <vaadin-horizontal-layout theme="spacing" style="align-items: center; align-self: stretch; flex-grow: 0;">
  <label id="nombre" style="font-weight: bold;"></label>
  <vaadin-checkbox id="checkbox_listo" style="align-self: center;">
    Listo 
  </vaadin-checkbox>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-items: center; align-self: stretch; flex-grow: 0; margin-bottom: var(--lumo-space-xl);">
  <label id="cantidad" style="font-weight: bold;">Cantidad:</label>
  <p id="numero_cantidad" style="align-self: center;"></p>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-productocompra';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductocompra.is, VistaProductocompra);
