import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaProductocomprado extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 130%; height: 120%; background-color: #f5f5f5; height: 100%; border-radius: 10px; margin-bottom: var(--lumo-space-m); padding-top: var(--lumo-space-s);" id="par_producto_comprado">
 <img id="img_producto" style="flex-grow: 0; align-self: center; border-radius: 10px;  background-color: #f5f5f5;">
 <vaadin-horizontal-layout theme="spacing" id="hor1" style="align-items: center; align-self: center;">
  <label id="nombre" style="font-weight: bold;"></label>
  <p id="precio"></p>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="hor2" style="align-items: center; align-self: center;">
  <label id="cantidad" style="font-weight: bold;">Cantidad:</label>
  <p id="contador_cantidad"></p>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-productocomprado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductocomprado.is, VistaProductocomprado);
